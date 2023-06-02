package br.com.brunnadornelles.view;

import br.com.brunnadornelles.command.Deposito;
import br.com.brunnadornelles.command.Saque;
import br.com.brunnadornelles.model.Conta;
import br.com.brunnadornelles.service.ServicoBanco;

public class Main {

    public static void main(String[] args) {
        Conta conta = new Conta("Brunna Dornelles");
        ServicoBanco servicoBanco = new ServicoBanco(conta);

        Deposito deposito = new Deposito(conta, 1575);
        Saque saque = new Saque(conta, 347);

        servicoBanco.addOrder(deposito);
        servicoBanco.addOrder(saque);

        System.out.println(servicoBanco.mostrandoExtrato());
        System.out.println("\n"+conta.getnomeTitular() + ", seu saldo atual em conta é de R$"+servicoBanco.saldoEmConta()+ "\n");

        servicoBanco.limpandoCache();
    }
}