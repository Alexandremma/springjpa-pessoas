package com.pessoas.springjpapessoas.repository;

import com.pessoas.springjpapessoas.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    List<Pessoa> findByNome(String nome);

    List<Pessoa> findByUltimoNome(String ultimoNome);

    boolean existsByNome(String nome);

    @Query(value = "SELECT * FROM PESSOA WHERE apelido = ?1", nativeQuery = true)
    List<Pessoa> findPessoasByApelido(String apelido);

}