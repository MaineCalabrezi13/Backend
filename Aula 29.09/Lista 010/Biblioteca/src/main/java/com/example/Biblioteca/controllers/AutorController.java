package com.example.Biblioteca.controllers;
import com.example.Biblioteca.models.Autor;
import com.example.Biblioteca.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<Autor> listarAutores() {
        return autorService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarAutor(@PathVariable Long id) {
        Optional<Autor> autor = autorService.buscarPorId(id);
        return autor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Autor> criarAutor(@RequestBody Autor autor) {
        Autor novoAutor = autorService.salvarAutor(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAutor);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Autor> atualizarAutor(@PathVariable Long id, @RequestBody Autor autor) {
        Autor autorAtualizado = autorService.atualizarAutor(id, autor);
        return autorAtualizado != null ? ResponseEntity.ok(autorAtualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAutor(@PathVariable Long id) {
        return autorService.deletarAutor(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

