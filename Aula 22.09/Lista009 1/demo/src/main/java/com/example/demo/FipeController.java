package com.example.demo;

import com.example.demo.CarroRequest;
import com.example.demo.FipeResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.Map;

@RestController
@RequestMapping("/fipe")
public class FipeController {

    private final RestClient restClient;

    public FipeController() {
        this.restClient = RestClient.create("https://parallelum.com.br/fipe/api/v1/carros");
    }

    @PostMapping("/consultar")
    public FipeResponse consultarValor(@RequestBody CarroRequest request) {
        try {
            // Passo 1: buscar todas as marcas
            var marcas = restClient.get()
                    .uri("/marcas")
                    .retrieve()
                    .body(Map[].class);

            String marcaCodigo = null;
            for (Map m : marcas) {
                if (m.get("nome").toString().equalsIgnoreCase(request.getMarca())) {
                    marcaCodigo = m.get("codigo").toString();
                    break;
                }
            }

            if (marcaCodigo == null) {
                throw new RuntimeException("Marca não encontrada.");
            }

            // Passo 2: buscar modelos dessa marca
            var modelosResponse = restClient.get()
                    .uri("/marcas/{codigo}/modelos", marcaCodigo)
                    .retrieve()
                    .body(Map.class);

            var modelos = (Object[]) ((Map) modelosResponse).get("modelos");
            String modeloCodigo = null;
            for (Object obj : modelos) {
                Map modelo = (Map) obj;
                if (modelo.get("nome").toString().equalsIgnoreCase(request.getModelo())) {
                    modeloCodigo = modelo.get("codigo").toString();
                    break;
                }
            }

            if (modeloCodigo == null) {
                throw new RuntimeException("Modelo não encontrado.");
            }

            // Passo 3: buscar anos disponíveis para o modelo
            var anos = restClient.get()
                    .uri("/marcas/{marca}/modelos/{modelo}/anos", marcaCodigo, modeloCodigo)
                    .retrieve()
                    .body(Map[].class);

            String anoCodigo = null;
            for (Map a : anos) {
                if (a.get("nome").toString().contains(String.valueOf(request.getAno()))) {
                    anoCodigo = a.get("codigo").toString();
                    break;
                }
            }

            if (anoCodigo == null) {
                throw new RuntimeException("Ano não encontrado.");
            }

            // Passo 4: buscar valor FIPE do carro
            var resultado = restClient.get()
                    .uri("/marcas/{marca}/modelos/{modelo}/anos/{ano}", marcaCodigo, modeloCodigo, anoCodigo)
                    .retrieve()
                    .body(Map.class);

            String valor = resultado.get("Valor").toString();
            String mes = resultado.get("MesReferencia").toString();

            return new FipeResponse(valor, mes);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao consultar FIPE: " + e.getMessage());
        }
    }
}
