package com.bootcamp.calculadoracalorias.repository;

import com.bootcamp.calculadoracalorias.entity.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ParseJson {

  public List<Ingrediente> cargarIngredientes() {
    try {
      Reader reader = new FileReader("src/main/resources/3. food.json");

      ObjectMapper mapper = new ObjectMapper();
      List<Ingrediente> ingredientes = mapper.readValue(reader, new TypeReference<List<Ingrediente>>() {
      });
      return ingredientes;

    } catch (IOException e) {
      e.printStackTrace();
    }
    return List.of();
  }
}
