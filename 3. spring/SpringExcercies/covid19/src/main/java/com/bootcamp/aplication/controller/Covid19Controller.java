package com.bootcamp.aplication.controller;

import com.bootcamp.aplication.DTO.PersonDTO;
import com.bootcamp.aplication.DTO.RiskPersonDTO;
import com.bootcamp.aplication.DTO.SymptomDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Covid19Controller {

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SymptomDTO>> findSymptom() {
        return ResponseEntity
                .ok()
                .body(preloadSintomas());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SymptomDTO> findSymptomByName(@PathVariable String name) {

        return ResponseEntity
                .ok()
                .body(getFindSymptom(name));
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<RiskPersonDTO>> findRiskPerson() {

        return ResponseEntity
                .ok()
                .body(getRiskPerson());
    }

    public List<SymptomDTO> preloadSintomas() {
        return preloadData().stream()
                .map(personDTO -> personDTO.getSintomas())
                .filter(symptomNoNull -> symptomNoNull != null)
                .filter(symptomNoEmpty -> symptomNoEmpty.getNombre() != null)
                .collect(Collectors.toList());
    }

    public SymptomDTO getFindSymptom(String name) {

        SymptomDTO sintoma = preloadSintomas().stream()
                .filter(symptom -> symptom.getNombre().toUpperCase().equals(name.toUpperCase()))
                .map(response ->
                        new SymptomDTO((response).getCodigo(), response.getNombre(), response.getNivel_de_gravedad()))
                .findAny().get();

        return sintoma;
    }

    public List<RiskPersonDTO> getRiskPerson() {

        List<RiskPersonDTO> riskPersonList = new ArrayList<>();

        preloadData().stream()
                .filter(data -> data.getEdad() >= 60)
                .filter(symptomNoNull -> symptomNoNull != null)
                .forEach(riskData ->
                        riskPersonList.add(new RiskPersonDTO(riskData.getNombre(), riskData.getApellido())));

        return riskPersonList;
    }

    public List<PersonDTO> preloadData() {

        List<SymptomDTO> symptomDTOList = new ArrayList<>();

        SymptomDTO fiebre = new SymptomDTO(5867, "Fiebre", "Bajo");
        symptomDTOList.add(fiebre);

        SymptomDTO tos = new SymptomDTO(8125, "Tos", "Medio");
        symptomDTOList.add(tos);

        SymptomDTO dolorArticular = new SymptomDTO();
        symptomDTOList.add(dolorArticular);

        SymptomDTO sordera = new SymptomDTO(3956, "Sordera", "Alto");
        symptomDTOList.add(sordera);

        SymptomDTO escalofrio = new SymptomDTO(2019, "Escalofrio", "Riesgo");
        symptomDTOList.add(escalofrio);

        List<PersonDTO> personDTOList = new ArrayList<>();

        PersonDTO personDTO1 = new PersonDTO(1234, "Daniel", "Patiño", 26, fiebre);
        personDTOList.add(personDTO1);

        PersonDTO personDTO2 = new PersonDTO(3456, "Maria", "Sanchez", 78);
        personDTOList.add(personDTO2);

        PersonDTO personDTO3 = new PersonDTO(5657, "Isabel", "Paffen", 21, tos);
        personDTOList.add(personDTO3);

        PersonDTO personDTO4 = new PersonDTO(7890, "Andrea", "Garcia", 68, dolorArticular);
        personDTOList.add(personDTO4);

        PersonDTO personDTO5 = new PersonDTO(4930, "Julian", "Gaviria", 18, sordera);
        personDTOList.add(personDTO5);

        PersonDTO personDTO6 = new PersonDTO(5087, "Kevin", "Vargas", 80, escalofrio);
        personDTOList.add(personDTO6);

        return personDTOList;
    }
}
