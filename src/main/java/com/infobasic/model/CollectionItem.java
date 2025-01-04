package com.infobasic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectionItem {
    private int id;
    private int userId;
    private int pokemonId;
    private String status;
    private Timestamp createdAt;
    private String englishName;
    private String primaryType;
    private String secondaryType;
}

