package com.example.exemplo_repositorio.repositories;

import com.example.exemplo_repositorio.models.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
    List<Jogador> findByNomeContaining(String nome);
}
