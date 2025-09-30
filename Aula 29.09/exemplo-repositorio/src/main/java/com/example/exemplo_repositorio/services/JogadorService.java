package com.example.exemplo_repositorio.services;

import com.example.exemplo_repositorio.models.Jogador;
import com.example.exemplo_repositorio.repositories.JogadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {
    private JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository){
        this.jogadorRepository = jogadorRepository;
    }
    public Jogador saveJogador(String nome, String sobrenome, String posicao){
        Jogador novoJogador = new Jogador();
        novoJogador.setNome(nome);
        novoJogador.setSobrenome(sobrenome);
        novoJogador.setClube("Gremio");
        novoJogador.setIdade(19);
        novoJogador.setPosicao(posicao);
        jogadorRepository.save(novoJogador); //SALVAR NO BANCO (SALVAR ANTES DE RETORNAR)
        return novoJogador;
    }

    public List<Jogador> getAllJogador(){
        return jogadorRepository.findAll();
    }
}
