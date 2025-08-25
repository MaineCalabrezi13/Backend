package org.example;
import java.util.Random;

public class Jogador {
    private String nome;
    private String sobrenome;
    private int idade;
    private String posicao;
    private String time;

    private static final String[] NOMES = { "Carlos", "João", "Ana", "Maria", "Paulo", "Lucas" };
    private static final String[] SOBRENOMES = { "Silva", "Souza", "Almeida", "Ramos", "Pereira" };
    private static final String[] POSICOES = { "Goleiro", "Zagueiro", "Meio-campo", "Atacante", "Lateral" };
    private static final String[] TIMES = { "Corinthians", "Grêmio", "Internacional", "Flamengo", "Palmeiras" };

    public Jogador() {
        Random random = new Random();
        this.nome = NOMES[random.nextInt(NOMES.length)];
        this.sobrenome = SOBRENOMES[random.nextInt(SOBRENOMES.length)];
        this.idade = random.nextInt(23) + 18;
        this.posicao = POSICOES[random.nextInt(POSICOES.length)];
        this.time = TIMES[random.nextInt(TIMES.length)];
    }

    @Override
    public String toString() {
        return nome + " " + sobrenome + " é um futebolista brasileiro de " +
                idade + " anos que atua como " + posicao +
                ". Atualmente defende o " + time + ".";
    }
}