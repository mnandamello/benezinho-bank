package br.com.benezinhobank.pessoa.model;

import java.time.LocalDate;

public abstract class Pessoa {

    private String nome;
    LocalDate nascimento;
    PessoaFisica pessoaF; //chamou aqui pq a mae tbm é uma pessoa


    public Pessoa() {
    }

    public Pessoa(String nome, LocalDate nascimento, PessoaFisica pessoaF) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.pessoaF = pessoaF;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public PessoaFisica getPessoaF() {
        return pessoaF;
    }

    public void setPessoaF(PessoaFisica pessoaF) {
        this.pessoaF = pessoaF;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", nascimento=" + nascimento +
                ", pessoaF=" + pessoaF +
                '}';
    }
}
