package com.example.filmes.dto;

public record EditarFilmeRequest(Long id, String nome, String cartazUrl, String genero, Long tempoMinutos,
                                 String descricao, String avaliacao) {
}
