package org.example;

public class JogadorTeste {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            Jogador j = new Jogador();
            System.out.println("Jogador " + i + ": " + j);
        }
    }
}