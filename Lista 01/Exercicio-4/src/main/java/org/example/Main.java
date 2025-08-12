package org.example;

public class Main {
    public static void main(String[] args) {
        double valorTotal = 150;
        if (valorTotal >= 100){
            valorTotal = (valorTotal*0.90);
            System.out.println("O Valor final com desconto: " + valorTotal);
        }else{
            System.out.println("O Valor final sem desconto: " + valorTotal);
        }

    }
}