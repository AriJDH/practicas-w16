package com.bootcamp.practico.repository;

import com.bootcamp.practico.entity.Person;
import com.bootcamp.practico.entity.Symptom;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Data
public class HealthRepository {

    private List<Symptom> symptoms;
    private List<Person> persons;

    public HealthRepository() {
        symptoms = new ArrayList<>();
        persons = new ArrayList<>();
        init();
    }


    public void init() {

        Symptom oneS = Symptom.builder().id(1).name("dolor de cabeza").level(1).build();
        Symptom twoS = Symptom.builder().id(2).name("tos").level(2).build();
        Symptom threeS = Symptom.builder().id(3).name("fiebre").level(3).build();

        List<Symptom> loadSymptomList = new ArrayList<>();
        loadSymptomList.add(oneS);
        loadSymptomList.add(twoS);
        loadSymptomList.add(threeS);

        Person oneP = Person.builder().id(1).age(61).name("carlos").lastname("carlitos").symptom(loadSymptomList).build();
        Person twoP = Person.builder().id(2).age(61).name("juan").lastname("juanes").symptom(loadSymptomList).build();
        Person threeP = Person.builder().id(3).age(59).name("maria").lastname("marie").symptom(loadSymptomList).build();
        Person fourP = Person.builder().id(4).age(58).name("roberto").lastname("robertito").build();

        symptoms.add(oneS);
        symptoms.add(twoS);
        symptoms.add(threeS);

        persons.add(oneP);
        persons.add(twoP);
        persons.add(threeP);
        persons.add(fourP);

    }



}
