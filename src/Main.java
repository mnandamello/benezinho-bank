import br.com.benezinhobank.model.Agencia;
import br.com.benezinhobank.model.Banco;
import br.com.benezinhobank.model.ContaCorrente;
import br.com.benezinhobank.model.ContaPoupanca;
import br.com.benezinhobank.pessoa.model.PessoaFisica;
import br.com.benezinhobank.pessoa.model.PessoaJuridica;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Banco benezinho =  new Banco("Benezinho Bank");

        Agencia osasco = new Agencia();
        osasco.setBanco(benezinho);
        osasco.setNome("Osasco");
        osasco.setNumero("1-9");

        PessoaFisica mae = new PessoaFisica();
        mae.setNome("Raquel Aparecida Ribeiro Mello");
        mae.setNascimento(LocalDate.of(1975,5,25));
        mae.setCPF("257774662-01");

        PessoaFisica maria = new PessoaFisica();
        maria.setCPF("416008977-99");
        maria.setNascimento(LocalDate.of(2004,7,12));
        maria.setNome("Maria Fernanda Ribeiro Mello");

        ContaCorrente cc = new ContaCorrente();
        cc.setAgencia(osasco);
        cc.setTitular(maria);
        cc.setSaldo(1_000);
        cc.setLimite(10_000);
        cc.setNumero("2-8");


        ContaPoupanca cp = new ContaPoupanca();
        cp.setTitular(mae);
        cp.setNumero("3-7");
        cp.setAiversario(4);
        cp.setAgencia(osasco);
        cp.setSaldo(10_000);

        PessoaJuridica holding = new PessoaJuridica();
        holding.setCNPJ("12345/0929-23");
        holding.setNascimento(LocalDate.of(1988,7,5));
        holding.setNome("Percy Holding");
        holding.setRazaoSocial("Percy Holding Jackson");

        ContaCorrente ccH = new ContaCorrente();
        ccH.setNumero("4-6");
        ccH.setLimite(100_000_000);
        ccH.setSaldo(10_000_000);
        ccH.setTitular(holding);
        ccH.setAgencia(osasco);

        System.out.println(ccH);



    }
}