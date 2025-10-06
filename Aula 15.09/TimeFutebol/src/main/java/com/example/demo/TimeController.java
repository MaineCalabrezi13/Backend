package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping("/principal")
    public List<Jogador> listarTitulares() {
        return timeService.getTitulares();
    }

    @GetMapping("/reservas")
    public List<Jogador> listarReservas() {
        return timeService.getReservas();
    }

    @PutMapping("/jogador/{posicao}")
    public String substituirJogador(@PathVariable int posicao) {
        return timeService.substituirJogador(posicao);
    }
}