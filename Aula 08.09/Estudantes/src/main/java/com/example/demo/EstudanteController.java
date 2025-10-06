package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    // Armazena os estudantes em memória (usando código como chave)
    private Map<Integer, Estudante> estudantes = new HashMap<>();

    // POST: Cadastra um novo estudante
    @PostMapping
    public Estudante adicionarEstudante(@RequestBody Estudante estudante) {
        estudantes.put(estudante.getCodigo(), estudante);
        return estudante;
    }

    // GET: Retorna todos os estudantes
    @GetMapping
    public Collection<Estudante> listarEstudantes() {
        return estudantes.values();
    }

    // GET: Retorna estudante por código
    @GetMapping("/{codigo}")
    public Estudante buscarPorCodigo(@PathVariable int codigo) {
        Estudante estudante = estudantes.get(codigo);
        if (estudante == null) {
            throw new NoSuchElementException("Estudante com código " + codigo + " não encontrado.");
        }
        return estudante;
    }
}