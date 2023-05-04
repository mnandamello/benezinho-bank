package br.com.benezinhobank.model;

import br.com.benezinhobank.pessoa.model.Pessoa;

public class ContaPoupanca extends Conta{

    private int aiversario;


    public ContaPoupanca() {
    }

    public ContaPoupanca(double saldo, Agencia agencia, Pessoa titular, String numero, int aiversario) {
        super(saldo, agencia, titular, numero);
        this.aiversario = aiversario;
    }

    public int getAiversario() {

        return aiversario;
    }

    public void setAiversario(int aiversario) {
        this.aiversario = aiversario;
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "aiversario=" + aiversario +
                "} " + super.toString();
    }
}
