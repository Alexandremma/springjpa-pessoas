package com.pessoas.springjpapessoas.entity;

import com.pessoas.springjpapessoas.converter.CpfConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
//mapear a classe Pessoa para uma tabela chamada "Pessoa" também
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Convert(converter = CpfConverter.class)
    private Cpf cpf;

    private String nome;
    private String ultimoNome;
    private String nomeDoMeio;
    private String apelido;
    private String nomeDoPai;

    public Pessoa() {
    }

    private Pessoa(Cpf cpf, String nome, String ultimoNome, String nomeDoMeio, String apelido, String nomeDoPai) {
        this.cpf = cpf;
        this.nome = nome;
        this.ultimoNome = ultimoNome;
        this.nomeDoMeio = nomeDoMeio;
        this.apelido = apelido;
        this.nomeDoPai = nomeDoPai;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", ultimoNome=" + ultimoNome + ", nomeDoMeio=" + nomeDoMeio + ", apelido="
                + apelido + ", nomeDoPai=" + nomeDoPai + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return id.equals(pessoa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static class PessoaBuilder {
        private Cpf cpf;
        private String nome;
        private String ultimoNome;
        private String nomeDoMeio;
        private String apelido;
        private String nomeDoPai;

        public PessoaBuilder cpf(Cpf cpf) {
            this.cpf = cpf;
            return this;
        }

        public PessoaBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public PessoaBuilder ultimoNome(String ultimoNome) {
            this.ultimoNome = ultimoNome;
            return this;
        }

        public PessoaBuilder nomeDoMeio(String nomeDoMeio) {
            this.nomeDoMeio = nomeDoMeio;
            return this;
        }

        public PessoaBuilder apelido(String apelido) {
            this.apelido = apelido;
            return this;
        }

        public PessoaBuilder nomeDoPai(String nomeDoPai) {
            this.nomeDoPai = nomeDoPai;
            return this;
        }

        public Pessoa criarPessoa() {
            return new Pessoa(cpf, nome, ultimoNome, nomeDoMeio, apelido, nomeDoPai);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public void setCpf(Cpf cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getNomeDoMeio() {
        return nomeDoMeio;
    }

    public void setNomeDoMeio(String nomeDoMeio) {
        this.nomeDoMeio = nomeDoMeio;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNomeDoPai() {
        return nomeDoPai;
    }

    public void setNomeDoPai(String nomeDoPai) {
        this.nomeDoPai = nomeDoPai;
    }
}
