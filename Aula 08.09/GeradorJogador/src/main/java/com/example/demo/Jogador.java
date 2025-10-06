package com.example.demo;

public class Jogador {
    private String nome;
    private String sobrenome;
    private int idade;
    private String posicao;
    private String time;

    public Jogador(String nome, String sobrenome, int idade, String posicao, String time) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.posicao = posicao;
        this.time = time;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public String getPosicao() {
        return posicao;
    }

    public String getTime() {
        return time;
    }
}
