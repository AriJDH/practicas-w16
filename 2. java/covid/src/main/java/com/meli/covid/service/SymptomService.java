package com.meli.covid.service;

import com.meli.covid.entity.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SymptomService {

    private List<Sintoma>  sintomas= List.of(new Sintoma("a23","fiebre","alto "),new Sintoma("a123","tos","moderado"),
            new Sintoma("aa123","dolor de cabeza","bajo"));
}
