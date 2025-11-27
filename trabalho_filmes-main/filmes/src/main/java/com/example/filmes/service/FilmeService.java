package com.example.filmes.service;

import com.example.filmes.dto.CriarFilmeRequest;
import com.example.filmes.dto.EditarFilmeRequest;
import com.example.filmes.entity.Filme;
import com.example.filmes.repository.FilmeRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public List<Filme> findAll() {
        return filmeRepository.findAll();
    }

    public List<String> findAllGeneros() {
        return filmeRepository.findAllGenero();
    }

    public void adicionarFilmes() {
        var filme = new Filme();
        filme.setNome("");
        filme.setCartazUrl("");
        filme.setGenero("");
        filme.setTempoMinutos(Long.valueOf(""));
        filme.setDescricao("");
        filme.setAvaliacao("");
        filmeRepository.save(filme);
    }

    public Filme criar(CriarFilmeRequest request) {
        StringBuilder builder = new StringBuilder();
        if (Strings.isBlank(request.nome())) {
            builder.append("Favor informar o nome.").append("\n");
        }
        if (Strings.isBlank(request.genero())) {
            builder.append("Favor informar a gênero.").append("\n");
        }
        if(Strings.isBlank(request.avaliacao())){
            builder.append("Favor informar o avaliação.").append("\n");
        }
        if(Strings.isBlank(request.descricao())){
            builder.append("Favor informar o descrição.").append("\n");
        }
        if(Strings.isBlank(request.cartazUrl())){
            builder.append("Favor informar a url do cartaz.").append("\n");
        }
        if (request.tempoMinutos() == null || request.tempoMinutos() <= 0) {
            builder.append("Favor informar o tempo em minutos.").append("\n");
        }
        if (!builder.isEmpty()) {
            throw new RuntimeException(builder.toString());
        }
        var filme = new Filme();
        filme.setNome(request.nome());
        filme.setGenero(request.genero());
        filme.setAvaliacao(request.avaliacao());
        filme.setDescricao(request.descricao());
        filme.setCartazUrl(request.cartazUrl());
        filme.setTempoMinutos(request.tempoMinutos());
        return filmeRepository.save(filme);
    }

    public Optional<Filme> obterPeloId(Long id) {
        return filmeRepository.findById(id);
    }

    public Filme editar(EditarFilmeRequest request) {
        StringBuilder builder = new StringBuilder();
        if(Strings.isBlank(request.nome())){
            builder.append("Favor informar o nome.").append("\n");
        }
        if(Strings.isBlank(request.genero())){
            builder.append("Favor informar a genero.").append("\n");
        }
        if(Strings.isBlank(request.avaliacao())){
            builder.append("Favor informar o avaliação.").append("\n");
        }
        if(Strings.isBlank(request.descricao())){
            builder.append("Favor informar o descrição.").append("\n");
        }
        if(Strings.isBlank(request.cartazUrl())){
            builder.append("Favor informar a url do cartaz.").append("\n");
        }
        if (request.tempoMinutos() == null || request.tempoMinutos() <= 0) {
            builder.append("Favor informar o tempo em minutos.").append("\n");
        }

        if (!builder.isEmpty()) {
            throw new RuntimeException(builder.toString());
        }
        var old = filmeRepository.findById(request.id()).orElseThrow();
        old.setNome(request.nome());
        old.setGenero(request.genero());
        old.setAvaliacao(request.avaliacao());
        old.setDescricao(request.descricao());
        old.setCartazUrl(request.cartazUrl());
        old.setTempoMinutos(request.tempoMinutos());
        return filmeRepository.save(old);
    }

    public void deletarPeloId(Long id) {
        filmeRepository.deleteById(id);
    }

    public Optional<Filme> obterUmFilmeAleatoriamente() {
        var filmes = filmeRepository.findAll();
        if (filmes.isEmpty()) {
            return Optional.empty();
        }
        var random = new Random();
        return Optional.of(filmes.get(random.nextInt(filmes.size())));
    }
}
