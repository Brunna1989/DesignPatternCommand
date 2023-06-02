package br.com.brunnadornelles.command;

import br.com.brunnadornelles.model.Conta;

public class Deposito implements Processos {
    private Conta conta;
    private double valor;

    public Deposito(Conta conta, double valor){
        this.conta = conta;
        this.valor = valor;
    }

    @Override
    public double getValor() {
        return this.valor;
    }

    @Override
    public String toString(){
        return "Depositado o valor de R$" + valor;
    }
}