package com.example.filmes.controller;

import com.example.filmes.dto.CriarFilmeRequest;
import com.example.filmes.dto.EditarFilmeRequest;
import com.example.filmes.entity.Filme;
import com.example.filmes.service.FilmeAIGeminiService; // Novo Import
import com.example.filmes.service.FilmeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService filmeService;
    private final FilmeAIGeminiService filmeAIGeminiService; // Novo campo para o service de IA

    public FilmeController(FilmeService filmeService, FilmeAIGeminiService filmeAIGeminiService) {
        this.filmeService = filmeService;
        this.filmeAIGeminiService = filmeAIGeminiService;
    }

    @GetMapping
    public ModelAndView index(){
        var mv = new ModelAndView("filmes/listar-filmes"); // <-- CORRIGIDO
        var lista = filmeService.findAll();
        mv.addObject("filmes", lista);
        return mv;
    }

    @GetMapping("/{id}")
    public ModelAndView visualizar(@PathVariable("id") Long id) {
        var optional = filmeService.obterPeloId(id);
        if(optional.isEmpty()){
            return new ModelAndView("filmes/nao_ha_filmes");
        }
        var mv = new ModelAndView("filmes/visualizar-filme"); // <-- CORRIGIDO
        mv.addObject("filme", optional.get());
        return mv;
    }

    @GetMapping("/ai")
    public ModelAndView aiForm() {
        var mv = new ModelAndView("filmes/ai-filmes");
        mv.addObject("generos", filmeService.findAllGeneros());
        // Inicialmente sem resultados de filmes
        mv.addObject("filmesRecomendados", List.of());
        mv.addObject("generoSelecionado", "");
        return mv;
    }

    @PostMapping("/ai")
    public ModelAndView aiAcao(@RequestParam(value = "genero", required = false) String genero) {
        var mv = new ModelAndView("filmes/ai-filmes");

        // Recomenda os filmes usando a IA
        var filmesRecomendados = filmeAIGeminiService.recomendarFilmes(genero);

        // Adiciona de volta os gêneros para o select
        mv.addObject("generos", filmeService.findAllGeneros());
        mv.addObject("filmesRecomendados", filmesRecomendados);
        mv.addObject("generoSelecionado", genero);
        return mv;
    }

    @GetMapping("/criar")
    public ModelAndView criarForm() {
        var mv = new ModelAndView("filmes/novo-filme");
        mv.addObject("criarFilmeRequest", new CriarFilmeRequest(null, null, null, null, null, null));
        return mv;
    }

    @PostMapping("/criar")
    public ModelAndView criarAcao(@ModelAttribute CriarFilmeRequest request) {
        ModelAndView mv;
        try {
            var filme = filmeService.criar(request);
            return new ModelAndView("redirect:/filmes"); // <-- ALTERADO
        } catch (Exception e) {
            mv = new ModelAndView("filmes/novo-filme");
            mv.addObject("criarFilmeRequest", request);
            mv.addObject("erro", e.getMessage());
            return mv;
        }
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarForm(@PathVariable("id") Long id) {
        var optional = filmeService.obterPeloId(id);
        if (optional.isEmpty()) {
            return new ModelAndView("filmes/nao_ha_filmes");
        }
        var mv = new ModelAndView("filmes/editar-filme");
        var filme = optional.get();

        var request = new EditarFilmeRequest(
                filme.getId(),
                filme.getNome(),
                filme.getCartazUrl(),
                filme.getGenero(),
                filme.getTempoMinutos(),
                filme.getDescricao(),
                filme.getAvaliacao()
        );
        mv.addObject("editarFilmeRequest", request); // Objeto para o form
        return mv;
    }

    @PostMapping("/editar/{id}")
    public ModelAndView editarAcao(@PathVariable("id") Long id, @ModelAttribute EditarFilmeRequest request) {
        ModelAndView mv;
        try {
            var requestCorrigido = new EditarFilmeRequest(id, request.nome(), request.cartazUrl(), request.genero(), request.tempoMinutos(), request.descricao(), request.avaliacao());
            var filme = filmeService.editar(requestCorrigido);

            return new ModelAndView("redirect:/filmes"); // <-- ALTERADO
        } catch (Exception e) {
            mv = new ModelAndView("filmes/editar-filme");
            mv.addObject("editarFilmeRequest", request);
            mv.addObject("erro", e.getMessage());
            return mv;
        }
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable("id") Long id) {
        filmeService.deletarPeloId(id);
        return "redirect:/filmes"; // Redireciona para a lista
    }
}