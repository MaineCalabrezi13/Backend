package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] nomes = {"Cássio", "Neymar", "Lionel", "Cristiano", "Thiago", "Gabriel", "Roberto", "André", "Marcelo", "Lucas", "Felipe"};
        String[] sobrenomes = {"Ramos", "Silva", "Messi", "Ronaldo", "Alcântara", "Jesus", "Firmino", "Santos", "Costa", "Pereira", "Oliveira"};
        String[] posicoes = {"goleiro", "atacante", "zagueiro", "meio-campista", "lateral"};
        String[] times = {"Corinthians", "Flamengo", "Barcelona", "Real Madrid", "Liverpool", "PSG"};

        Random random = new Random();

        Jogador[] time = new Jogador[11];
        for (int i = 0; i < time.length; i++) {
            time[i] = new Jogador(
                    nomes[random.nextInt(nomes.length)],
                    sobrenomes[random.nextInt(sobrenomes.length)],
                    posicoes[random.nextInt(posicoes.length)],
                    times[random.nextInt(times.length)],
                    random.nextInt(18, 50) // Idade entre 18 e 50
            );
        }

        System.out.println("Time completo com 11 jogadores:");
        for (int i = 0; i < time.length; i++) {
            Jogador jogador = time[i];
            System.out.println(jogador.nome + " " + jogador.sobrenome + " é um futebolista brasileiro que atua como " +
                    jogador.posicao + ". Atualmente defende o " + jogador.time + " e tem " + jogador.idade + " anos.");
        }
    }
}
