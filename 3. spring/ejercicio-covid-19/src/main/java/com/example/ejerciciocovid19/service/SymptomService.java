package com.example.ejerciciocovid19.service;

import com.example.ejerciciocovid19.model.Symptom;
import com.example.ejerciciocovid19.repository.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomService {

    private final SymptomRepository symptomRepository;

    @Autowired
    public SymptomService(SymptomRepository symptomRepository) {
        this.symptomRepository = symptomRepository;
    }

    public List<Symptom> getSymptoms() {
        return symptomRepository.getSymptoms();
    }

    public Integer getGravityLevelOfSymptomNamed(String aSymptomName) {
        Symptom symptom = symptomRepository.getSymptomNamed(aSymptomName).orElseThrow(() -> new RuntimeException("No se encontro un sintoma con el nombre dado."));
        return symptom.getGravityLevel();
    }
}
