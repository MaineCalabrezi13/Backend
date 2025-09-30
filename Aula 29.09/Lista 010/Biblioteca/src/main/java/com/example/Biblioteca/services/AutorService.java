package com.example.Biblioteca.services;

import com.example.Biblioteca.models.Autor;
import com.example.Biblioteca.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    public Optional<Autor> buscarPorId(Long id) {
        return autorRepository.findById(id);
    }

    public Autor salvarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor atualizarAutor(Long id, Autor autorAtualizado) {
        if (autorRepository.existsById(id)) {
            autorAtualizado.setId(id);
            return autorRepository.save(autorAtualizado);
        }
        return null;
    }

    public boolean deletarAutor(Long id) {
        if (autorRepository.existsById(id)) {
            autorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

