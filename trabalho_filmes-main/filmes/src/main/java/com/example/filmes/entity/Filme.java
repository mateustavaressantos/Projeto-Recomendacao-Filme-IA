package com.example.filmes.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cartazUrl;
    private String genero;
    private Long tempoMinutos;
    private String descricao;
    private String avaliacao;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCartazUrl() {
        return cartazUrl;
    }
    public void setCartazUrl(String cartazUrl) {
        this.cartazUrl = cartazUrl;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Long getTempoMinutos() {
        return tempoMinutos;
    }
    public void setTempoMinutos(Long tempoMinutos) {
        this.tempoMinutos = tempoMinutos;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAvaliacao() {return avaliacao;
    }
    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }
}
