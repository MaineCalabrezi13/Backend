package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class BibliotecaController {

    @Autowired
    private BibliotecaService service;

    @GetMapping("/livros")
    public List<Livro> listarLivros() {
        return service.getLivrosDisponiveis();
    }

    @GetMapping("/emprestados")
    public Collection<Emprestimo> listarEmprestimos() {
        return service.getEmprestimos();
    }

    @PostMapping("/emprestados")
    public ResponseEntity<?> emprestarLivro(@RequestBody EmprestimoRequest request) {
        Optional<Emprestimo> emprestimo = service.criarEmprestimo(request.getLivroId(), request.getUsuarioId());
        if (emprestimo.isEmpty()) {
            return ResponseEntity.badRequest().body("Livro não disponível.");
        }
        return ResponseEntity.ok(emprestimo.get());
    }

    @DeleteMapping("/emprestados/{emprestimoId}")
    public ResponseEntity<String> devolverLivro(@PathVariable UUID emprestimoId) {
        boolean sucesso = service.devolverLivro(emprestimoId);
        if (sucesso) {
            return ResponseEntity.ok("Livro devolvido com sucesso.");
        } else {
            return ResponseEntity.status(404).body("Empréstimo não encontrado.");
        }
    }
}