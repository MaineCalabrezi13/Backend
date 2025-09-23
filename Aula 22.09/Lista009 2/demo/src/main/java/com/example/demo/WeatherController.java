package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.Map;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Value("${openweather.api.key}")
    private String apiKey;

    @Value("${openweather.api.url}")
    private String apiUrl;

    private final RestClient restClient = RestClient.create();

    @GetMapping("/{city}")
    public ResponseEntity<?> getWeather(@PathVariable String city) {
        String url = apiUrl + "?q=" + city + "&appid=" + apiKey + "&units=metric&lang=pt_br";


        Map response = restClient.get()
                .uri(url)
                .retrieve()
                .body(Map.class);

        Map main = (Map) response.get("main");
        double temp = (double) main.get("temp");
        double feelsLike = (double) main.get("feels_like");

        String descricao = ((Map) ((java.util.List) response.get("weather")).get(0))
                .get("description").toString();

        String mensagem = String.format(
                "Hoje em %s está %.1f°C (sensação de %.1f°C) com %s.",
                city, temp, feelsLike, descricao
        );

        return ResponseEntity.ok(Map.of("previsao_personalizada", mensagem));
    }
}
