package com.infobasic.model;

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

    public int getNationalNumber() {
        return nationalNumber;
    }

    public void setNationalNumber(int nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getPrimaryType() {
        return primaryType;
    }

    public void setPrimaryType(String primaryType) {
        this.primaryType = primaryType;
    }

    public String getSecondaryType() {
        return secondaryType;
    }

    public void setSecondaryType(String secondaryType) {
        this.secondaryType = secondaryType;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

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

    public double getHeightM() {
        return heightM;
    }

    public void setHeightM(double heightM) {
        this.heightM = heightM;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    public int getCaptureRate() {
        return captureRate;
    }

    public void setCaptureRate(int captureRate) {
        this.captureRate = captureRate;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getAbilities0() {
        return abilities0;
    }

    public void setAbilities0(String abilities0) {
        this.abilities0 = abilities0;
    }

    public String getAbilities1() {
        return abilities1;
    }

    public void setAbilities1(String abilities1) {
        this.abilities1 = abilities1;
    }

    public String getAbilitiesSpecial() {
        return abilitiesSpecial;
    }

    public void setAbilitiesSpecial(String abilitiesSpecial) {
        this.abilitiesSpecial = abilitiesSpecial;
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

    public String getEvochain0() {
        return evochain0;
    }

    public void setEvochain0(String evochain0) {
        this.evochain0 = evochain0;
    }

    public String getEvochain2() {
        return evochain2;
    }

    public void setEvochain2(String evochain2) {
        this.evochain2 = evochain2;
    }

    public String getEvochain4() {
        return evochain4;
    }

    public void setEvochain4(String evochain4) {
        this.evochain4 = evochain4;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEvo1Id() {
        return evo1Id;
    }

    public void setEvo1Id(Integer evo1Id) {
        this.evo1Id = evo1Id;
    }

    public Integer getEvo2Id() {
        return evo2Id;
    }

    public void setEvo2Id(Integer evo2Id) {
        this.evo2Id = evo2Id;
    }

    public Integer getEvo3Id() {
        return evo3Id;
    }

    public void setEvo3Id(Integer evo3Id) {
        this.evo3Id = evo3Id;
    }

    public String getEvochain6() {
        return evochain6;
    }

    public void setEvochain6(String evochain6) {
        this.evochain6 = evochain6;
    }

    public String getEvochain8() {
        return evochain8;
    }

    public void setEvochain8(String evochain8) {
        this.evochain8 = evochain8;
    }

    public String getEvochain10() {
        return evochain10;
    }

    public void setEvochain10(String evochain10) {
        this.evochain10 = evochain10;
    }

    public Integer getEvo4Id() {
        return evo4Id;
    }

    public void setEvo4Id(Integer evo4Id) {
        this.evo4Id = evo4Id;
    }

    public Integer getEvo5Id() {
        return evo5Id;
    }

    public void setEvo5Id(Integer evo5Id) {
        this.evo5Id = evo5Id;
    }

    public Integer getEvo6Id() {
        return evo6Id;
    }

    public void setEvo6Id(Integer evo6Id) {
        this.evo6Id = evo6Id;
    }
}
