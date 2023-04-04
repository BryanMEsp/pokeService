package com.pokeservicio.pokeservicio.Model.PokeApi;

import lombok.Data;

@Data
public class Abilities {
    public Ability ability;
    public boolean is_hidden;
    public int slot;
}
