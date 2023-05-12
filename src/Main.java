import br.com.benezinhobank.model.Agencia;
import br.com.benezinhobank.model.Banco;
import br.com.benezinhobank.model.ContaCorrente;
import br.com.benezinhobank.model.ContaPoupanca;
import br.com.benezinhobank.pessoa.model.Pessoa;
import br.com.benezinhobank.pessoa.model.PessoaFisica;
import br.com.benezinhobank.pessoa.model.PessoaJuridica;

import javax.swing.*;
import java.time.LocalDate;
import java.time.MonthDay;

public class Main {

    public static Agencia novaAgencia(String nome, Banco banco){

        Agencia agencia = new Agencia();
        agencia.setBanco(banco);
        agencia.setNome(nome);
        banco.addAgencia(agencia);//metodo que pega o numero de contas
        return agencia;
    }

    public static PessoaFisica novaPessoa(String nome, LocalDate nascimento, String CPF, PessoaFisica mae){

        PessoaFisica pf = new PessoaFisica();
        pf.setCPF(CPF);
        pf.setNascimento(nascimento);
        pf.setNome(nome);
        pf.setMae(mae);
        return pf;
    }

    public static PessoaJuridica novaPessoaJuridica(String CNPJ, String razaoSocial, String nomeFantasia, LocalDate fundacao){
        PessoaJuridica pj = new PessoaJuridica();
        pj.setCNPJ(CNPJ);
        pj.setNascimento(fundacao);
        pj.setNome(nomeFantasia);
        pj.setRazaoSocial(razaoSocial);
        return pj;
    }

    public static ContaCorrente novaContaCorrente(Agencia agencia, Pessoa titular, double limite){
        ContaCorrente cc = new ContaCorrente();
        cc.setAgencia(agencia);
        cc.setTitular(titular);
        cc.setLimite(limite);
        agencia.addConta(cc);//numero da conta
        return cc;
    }

    public static ContaPoupanca novaContaPoupanca(Agencia agencia, Pessoa titular, MonthDay dia){
        ContaPoupanca cp = new ContaPoupanca();
        cp.setAgencia(agencia);
        cp.setTitular(titular);
        agencia.addConta(cp);//numero da conta
        cp.setAiversario(dia.getDayOfMonth());
        return cp;
    }

    public static void main(String[] args) {

        Banco benezinho = new Banco("Benezinho Bank");
        Agencia agOsasco = novaAgencia("Osasco", benezinho);
        PessoaFisica mae = novaPessoa("Raquel Aparecida Ribeiro Mello", LocalDate.of(1975, 5, 25), "257774662-01", null);
        PessoaFisica maria = novaPessoa("Maria", LocalDate.of(2004, 7, 12), "416008977-99", mae );
        PessoaFisica lucca = novaPessoa("Lucca" , LocalDate.of(2004, 8, 19), "2516763234-98", mae);
        ContaCorrente cc = novaContaCorrente(agOsasco, maria, 10_000);
        ContaPoupanca cp = novaContaPoupanca(agOsasco, mae, MonthDay.now());
        PessoaJuridica holding = novaPessoaJuridica("12345/0929-23", "Percy Holding Jackson", "Percy Holding", LocalDate.of(1988, 7, 5));
        ContaCorrente cch = novaContaCorrente(agOsasco, holding, 10_000);

        //PessoaFisica mae = new PessoaFisica();
        //mae.setNome("Raquel Aparecida Ribeiro Mello");
        //mae.setNascimento(LocalDate.of(1975, 5, 25));
        //mae.setCPF("257774662-01");

        //PessoaFisica maria = new PessoaFisica();
        //maria.setCPF("416008977-99");
        //maria.setNascimento(LocalDate.of(2004, 7, 12));
        //maria.setNome("Maria Fernanda Ribeiro Mello");
        //maria.setMae(mae);

        //PessoaFisica lucca = new PessoaFisica();
        //lucca.setCPF("2516763234-98");
        //lucca.setNascimento(LocalDate.of(2004, 8, 19));
        //lucca.setMae(mae);
        //lucca.setNome("Lucca Freitas");

        //ContaCorrente cc = new ContaCorrente();
        //cc.setAgencia(agOsasco);
        //cc.setTitular(maria);
        //cc.setSaldo(1_000);
        //cc.setLimite(10_000);
        //cc.setNumero("2-8");

        //ContaPoupanca cp = new ContaPoupanca();
        //cp.setTitular(mae);
        //cp.setNumero("3-7");
        //cp.setAiversario(4);
        //cp.setAgencia(agOsasco);
        //cp.setSaldo(10_000);

        //PessoaJuridica holding = new PessoaJuridica();
        //holding.setCNPJ("12345/0929-23");
        //holding.setNascimento(LocalDate.of(1988, 7, 5));
        //holding.setNome("Percy Holding");
        //holding.setRazaoSocial("Percy Holding Jackson");

        //ContaCorrente ccH = new ContaCorrente();
        //ccH.setNumero("4-6");
        //ccH.setLimite(10_000);
        //ccH.setSaldo(5_000);
        //ccH.setTitular(holding);
        //ccH.setAgencia(agOsasco);

        //Pessoa[] socios = new Pessoa[3];
        //socios[0] = maria;
        //socios[1] = mae;
        //socios[2] = lucca;

        //holding.setSocios(socios);

        holding.addSocios(mae). addSocios(maria).addSocios(lucca);

        //aqui é a pra ficar percorrendo a lista para imprimir os socios
       // for (int i = 0; i < socios.length; i++) {
       //     System.out.println(socios[i]);
       // }


        int continua = 0;

        do{

            System.out.println("-------------------------------------");
            System.out.println("Saldo anterior: " + cch.getSaldo());
            System.out.println("Limite: " + cch.getLimite());
            System.out.println("Disponivel: " + cch.getSaldo() + cch.getLimite());

            double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor que deseja sacar: "));

            //aqui é um metodo pra sacar
            boolean saquei = cch .sacar(valor);

            if (saquei) {
                System.out.println("Saque efetuado com sucesso");
            } else {
                System.out.println("Erro no saque");
            }
            System.out.println("Saldo Atual: " + cch.getSaldo());


            String texto = """
                    
                    Deseja realizar um novo saque?
                    
                    [1] = SIM
                    [0] = NÃO
                   
                    """;

            continua = Integer.parseInt(JOptionPane.showInputDialog(texto));

        }while (continua == 1);

        System.out.println("-------------------------------------");

        System.out.println("Saldo Atual: " + cch.getSaldo());
        System.out.println("Limite Atual: " + cch.getLimite());
        System.out.println("Disponivel Atual: " + cch.getSaldo() + cch.getLimite());

    }
}