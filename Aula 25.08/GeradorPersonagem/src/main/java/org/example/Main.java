package org.example;
import java.util.*;

class Personagem {
    private String nome;
    private int vida;
    private int ataque;

    public Personagem(String nome, int vida, int ataque) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void receberDano(int dano) {
        if (vida <= 0) {
            System.out.println(nome + " já está derrotado!");
            return;
        }
        vida -= dano;
        if (vida <= 0) {
            vida = 0;
            System.out.println(nome + " foi derrotado!");
        }
    }

    public void atacar(Personagem alvo) {
        if (vida <= 0) {
            System.out.println(nome + " não pode atacar, está derrotado!");
            return;
        }
        if (alvo.getVida() <= 0) {
            System.out.println("O ataque falhou! " + alvo.getNome() + " já foi derrotado.");
            return;
        }
        alvo.receberDano(this.ataque);
        System.out.println(nome + " atacou " + alvo.getNome() + " causando " + ataque + " de dano!");
    }
}

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        List<Personagem> inimigos = new ArrayList<>();
        inimigos.add(new Personagem("Orc", 100, 10));
        inimigos.add(new Personagem("Goblin", 50, 5));
        inimigos.add(new Personagem("Lobo", 75, 15));
        inimigos.add(new Personagem("Cavaleiro", 200, 20));
        inimigos.add(new Personagem("Dragão", 500, 50));


        Personagem jogador = new Personagem("Steve", 100, 20);

        while (jogador.getVida() > 0 && inimigos.stream().anyMatch(i -> i.getVida() > 0)) {
            List<Personagem> vivos = inimigos.stream().filter(i -> i.getVida() > 0).toList();
            Personagem inimigo = vivos.get(random.nextInt(vivos.size()));
            jogador.atacar(inimigo);

            // Inimigos atacam o jogador
            for (Personagem i : inimigos) {
                if (i.getVida() > 0 && jogador.getVida() > 0) {
                    i.atacar(jogador);
                }
            }
            System.out.println("--------------------");
        }

        if (jogador.getVida() <= 0) {
            System.out.println("Steve foi derrotado!");
        } else {
            System.out.println("Todos os inimigos foram derrotados!");
        }
    }
}
