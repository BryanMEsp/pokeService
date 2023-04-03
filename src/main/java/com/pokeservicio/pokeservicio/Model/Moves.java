package com.pokeservicio.pokeservicio.Model;

import lombok.Data;

import java.util.ArrayList;
@Data
public class Moves {
    public Move move;
    public ArrayList<VersionGroupDetail> version_group_details;
}
