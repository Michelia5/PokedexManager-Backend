package com.infobasic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private Integer evo1Id;
    private Integer evo2Id;
    private Integer evo3Id;
    private String evochain6;
    private String evochain8;
    private String evochain10;
    private Integer evo4Id;
    private Integer evo5Id;
    private Integer evo6Id;

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
