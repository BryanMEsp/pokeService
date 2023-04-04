package com.pokeservicio.pokeservicio.Model.PokeApi;

import lombok.Data;

import java.util.ArrayList;
@Data
public class Moves {
    public Move move;
    public ArrayList<VersionGroupDetail> version_group_details;
}
