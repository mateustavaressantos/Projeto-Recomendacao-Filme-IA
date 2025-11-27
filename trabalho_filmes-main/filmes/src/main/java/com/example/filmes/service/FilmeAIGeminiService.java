package com.example.filmes.service;

import com.example.filmes.config.GeminiAPI;
import com.example.filmes.dto.FilmeRecomendado;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FilmeAIGeminiService {

    private final RestTemplateBuilder restTemplateBuilder;
    private final GeminiAPI geminiAPI;
    private final FilmeService filmeService;

    public FilmeAIGeminiService(RestTemplateBuilder restTemplateBuilder, GeminiAPI geminiAPI, FilmeService filmeService) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.geminiAPI = geminiAPI;
        this.filmeService = filmeService;
    }

    public List<FilmeRecomendado> recomendarFilmes(String genero) {
        try {
            var rest = restTemplateBuilder.build();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("x-goog-api-key", geminiAPI.getKey());

            // Define o foco da busca da IA
            String categoria = (genero == null || genero.isEmpty())
                    ? "de todas as categorias populares de filmes"
                    : "da categoria '" + genero + "'";

            // PROMPT
            String prompt = String.format("""
                Você é um especialista em cinema e bilheteria. 
                Sua tarefa é listar os 5 filmes com maior bilheteria de todos os tempos, focando %s.
                Para cada filme, forneça o nome, o gênero e uma justificativa breve (explicando porque ele é considerado de alta bilheteria e se encaixa na categoria).
                Devolva o resultado APENAS em formato JSON, seguindo a seguinte estrutura, sem nenhum texto adicional antes ou depois do JSON:
                [
                  {
                    "nome": "Nome do Filme",
                    
                    "genero": "Gênero do Filme",
                    "justificativa": "Breve explicação sobre a bilheteria ou sucesso."
                  }
                ]
            """, categoria);


            // Constrói o Body da Requisição
            String body = String.format("""
            {
              "contents": [
                {
                  "parts": [
                    {
                      "text": "%s"
                    }
                  ]
                }
              ]
            }
            """, prompt.replace("\n", "\\n").replace("\"", "\\\""));

            HttpEntity<String> request = new HttpEntity<>(body, headers);

            // Executa
            ResponseEntity<String> response = rest.exchange(
                    "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash-lite:generateContent",
                    HttpMethod.POST,
                    request,
                    String.class
            );
            String json = response.getBody();

            // Faz a análise do JSON
            ObjectMapper mapper = new ObjectMapper();
            String text = mapper.readTree(json)
                    .path("candidates").get(0)
                    .path("content").path("parts").get(0)
                    .path("text")
                    .asText();

            // Limpa o JSON
            String cleanJson = text
                    .replace("```json", "")
                    .replace("```", "")
                    .trim();

            // Mapeia o JSON
            return mapper.readValue(
                    cleanJson,
                    new TypeReference<List<FilmeRecomendado>>() {}
            );
        } catch (Exception e) {
            e.printStackTrace();
            return List.of(new FilmeRecomendado("Erro na IA", "Sistema", "Não foi possível obter a recomendação de filmes. Verifique a chave da API e a conexão com o Gemini."));
        }
    }
}