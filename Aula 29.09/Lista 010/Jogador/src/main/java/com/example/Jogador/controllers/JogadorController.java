package com.example.Jogador.controllers;

import com.example.Jogador.models.Jogador;
import com.example.Jogador.services.JogadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    private final JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @GetMapping
    public List<Jogador> listarJogadores(@RequestParam(required = false) String nome) {
        if (nome != null && !nome.isEmpty()) {
            return jogadorService.pesquisarJogadorPorNome(nome);
        }
        return jogadorService.listarTodosJogadores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> buscarJogador(@PathVariable UUID id) {
        return jogadorService.buscarJogadorPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Jogador> criarJogador(@RequestBody Jogador jogador) {
        if (jogador == null || jogador.getNome() == null || jogador.getPosicao() == null) {
            return ResponseEntity.badRequest().build();
        }

        Jogador novoJogador = jogadorService.salvarJogador(jogador);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoJogador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarJogador(@PathVariable UUID id) {
        if (jogadorService.buscarJogadorPorId(id).isPresent()) {
            jogadorService.deletarJogador(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
