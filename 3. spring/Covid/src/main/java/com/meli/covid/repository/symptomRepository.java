package com.meli.covid.repository;

import com.meli.covid.Util.Util;
import com.meli.covid.dto.SymptomDto;
import com.meli.covid.entity.Symptom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class symptomRepository implements ISymptomRepository {

    private List<Symptom> symptoms;

    public symptomRepository() {
        symptoms = new ArrayList<>();
        loadData();
    }

    public void loadData() {
        symptoms.add(new Symptom(1,"Fiebre", 2));
        symptoms.add(new Symptom(2,"Tos", 3));
        symptoms.add(new Symptom(3,"Cansancio", 1));
        symptoms.add(new Symptom(4,"Pérdida del gusto", 2));
    }

    @Override
    public List<SymptomDto> findSymptom() {
        return symptoms.stream().map(symptom -> Util.castTo(symptom, SymptomDto.class)).collect(Collectors.toList());
    }

    @Override
    public SymptomDto findSymptomByName(String name) {
        Symptom symptom = symptoms.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
        return Util.castTo(symptom, SymptomDto.class);
    }
}
