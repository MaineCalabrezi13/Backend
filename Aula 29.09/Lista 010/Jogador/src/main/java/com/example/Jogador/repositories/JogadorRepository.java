package com.example.Jogador.repositories;

import com.example.Jogador.models.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JogadorRepository extends JpaRepository<Jogador, UUID> {
    List<Jogador> findByNomeContaining(String nome);
}
