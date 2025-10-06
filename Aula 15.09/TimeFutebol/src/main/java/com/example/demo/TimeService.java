package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeService {

    private final List<Jogador> jogadores = new ArrayList<>();

    public TimeService() {
        for (int i = 1; i <= 11; i++) {
            jogadores.add(new Jogador("Titular " + i, "Posição " + i, 20 + i));
        }

        for (int i = 1; i <= 5; i++) {
            jogadores.add(new Jogador("Reserva " + i, "Posição R" + i, 18 + i));
        }
    }

    public List<Jogador> getTitulares() {
        return jogadores.subList(0, 11);
    }

    public List<Jogador> getReservas() {
        return jogadores.subList(11, jogadores.size());
    }

    public String substituirJogador(int posicaoTitular) {
        if (posicaoTitular < 0 || posicaoTitular >= 11) {
            return "Posição inválida. Use um valor entre 0 e 10.";
        }

        if (getReservas().isEmpty()) {
            return "Não há mais reservas disponíveis.";
        }

        Jogador reserva = getReservas().remove(0);

        Jogador substituido = jogadores.set(posicaoTitular, reserva);

        return String.format("Jogador %s foi substituído por %s.",
                substituido.getNome(), reserva.getNome());
    }
}
