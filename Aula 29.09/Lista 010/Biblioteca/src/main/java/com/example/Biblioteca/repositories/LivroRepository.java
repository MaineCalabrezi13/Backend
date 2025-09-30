package com.example.Biblioteca.repositories;

import com.example.Biblioteca.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByAutorId(Long autorId);
}
