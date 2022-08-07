package com.mercadolibre.bootcamp.covid19.repository;

import com.mercadolibre.bootcamp.covid19.models.Symptom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SymptomRepository {

    private List<Symptom> symptoms = new ArrayList<>();

    public List<Symptom> getAllSymptoms() {
        return symptoms;
    }

    public Symptom getByName(String name) {
        return symptoms
                .stream()
                .filter(symptom -> symptom.getName().equalsIgnoreCase(name))
                .findFirst().get();
    }

    public void add(Symptom sym){
        symptoms.add(sym);
    }


}
