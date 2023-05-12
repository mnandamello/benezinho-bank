package br.com.benezinhobank.pessoa.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

public class PessoaJuridica extends Pessoa{

    private String CNPJ;
    private String razaoSocial;
    //aqui é pra comportar varias pessoas

    private Collection<Pessoa> socios = new Vector<>();

    public PessoaJuridica addSocios(Pessoa socio){
        this.socios.add(socio); //não tem o set pq pessoaJuridica não sabe quantas sócios tera
        return this;
    }

    public PessoaJuridica removeSocios(Pessoa socio){
        this.socios.remove(socio);
        return this;
    }


    public PessoaJuridica() {
    }

    public PessoaJuridica(String nome, LocalDate nascimento, String CNPJ, String razaoSocial, Collection<Pessoa> socios) {
        super(nome, nascimento);
        this.CNPJ = CNPJ;
        this.razaoSocial = razaoSocial;
        this.socios = socios;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }




    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "CNPJ='" + CNPJ + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", socios=" + socios +
                "} " + super.toString();
    }
}
