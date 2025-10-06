package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class JogadorService {

    private final List<String> nomes = List.of("Ronaldo", "Pelé", "Zico", "Romário", "Neymar");
    private final List<String> sobrenomes = List.of("Fenômeno", "Santos", "Alves", "Souza", "Lima");

    private final Random random = new Random();

    public Jogador gerarJogador(String time, String posicao) {
        String nome = nomes.get(random.nextInt(nomes.size()));
        String sobrenome = sobrenomes.get(random.nextInt(sobrenomes.size()));
        int idade = random.nextInt(15) + 20; // 20 a 34 anos

        return new Jogador(nome, sobrenome, idade, capitalize(posicao), capitalize(time));
    }

    private String capitalize(String palavra) {
        if (palavra == null || palavra.isEmpty()) return palavra;
        return palavra.substring(0, 1).toUpperCase() + palavra.substring(1).toLowerCase();
    }
}