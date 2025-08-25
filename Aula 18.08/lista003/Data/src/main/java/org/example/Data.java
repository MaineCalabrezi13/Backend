package org.example;

import java.time.Year;

public class Data {
    private int dia;
    private int mes;
    private int ano;


    public Data(int dia, int mes, int ano) {
        setAno(ano);
        setMes(mes);
        setDia(dia);
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if (validarData(dia, this.mes, this.ano)) {
            this.dia = dia;
        } else {
            System.out.println("Dia inválido (" + dia + ") para " + this.mes + "/" + this.ano + ". Ajustado para 1.");
            this.dia = 1;
        }
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if (mes >= 1 && mes <= 12) {
            this.mes = mes;
        } else {
            System.out.println("Mês inválido (" + mes + "). Ajustado para 1.");
            this.mes = 1;
        }
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if (ano > 0) {
            this.ano = ano;
        } else {
            System.out.println("Ano inválido (" + ano + "). Ajustado para 2000.");
            this.ano = 2000;
        }
    }
    
    private boolean validarData(int dia, int mes, int ano) {
        int[] diasPorMes = { 31, (Year.isLeap(ano) ? 29 : 28), 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31 };
        return dia >= 1 && dia <= diasPorMes[mes - 1];
    }

    public void displayData() {
        System.out.println(dia + "/" + mes + "/" + ano);
    }
}