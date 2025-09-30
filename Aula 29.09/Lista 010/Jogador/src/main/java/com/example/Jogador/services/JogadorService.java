package com.example.Jogador.services;

import com.example.Jogador.models.Jogador;
import com.example.Jogador.repositories.JogadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public List<Jogador> listarTodosJogadores() {
        return jogadorRepository.findAll();
    }

    public Optional<Jogador> buscarJogadorPorId(UUID id) {
        return jogadorRepository.findById(id);
    }

    public Jogador salvarJogador(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    public void deletarJogador(UUID id) {
        jogadorRepository.deleteById(id);
    }

    public List<Jogador> pesquisarJogadorPorNome(String nome) {
        return jogadorRepository.findByNomeContaining(nome);
    }
}
