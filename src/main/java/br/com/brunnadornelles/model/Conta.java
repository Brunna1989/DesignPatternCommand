package br.com.brunnadornelles.model;

public class Conta {
    private final String nomeTitular;

    public Conta(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }


    public String sacarEmConta(double valor) {
        return "Sacado o valor de R$ " + valor;
    }


    public String getnomeTitular() {
        return nomeTitular;
    }
}
