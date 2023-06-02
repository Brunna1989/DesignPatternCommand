package br.com.brunnadornelles.command;

import br.com.brunnadornelles.model.Conta;

public class Saque implements Processos {

    private final double valor;

    public Saque(Conta conta, double valor){
        this.valor = valor;
    }

    @Override
    public double getValor() {
        return this.valor;
    }

    @Override
    public String toString(){
        return "Saque efetuado no valor de R$" + valor;
    }
}