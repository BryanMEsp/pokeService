package com.pokeservicio.pokeservicio.Model.PokeApi;

import lombok.Data;

@Data
public class VersionGroupDetail {
    public int level_learned_at;
    public MoveLearnMethod move_learn_method;
    public VersionGroup version_group;
}
