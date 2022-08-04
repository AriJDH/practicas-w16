package com.bootcamp.ejerciciocovid19.services;

import com.bootcamp.ejerciciocovid19.dtos.RiskPersonDTO;
import com.bootcamp.ejerciciocovid19.dtos.SymptomDTO;
import com.bootcamp.ejerciciocovid19.entities.Person;
import com.bootcamp.ejerciciocovid19.entities.Symptom;
import com.bootcamp.ejerciciocovid19.repositories.PersonRepository;
import com.bootcamp.ejerciciocovid19.repositories.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SymptomService {

    public List<SymptomDTO> findAllSymptoms(){
        List<SymptomDTO> symptomDTOList = new ArrayList<>();

        for (Symptom symptom: SymptomRepository.getAllSymptoms()){
            SymptomDTO symptomDTO = new SymptomDTO();
            symptomDTO.setCode(symptom.getCode());
            symptomDTO.setName(symptom.getName());
            symptomDTO.setLevel_of_gravity(symptom.getLevel_of_gravity());
            symptomDTOList.add(symptomDTO);
        }
        return symptomDTOList;
    }

    public SymptomDTO findSymptomName(String name){
        SymptomDTO symptomDTO = new SymptomDTO();

        for (Symptom symptom: SymptomRepository.getAllSymptoms()){
            if (symptom.getName().equals(name)){
                symptomDTO.setCode(symptom.getCode());
                symptomDTO.setName(symptom.getName());
                symptomDTO.setLevel_of_gravity(symptom.getLevel_of_gravity());
            }
            break;
        }
        return symptomDTO;
    }

    public List<RiskPersonDTO> findRiskPersons(){
        List<RiskPersonDTO> riskPersonDTOList = new ArrayList<>();

        for (Person person: PersonRepository.getAllPersons()){
            if (person.getSymptomList().size() > 0 && person.getAge() >= 60){
                RiskPersonDTO riskPersonDTO = new RiskPersonDTO(person.getName(), person.getLastname());
                riskPersonDTOList.add(riskPersonDTO);
            }
        }
        return riskPersonDTOList;
    }
}
