package com.example.ejerciciodeportistas.entities.covid;

import com.example.ejerciciodeportistas.repository.Repository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@NoArgsConstructor
public class PersonaCovid {
    public Persona Persona ;
    public Optional<Sintoma> Sintoma;
}
