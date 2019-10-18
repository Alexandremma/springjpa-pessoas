package com.pessoas.springjpapessoas.service;


import com.pessoas.springjpapessoas.endpoint.PessoaEndpoint;
import com.pessoas.springjpapessoas.entity.Pessoa;
import com.pessoas.springjpapessoas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private final PessoaRepository pessoaDAO; // Repositório de Pessoa

    @Autowired
    public PessoaService(PessoaRepository pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
    }

    public List<Pessoa> listarTodasAsPessoas() {
        return pessoaDAO.findAll();
    }

    public Optional<Pessoa> buscarPessoaPorId(Long id) {
        return pessoaDAO.findById(id);
    }

    public List<Pessoa> buscarPessoaPorApelido(String apelido) {
        return pessoaDAO.findPessoasByApelido(apelido);
    }

    public Pessoa cadastrarPessoa(Pessoa pessoa) {
        pessoaDAO.save(pessoa);
        return pessoa;
    }

    public void deletarPessoa(Long id) {
        pessoaDAO.deleteById(id);
    }

}