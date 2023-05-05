package br.com.benezinhobank.model;

import br.com.benezinhobank.pessoa.model.Pessoa;

public class ContaCorrente extends Conta {

    private double limite;

    public boolean sacar(double valor){
        double valorDisponivel = getSaldo() + getLimite();
        if (valor<=0) return false;
        if(valorDisponivel < valor) return false;
        setSaldo(getSaldo()-valor);
        return true;
    }

    public ContaCorrente() {
    }

    public ContaCorrente(double saldo, Agencia agencia, Pessoa titular, String numero, double limite) {
        super(saldo, agencia, titular, numero);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }


    @Override
    public String toString() {
        return "ContaCorrente{" +
                "limite=" + limite +
                "} " + super.toString();
    }
}
