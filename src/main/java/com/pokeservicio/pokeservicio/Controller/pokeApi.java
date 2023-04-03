package com.pokeservicio.pokeservicio.Controller;
import com.pokeservicio.pokeservicio.Model.pokemon;
import com.pokeservicio.pokeservicio.Model.pokemonApi;
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
public class pokeApi {
    @GetMapping("/pokemon")
    public String  pokeGet(@RequestParam String pokedex){
        ResponseEntity<pokemonApi> responseEntity= new RestTemplate().getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokedex, pokemonApi.class);
        pokemon pokemon = new pokemon();
        pokemon.setSprite(responseEntity.getBody().getSprites().getFront_default());
        BufferedImage imagen = null;
        try {
             imagen = ImageIO.read(new URL(responseEntity.getBody().getSprites().getFront_default()));
             ByteArrayOutputStream BAUS = new ByteArrayOutputStream();
             ImageIO.write(imagen, "PNG", BAUS);
             return Base64.getEncoder().encodeToString(BAUS.toByteArray());

        }catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
}
}
