import br.com.benezinhobank.model.Agencia;
import br.com.benezinhobank.model.Banco;
import br.com.benezinhobank.model.ContaCorrente;
import br.com.benezinhobank.model.ContaPoupanca;
import br.com.benezinhobank.pessoa.model.Pessoa;
import br.com.benezinhobank.pessoa.model.PessoaFisica;
import br.com.benezinhobank.pessoa.model.PessoaJuridica;

import javax.swing.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Banco benezinho = new Banco("Benezinho Bank");

        Agencia osasco = new Agencia();
        osasco.setBanco(benezinho);
        osasco.setNome("Osasco");
        osasco.setNumero("1-9");

        PessoaFisica mae = new PessoaFisica();
        mae.setNome("Raquel Aparecida Ribeiro Mello");
        mae.setNascimento(LocalDate.of(1975, 5, 25));
        mae.setCPF("257774662-01");

        PessoaFisica maria = new PessoaFisica();
        maria.setCPF("416008977-99");
        maria.setNascimento(LocalDate.of(2004, 7, 12));
        maria.setNome("Maria Fernanda Ribeiro Mello");
        maria.setMae(mae);

        PessoaFisica lucca = new PessoaFisica();
        lucca.setCPF("2516763234-98");
        lucca.setNascimento(LocalDate.of(2004, 8, 19));
        lucca.setMae(mae);
        lucca.setNome("Lucca Freitas");

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
        holding.setNascimento(LocalDate.of(1988, 7, 5));
        holding.setNome("Percy Holding");
        holding.setRazaoSocial("Percy Holding Jackson");

        ContaCorrente ccH = new ContaCorrente();
        ccH.setNumero("4-6");
        ccH.setLimite(10_000);
        ccH.setSaldo(5_000);
        ccH.setTitular(holding);
        ccH.setAgencia(osasco);

        Pessoa[] socios = new Pessoa[3];
        socios[0] = maria;
        socios[1] = mae;
        socios[2] = lucca;

        holding.setSocios(socios);

        //aqui é a pra ficar percorrendo a lista para imprimir os socios
        for (int i = 0; i < socios.length; i++) {
            System.out.println(socios[i]);
        }


        int continua = 0;

        do{

            System.out.println("-------------------------------------");
            System.out.println("Saldo anterior: " + ccH.getSaldo());
            System.out.println("Limite: " + ccH.getLimite());
            System.out.println("Disponivel: " + ccH.getSaldo() + ccH.getLimite());

            double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor que deseja sacar: "));

            //aqui é um metodo pra sacar
            boolean saquei = ccH.sacar(valor);

            if (saquei) {
                System.out.println("Saque efetuado com sucesso");
            } else {
                System.out.println("Erro no saque");
            }
            System.out.println("Saldo Atual: " + ccH.getSaldo());


            String texto = """
                    
                    Deseja realizar um novo saque?
                    
                    [1] = SIM
                    [0] = NÃO
                   
                    """;

            continua = Integer.parseInt(JOptionPane.showInputDialog(texto));

        }while (continua == 1);

        System.out.println("-------------------------------------");

        System.out.println("Saldo Atual: " + ccH.getSaldo());
        System.out.println("Limite Atual: " + ccH.getLimite());
        System.out.println("Disponivel Atual: " + ccH.getSaldo() + ccH.getLimite());

    }
}