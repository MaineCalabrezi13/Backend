package org.example;

public class Main {
    public static void main(String[] args) {
        double[] notas = {7,8,9,10};
        double soma = 0;

        System.out.println("Notas: ");
        for (double nota: notas){
            System.out.println(nota);
            soma += nota;
        }
        double media = soma / notas.length;
        System.out.println("Media: " + media);

    }
}