package com.example.filmes.dto;

public record CriarFilmeRequest(String nome, String cartazUrl, String genero, Long tempoMinutos,
                                String descricao, String avaliacao) {
}
