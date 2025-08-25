package org.example;
import java.util.Random;

public class Pokemon {
    private String nome;
    private String tipo;
    private int nivel;

    private static final String[] NOMES = {"Pikachu", "Charmander", "Squirtle", "Bulbasaur", "Eevee", "Snorlax"};
    private static final String[] TIPOS = {"Elétrico", "Fogo", "Água", "Planta", "Normal"};

    public Pokemon() {
        Random random = new Random();
        this.nome = NOMES[random.nextInt(NOMES.length)];
        this.tipo = TIPOS[random.nextInt(TIPOS.length)];
        this.nivel = random.nextInt(100) + 1;
    }

    @Override
    public String toString() {
        return nome + " é um Pokémon do tipo " + tipo + " de nível " + nivel + ".";
    }
}