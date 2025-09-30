package com.example.Biblioteca.services;
import com.example.Biblioteca.models.Livro;
import com.example.Biblioteca.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public Optional<Livro> buscarPorId(Long id) {
        return livroRepository.findById(id);
    }

    public List<Livro> buscarPorAutor(Long autorId) {
        return livroRepository.findByAutorId(autorId);
    }

    public Livro salvarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro atualizarLivro(Long id, Livro livroAtualizado) {
        if (livroRepository.existsById(id)) {
            livroAtualizado.setId(id);
            return livroRepository.save(livroAtualizado);
        }
        return null;
    }

    public boolean deletarLivro(Long id) {
        if (livroRepository.existsById(id)) {
            livroRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

