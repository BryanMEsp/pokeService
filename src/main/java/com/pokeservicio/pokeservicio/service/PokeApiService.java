package com.pokeservicio.pokeservicio.service;


import com.pokeservicio.pokeservicio.Model.PokeApi.pokemonApi;
import com.pokeservicio.pokeservicio.Model.pokemon;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;

@Service
public class PokeApiService {

    public String getBase64(String pokenumber) {
        ResponseEntity<pokemonApi> responseEntity = new RestTemplate().getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokenumber, pokemonApi.class);
        pokemon pokemon = new pokemon();
        pokemon.setSprite(responseEntity.getBody().getSprites().getFront_default());
        BufferedImage imagen = null;
        try {
            imagen = ImageIO.read(new URL(responseEntity.getBody().getSprites().getFront_default()));
            ByteArrayOutputStream BAUS = new ByteArrayOutputStream();
            ImageIO.write(imagen, "PNG", BAUS);
            return Base64.getEncoder().encodeToString(BAUS.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }

}
