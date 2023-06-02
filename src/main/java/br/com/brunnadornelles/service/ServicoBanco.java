package br.com.brunnadornelles.service;

import br.com.brunnadornelles.command.Deposito;
import br.com.brunnadornelles.command.Processos;
import br.com.brunnadornelles.command.Saque;
import br.com.brunnadornelles.model.Conta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServicoBanco {

    private  static List<Processos> orderList = new ArrayList<>();
    private Conta conta;

    public ServicoBanco(Conta conta){
        this.conta = conta;
    }

    public boolean addOrder(Processos order){
        if(order instanceof Saque && order.getValor() > this.saldoEmConta()){
            throw new IllegalArgumentException("Valor não permitido");
        }

        if(this.conta == null){
            throw new IllegalArgumentException("Valor não permitido");
        }

        if(order.getValor() < 0){
            throw new IllegalArgumentException("Valor não permitido");
        }
        orderList.add(order);
        return true;
    }

    public List<Processos> mostrandoExtrato(){
        return Collections.unmodifiableList(orderList);
    }

       public boolean limpandoCache(){
        if(!mostrandoExtrato().isEmpty()){
            orderList.clear();
            return true;
        }
        return true;
    }

    public double saldoEmConta(){
        double result = 0;
        for(Processos order : orderList){
            if(order instanceof Deposito){
                result += order.getValor();
            }else if(order instanceof Saque){
                result -= order.getValor();
            }
        }
        return result;
    }
}