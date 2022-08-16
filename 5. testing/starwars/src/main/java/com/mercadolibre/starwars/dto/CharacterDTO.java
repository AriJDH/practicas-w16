package com.mercadolibre.starwars.dto;

import lombok.ToString;

import java.util.Objects;

@ToString
public class CharacterDTO {
  private String name;
  private Integer height;
  private Integer mass;
  private String hairColor;
  private String skinColor;
  private String eyeColor;
  private String birthYear;
  private String gender;
  private String homeWorld;
  private String species;

  public CharacterDTO() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getHairColor() {
    return hairColor;
  }

  public void setHairColor(String hairColor) {
    this.hairColor = hairColor;
  }

  public String getSkinColor() {
    return skinColor;
  }

  public void setSkinColor(String skinColor) {
    this.skinColor = skinColor;
  }

  public String getEyeColor() {
    return eyeColor;
  }

  public void setEyeColor(String eyeColor) {
    this.eyeColor = eyeColor;
  }

  public String getBirthYear() {
    return birthYear;
  }

  public void setBirthYear(String birthYear) {
    this.birthYear = birthYear;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getHomeWorld() {
    return homeWorld;
  }

  public void setHomeWorld(String homeWorld) {
    this.homeWorld = homeWorld;
  }

  public String getSpecies() {
    return species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public Integer getMass() {
    return mass;
  }

  public void setMass(Integer mass) {
    this.mass = mass;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CharacterDTO that = (CharacterDTO) o;
    return Objects.equals(name, that.name) && Objects.equals(height, that.height) && Objects.equals(mass, that.mass) && Objects.equals(hairColor, that.hairColor) && Objects.equals(skinColor, that.skinColor) && Objects.equals(eyeColor, that.eyeColor) && Objects.equals(birthYear, that.birthYear) && Objects.equals(gender, that.gender) && Objects.equals(homeWorld, that.homeWorld) && Objects.equals(species, that.species);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, height, mass, hairColor, skinColor, eyeColor, birthYear, gender, homeWorld, species);
  }
}
