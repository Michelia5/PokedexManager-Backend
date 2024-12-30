package com.infobasic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectionItem {
    private int id;
    private int userId;
    private int pokemonId;
    private String status;
}

