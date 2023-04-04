package com.pokeservicio.pokeservicio.Controller;

import com.pokeservicio.pokeservicio.Model.pokemon;
import com.pokeservicio.pokeservicio.Model.PokeApi.pokemonApi;
import com.pokeservicio.pokeservicio.service.PokeApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;

@RestController
@RequestMapping("/api")
public class PokeApiController {

    @Autowired
    PokeApiService pokeApiService;

    @GetMapping("/pokemon")
    public String pokeGet(@RequestParam String pokedex) {
        return pokeApiService.getBase64(pokedex);
    }
}
