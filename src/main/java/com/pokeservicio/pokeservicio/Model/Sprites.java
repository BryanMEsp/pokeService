package com.pokeservicio.pokeservicio.Model;

import lombok.Data;

@Data
public class Sprites {
    public String back_default;
    public String back_female;
    public String back_shiny;
    public String back_shiny_female;
    public String front_default;
    public String front_female;
    public String front_shiny;
    public String front_shiny_female;
    public Other other;
    public Versions versions;
}
