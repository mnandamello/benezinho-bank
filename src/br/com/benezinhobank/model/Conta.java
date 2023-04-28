package br.com.benezinhobank.model;

import br.com.benezinhobank.pessoa.model.Pessoa;

public abstract class Conta {

    private double saldo;
    Agencia agencia;
    Pessoa titular;

    public Conta() {
    }

    public Conta(double saldo, Agencia agencia, Pessoa titular) {
        this.saldo = saldo;
        this.agencia = agencia;
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }
}
