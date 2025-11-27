package com.example.filmes.repository;

import com.example.filmes.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme,Long> {

    @Query(value = "select distinct genero from filme order by TRANSLATE(genero, 'ÁÉÍÓÚÂÊÎÔÛÃÕÀÈÌÒÙÇáéíóúâêîôûãõàèìòùç', 'AEIOUAEIOUAEOUCaeiouaeiouaoaeiouc')", nativeQuery = true)
    List<String> findAllGenero();

    List<Filme> findAllByGeneroOrderByNome(String genero);
}
