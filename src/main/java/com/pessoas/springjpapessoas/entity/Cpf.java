package com.pessoas.springjpapessoas.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Cpf {

    private static final String[] CPFS_INVALIDOS = {"00000000000", "11111111111", "22222222222", "33333333333", "44444444444", "55555555555", "66666666666", "77777777777", "88888888888", "99999999999"};

    @Id
    private String cpf;

    //Métodos Especiais
    public Cpf() {
    }

    public Cpf(String cpf) {
        Objects.requireNonNull(cpf, "Valor cpf é obrigatório");

        this.cpf = cpf.replace(" ", "").replace(".", "").replace("-", ""); //tira espaços em branco, pontos e traços

        verificaCpf();

        System.out.println("CPF inserido");
    }

    @Override
    public String toString() {
        return "Cpf{" +
                "cpf='" + cpf + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cpf cpf1 = (Cpf) o;
        return cpf.equals(cpf1.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    public String getCpfComMascara() {
        String cpfMascara;

        cpfMascara = cpf.substring(0, 3) + "." +
                cpf.substring(3, 6) + "." +
                cpf.substring(6, 9) + "-" +
                cpf.substring(9, 11);

        System.out.println(cpfMascara);

        return cpfMascara;
    }

    public String getCpfSemMascara() {
        System.out.println(cpf);

        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    //métodos
    private void verificaCpf() {

        verificaNumeroDeDigitosDoCpf();

        verificaSeEstaEmCpfsInvalidos();

        int verificador1 = calculaDigitoVerificadorDoCpf(10);

        verificaSePrimeiroDigitoVerificadorEstaCorreto(verificador1);

        int verificador2 = calculaDigitoVerificadorDoCpf(11);

        verificaSeSegundoDigitoVerificadorEstaCorreto(verificador2);

    }

    private void verificaNumeroDeDigitosDoCpf() {
        if (cpf.length() != 11) {
            throw new RuntimeException("Cpf deve ter 11 dígitos");
        }
    }

    private void verificaSeEstaEmCpfsInvalidos() {
        for (String cpfInvalido : CPFS_INVALIDOS) {
            if (cpf.equals(cpfInvalido)) {
                throw new RuntimeException("Cpf com numeros iguais");
            }
        }
    }

    private int calculaDigitoVerificadorDoCpf(int peso) {
        int numeroCpf;
        int multi;
        int soma = 0;
        int a = 0;
        int b = 1;
        int limiteDoLoop = peso - 1;

        for (int i = 0; i < limiteDoLoop; i++) {
            numeroCpf = Integer.parseInt(cpf.substring(a, b));

            multi = (peso * numeroCpf);

            soma += multi;

            a++;
            b++;
            peso--;
        }

        int verificador = 11 - (soma % 11);

        if (verificador > 9) {
            verificador = 0;
        }

        return verificador;
    }

    private void verificaSePrimeiroDigitoVerificadorEstaCorreto(int verificador) {
        int cpfComparador = Integer.parseInt(cpf.substring(9, 10));

        if (verificador != cpfComparador) {
            throw new RuntimeException("Primeiro verificador errado");
        }
    }

    private void verificaSeSegundoDigitoVerificadorEstaCorreto(int verificador) {
        int cpfComparador = Integer.parseInt(cpf.substring(10, 11));

        if (verificador != cpfComparador) {
            throw new RuntimeException("Segundo verificador errado");
        }
    }

}
