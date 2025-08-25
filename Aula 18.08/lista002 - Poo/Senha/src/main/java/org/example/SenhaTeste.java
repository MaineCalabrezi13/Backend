package org.example;
public class SenhaTeste {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            Senha s = new Senha();
            System.out.println("Senha " + i + ": " + s.getSenha());
        }
    }
}
