package com.example.Biblioteca.controllers;
import com.example.Biblioteca.models.Livro;
import com.example.Biblioteca.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> listarLivros() {
        return livroService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarLivro(@PathVariable Long id) {
        Optional<Livro> livro = livroService.buscarPorId(id);
        return livro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/autor/{autorId}")
    public List<Livro> buscarLivrosPorAutor(@PathVariable Long autorId) {
        return livroService.buscarPorAutor(autorId);
    }

    @PostMapping
    public ResponseEntity<Livro> criarLivro(@RequestBody Livro livro) {
        Livro novoLivro = livroService.salvarLivro(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLivro);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @RequestBody Livro livro) {
        Livro livroAtualizado = livroService.atualizarLivro(id, livro);
        return livroAtualizado != null ? ResponseEntity.ok(livroAtualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        return livroService.deletarLivro(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
