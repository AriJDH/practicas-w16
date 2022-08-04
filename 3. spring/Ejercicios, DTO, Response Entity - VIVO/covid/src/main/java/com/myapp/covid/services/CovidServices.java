package com.myapp.covid.services;

import com.myapp.covid.dtos.PatientDTO;
import com.myapp.covid.dtos.SymptomDTO;
import com.myapp.covid.entities.Patient;
import com.myapp.covid.entities.Person;
import com.myapp.covid.entities.Symptom;
import com.myapp.covid.utilities.Severities;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CovidServices {
    private final List<Patient> listPatient = new ArrayList<>();
    private final List<Person> listPerson = new ArrayList<>();

    private final List<Symptom> listSymptom = new ArrayList<>();

    public CovidServices() {
        Symptom s1 = Symptom.builder().cod("01").name("Dificultad para respirar").severity(Severities.Alto.name()).build();
        Symptom s2 = Symptom.builder().cod("02").name("Fiebre").severity(Severities.Medio.name()).build();
        Symptom s3 = Symptom.builder().cod("03").name("Nauceas").severity(Severities.Bajo.name()).build();

        listSymptom.add(s1);
        listSymptom.add(s2);
        listSymptom.add(s3);

        Person p1=Person.builder().id(1).firstName("Jessica").lastName("Alex").age(27).build();
        Person p2=Person.builder().id(2).firstName("Maria").lastName("Castro").age(56).build();
        Person p3=Person.builder().id(3).firstName("Hector").lastName("Alten").age(60).build();
        Person p4=Person.builder().id(4).firstName("Sofia").lastName("Ruiz").age(75).build();
        Person p5=Person.builder().id(5).firstName("Hugo").lastName("Doe").age(63).build();

        listPerson.add(p1);
        listPerson.add(p2);
        listPerson.add(p3);
        listPerson.add(p4);
        listPerson.add(p5);

        List<Symptom> sym1 = new ArrayList<>(Arrays.asList(s1,s3));
        List<Symptom> sym2 = new ArrayList<>(Arrays.asList(s1,s2));
        List<Symptom> sym3 = new ArrayList<>(Arrays.asList(s2,s3));
        List<Symptom> sym4 = new ArrayList<>(Arrays.asList(s3));

        Patient pa1 = Patient.builder().person(p1).symptoms(sym1).build();
        Patient pa2 = Patient.builder().person(p2).symptoms(sym2).build();
        Patient pa3 = Patient.builder().person(p3).symptoms(sym3).build();
        Patient pa4 = Patient.builder().person(p4).symptoms(sym4).build();

        listPatient.add(pa1);
        listPatient.add(pa2);
        listPatient.add(pa3);
        listPatient.add(pa4);

    }

    //PATH: /findSymptom
    public List<SymptomDTO> getAllSymptom(){
        return listSymptom.stream()
                .map(symptom -> {
                    SymptomDTO symptomDTO = new SymptomDTO();
                    symptomDTO.setCod(symptom.getCod());
                    symptomDTO.setName(symptom.getName());
                    symptomDTO.setSeverity(symptom.getSeverity());
                    return symptomDTO;
                }).collect(Collectors.toList());
    }
    //PATH: /findSymptom/{name}
    public SymptomDTO findSymptom(String name){
        Symptom sym= listSymptom.stream()
                .filter(symptom -> symptom.getName().equals(name))
                .findFirst()
                .orElse(null);
        if (sym==null){
            return null;
        }
        SymptomDTO symptomDTO = new SymptomDTO();
        symptomDTO.setCod(sym.getCod());
        symptomDTO.setName(sym.getName());
        symptomDTO.setSeverity(sym.getSeverity());
        return symptomDTO;
    }

    //PATH: /findRiskPerson
    public List<PatientDTO> findRiskPerson(){
        return listPatient.stream()
                .filter(patient -> Integer.compare(patient.getPerson().getAge(), 60) >= 0)
                .map(patient -> {
                    PatientDTO patientDTO = new PatientDTO();
                    patientDTO.setPerson_firstName(patient.getPerson().getFirstName());
                    patientDTO.setPerson_lastName(patient.getPerson().getLastName());
                    patientDTO.setAge(patient.getPerson().getAge());
                    patientDTO.setSymptoms_names(patient.getSymptoms().stream()
                            .map(s -> {
                                String name = s.getName();
                                return name;
                            }).collect(Collectors.toList()));
                    return patientDTO;
                }).collect(Collectors.toList());
    }
}
