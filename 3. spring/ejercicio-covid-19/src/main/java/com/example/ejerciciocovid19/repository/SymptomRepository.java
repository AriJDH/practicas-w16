package com.example.ejerciciocovid19.repository;

import com.example.ejerciciocovid19.model.Symptom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SymptomRepository {

    private final List<Symptom> symptoms;

    public SymptomRepository() {
        symptoms = new ArrayList<>();
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    public Optional<Symptom> getSymptomNamed(String aSymptomName) {
        return symptoms.stream().filter(symptom -> symptom.getName().equals(aSymptomName)).findFirst();
    }
}
