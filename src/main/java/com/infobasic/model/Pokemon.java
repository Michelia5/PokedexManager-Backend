package com.infobasic.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pokemon {
    private int nationalNumber;
    private String gen;
    private String englishName;
    private String primaryType;
    private String secondaryType;
    private String classification;
    private double percentMale;
    private double percentFemale;
    private double heightM;
    private double weightKg;
    private int captureRate;
    private int hp;
    private int attack;
    private int defense;
    private int speed;
    private String abilities0;
    private String abilities1;
    private String abilitiesSpecial;
    private boolean isLegendary;
    private boolean isMythical;
    private String evochain0;
    private String evochain2;
    private String evochain4;
    private String description;
    private Integer evo1Id; // Alcuni campi possono essere Integer, se ammessi a null
    private Integer evo2Id;
    private Integer evo3Id;
    private String evochain6;
    private String evochain8;
    private String evochain10;
    private Integer evo4Id;
    private Integer evo5Id;
    private Integer evo6Id;

    // Costruttore vuoto (necessario per Jackson e/o reflection)
    public Pokemon() {}

    // Costruttore con tutti i parametri (opzionale se vuoi gestirlo manualmente)
    public Pokemon(int nationalNumber,
                   String gen,
                   String englishName,
                   String primaryType,
                   String secondaryType,
                   String classification,
                   Double percentMale, Double percentFemale,
                   double heightM,
                   double weightKg,
                   int captureRate,
                   int hp,
                   int attack,
                   int defense,
                   int speed,
                   String abilities0, String abilities1, String abilitiesSpecial,
                   boolean isLegendary,
                   boolean isMythical,
                   String evochain0, String evochain2, String evochain4,
                   String description,
                   Integer evo1Id, Integer evo2Id, Integer evo3Id,
                   String evochain6, String evochain8, String evochain10,
                   Integer evo4Id, Integer evo5Id, Integer evo6Id) {
        this.nationalNumber = nationalNumber;
        this.gen = gen;
        this.englishName = englishName;
        this.primaryType = primaryType;
        this.secondaryType = secondaryType;
        this.classification = classification;
        this.percentMale = percentMale;
        this.percentFemale = percentFemale;
        this.heightM = heightM;
        this.weightKg = weightKg;
        this.captureRate = captureRate;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.abilities0 = abilities0;
        this.abilities1 = abilities1;
        this.abilitiesSpecial = abilitiesSpecial;
        this.isLegendary = isLegendary;
        this.isMythical = isMythical;
        this.evochain0 = evochain0;
        this.evochain2 = evochain2;
        this.evochain4 = evochain4;
        this.description = description;
        this.evo1Id = evo1Id;
        this.evo2Id = evo2Id;
        this.evo3Id = evo3Id;
        this.evochain6 = evochain6;
        this.evochain8 = evochain8;
        this.evochain10 = evochain10;
        this.evo4Id = evo4Id;
        this.evo5Id = evo5Id;
        this.evo6Id = evo6Id;
    }

    // Getter e Setter per tutti i campi

    public Double getPercentMale() {
        return percentMale;
    }

    public void setPercentMale(Double percentMale) {
        this.percentMale = percentMale;
    }

    public Double getPercentFemale() {
        return percentFemale;
    }

    public void setPercentFemale(Double percentFemale) {
        this.percentFemale = percentFemale;
    }

    public Boolean getIsLegendary() {
        return isLegendary;
    }

    public void setIsLegendary(Boolean isLegendary) {
        this.isLegendary = isLegendary;
    }

    public Boolean getIsMythical() {
        return isMythical;
    }

    public void setIsMythical(Boolean isMythical) {
        this.isMythical = isMythical;
    }
}
