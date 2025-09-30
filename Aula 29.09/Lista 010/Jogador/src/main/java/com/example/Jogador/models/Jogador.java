package com.example.Jogador.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  // Utilizando AUTO para gerar o ID
    private UUID id;

    private String nome;
    private String posicao;
    private Integer idade;

    // Construtor padrão
    public Jogador() {}

    public Jogador(UUID id, String nome, String posicao, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.posicao = posicao;
        this.idade = idade;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
