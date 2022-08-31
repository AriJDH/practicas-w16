package com.bootcamp.covid19.services;

import com.bootcamp.covid19.entities.PersonaDTO;
import com.bootcamp.covid19.entities.SintomaDTO;
import com.bootcamp.covid19.entities.SintomaSimpleDTO;
import com.bootcamp.covid19.models.Persona;
import com.bootcamp.covid19.models.Sintoma;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaSintomaService {
  private List<Persona> personas;
  private List<Sintoma> sintomas;

  private void initRepository() {
    this.sintomas.add(new Sintoma("FI", "Fiebre", "Medio"));
    this.sintomas.add(new Sintoma("T", "Tos", "Intermedio"));
    this.sintomas.add(new Sintoma("OF", "Pérdida olfato", "Alto"));
    this.sintomas.add(new Sintoma("GU", "Pérdida gusto", "Alto"));

    this.personas.add(new Persona(1, "Pepe", "Juarez", 25, new ArrayList<>()));
    this.personas.add(new Persona(2, "Pepa", "Pig", 61, Arrays.asList(this.sintomas.get(0), this.sintomas.get(2))));
    this.personas.add(new Persona(3, "Juan", "Perez", 74, new ArrayList<>()));
  }

  public PersonaSintomaService() {
    this.personas = new ArrayList<>();
    this.sintomas = new ArrayList<>();
    this.initRepository();
  }

  public List<SintomaDTO> getAllSintomas() {
    return this.sintomas.stream()
        .map(sintoma -> new SintomaDTO(sintoma.getNombre(), sintoma.getNivelDeGravedad()))
        .collect(Collectors.toList());
  }

  public SintomaSimpleDTO getRiesgoSintoma(String nombre) {
    return new SintomaSimpleDTO(this.sintomas.stream()
        .filter(sintoma -> sintoma.getNombre().equalsIgnoreCase(nombre))
        .findFirst()
        .get()
        .getNivelDeGravedad());
  }

  public List<PersonaDTO> getAllGrupoRiesgo() {
    return this.personas.stream()
        .filter(persona -> persona.getEdad().compareTo(60) > -1)
        .filter(persona -> persona.getSintomas().size() > 0)
        .map(persona -> new PersonaDTO(
                persona.getNombre(),
                persona.getApellido(),
                persona.getEdad(),
                persona.getSintomas().stream()
                    .map(Sintoma::getNombre)
                    .collect(Collectors.toList())
            )
        )
        .collect(Collectors.toList());
  }
}