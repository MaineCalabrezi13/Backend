package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @GetMapping("/{time}/{posicao}")
    public Jogador gerarJogador(
            @PathVariable String time,
            @PathVariable String posicao) {
        return jogadorService.gerarJogador(time, posicao);
    }
}