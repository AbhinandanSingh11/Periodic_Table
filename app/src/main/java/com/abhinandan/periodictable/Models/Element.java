package com.abhinandan.periodictable.Models;

public class Element {
    private String name;
    private String symbol;
    private String atomicMass;
    private String atomicNumber;
    private String standardState;
    private String atomicRedius;
    private String boilingPoint;
    private String bondingType;
    private String density;
    private String electronAffinity;
    private String electroNegativity;
    private String electronicConfiguration;
    private String groupBlock;
    private String meltingPoint;
    private String oxidationSate;
    private String vanDelWallsRadius;
    private String yearDiscovered;
    private String ionizationEnergy;
    private String color;

    public Element() {

    }

    public Element(String name, String symbol, String atomicMass, String atomicNumber) {
        this.name = name;
        this.symbol = symbol;
        this.atomicMass = atomicMass;
        this.atomicNumber = atomicNumber;
    }

    public Element(String name, String symbol, String atomicMass, String atomicNumber, String standardState, String atomicRedius, String boilingPoint, String bondingType, String density, String electronAffinity, String electroNegativity, String electronicConfiguration, String groupBlock, String meltingPoint, String oxidationSate, String vanDelWallsRadius, String yearDiscovered, String ionizationEnergy, String color) {
        this.name = name;
        this.symbol = symbol;
        this.atomicMass = atomicMass;
        this.atomicNumber = atomicNumber;
        this.standardState = standardState;
        this.atomicRedius = atomicRedius;
        this.boilingPoint = boilingPoint;
        this.bondingType = bondingType;
        this.density = density;
        this.electronAffinity = electronAffinity;
        this.electroNegativity = electroNegativity;
        this.electronicConfiguration = electronicConfiguration;
        this.groupBlock = groupBlock;
        this.meltingPoint = meltingPoint;
        this.oxidationSate = oxidationSate;
        this.vanDelWallsRadius = vanDelWallsRadius;
        this.yearDiscovered = yearDiscovered;
        this.ionizationEnergy = ionizationEnergy;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getAtomicMass() {
        return atomicMass;
    }

    public String getAtomicNumber() {
        return atomicNumber;
    }

    public String getStandardState() {
        return standardState;
    }

    public String getAtomicRedius() {
        return atomicRedius;
    }

    public String getBoilingPoint() {
        return boilingPoint;
    }

    public String getBondingType() {
        return bondingType;
    }

    public String getDensity() {
        return density;
    }

    public String getElectronAffinity() {
        return electronAffinity;
    }

    public String getElectroNegativity() {
        return electroNegativity;
    }

    public String getElectronicConfiguration() {
        return electronicConfiguration;
    }

    public String getGroupBlock() {
        return groupBlock;
    }

    public String getMeltingPoint() {
        return meltingPoint;
    }

    public String getOxidationSate() {
        return oxidationSate;
    }

    public String getVanDelWallsRadius() {
        return vanDelWallsRadius;
    }

    public String getYearDiscovered() {
        return yearDiscovered;
    }

    public String getIonizationEnergy() {
        return ionizationEnergy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setAtomicMass(String atomicMass) {
        this.atomicMass = atomicMass;
    }

    public void setAtomicNumber(String atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    public void setStandardState(String standardState) {
        this.standardState = standardState;
    }

    public void setAtomicRedius(String atomicRedius) {
        this.atomicRedius = atomicRedius;
    }

    public void setBoilingPoint(String boilingPoint) {
        this.boilingPoint = boilingPoint;
    }

    public void setBondingType(String bondingType) {
        this.bondingType = bondingType;
    }

    public void setDensity(String density) {
        this.density = density;
    }

    public void setElectronAffinity(String electronAffinity) {
        this.electronAffinity = electronAffinity;
    }

    public void setElectroNegativity(String electroNegativity) {
        this.electroNegativity = electroNegativity;
    }

    public void setElectronicConfiguration(String electronicConfiguration) {
        this.electronicConfiguration = electronicConfiguration;
    }

    public void setGroupBlock(String groupBlock) {
        this.groupBlock = groupBlock;
    }

    public void setMeltingPoint(String meltingPoint) {
        this.meltingPoint = meltingPoint;
    }

    public void setOxidationSate(String oxidationSate) {
        this.oxidationSate = oxidationSate;
    }

    public void setVanDelWallsRadius(String vanDelWallsRadius) {
        this.vanDelWallsRadius = vanDelWallsRadius;
    }

    public void setYearDiscovered(String yearDiscovered) {
        this.yearDiscovered = yearDiscovered;
    }

    public void setIonizationEnergy(String ionizationEnergy) {
        this.ionizationEnergy = ionizationEnergy;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
