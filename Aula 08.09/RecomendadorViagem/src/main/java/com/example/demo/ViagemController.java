package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViagemController {

    @GetMapping("/recomendar")
    public String recomendarDestino(@RequestParam String clima, @RequestParam String estilo) {
        if (clima.equalsIgnoreCase("calor") && estilo.equalsIgnoreCase("natureza")) {
            return "Rio de Janeiro";
        } else if (clima.equalsIgnoreCase("frio") && estilo.equalsIgnoreCase("cultural")) {
            return "Gramado";
        } else if (clima.equalsIgnoreCase("calor") && estilo.equalsIgnoreCase("praia")) {
            return "Fernando de Noronha";
        } else if (clima.equalsIgnoreCase("frio") && estilo.equalsIgnoreCase("aventura")) {
            return "Patagônia";
        } else {
            return "Desculpe, não temos uma recomendação para essa combinação.";
        }
    }
}