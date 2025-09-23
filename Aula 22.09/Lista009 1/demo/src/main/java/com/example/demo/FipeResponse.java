package com.example.demo;

public class FipeResponse {
    private String valor;
    private String mes;

    public FipeResponse(String valor, String mes) {
        this.valor = valor;
        this.mes = mes;
    }

    // getters e setters
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
    public String getMes() {
        return mes;
    }
    public void setMes(String mes) {
        this.mes = mes;
    }
}
