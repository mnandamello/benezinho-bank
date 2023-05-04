package br.com.benezinhobank.model;

import br.com.benezinhobank.pessoa.model.Pessoa;

public abstract class Conta {

    private double saldo;
    Agencia agencia;
    Pessoa titular;
    private String numero;

    public Conta() {
    }

    public Conta(double saldo, Agencia agencia, Pessoa titular, String numero) {
        this.saldo = saldo;
        this.agencia = agencia;
        this.titular = titular;
        this.numero = numero;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "saldo=" + saldo +
                ", agencia=" + agencia +
                ", titular=" + titular +
                ", numero='" + numero + '\'' +
                '}';
    }
}
