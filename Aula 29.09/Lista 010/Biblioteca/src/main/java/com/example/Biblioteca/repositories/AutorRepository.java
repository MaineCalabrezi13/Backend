package com.example.Biblioteca.repositories;

import com.example.Biblioteca.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
