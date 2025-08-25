package org.example;
import java.util.Scanner;

public class PokemonTeste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos Pokémons deseja gerar? ");
        int qtd = sc.nextInt();

        for (int i = 1; i <= qtd; i++) {
            Pokemon p = new Pokemon();
            System.out.println("Pokémon " + i + ": " + p);
        }

        sc.close();
    }
}
