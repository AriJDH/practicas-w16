package com.meli.covid.dtos;

import com.meli.covid.entity.Persona;
import com.meli.covid.entity.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pasientedtos {

    private Persona persona;
    private List<Sintoma> sintomas;


}
