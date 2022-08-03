package com.bootcamp.covid19;

import com.bootcamp.covid19.entities.Person;
import com.bootcamp.covid19.entities.Symptom;
import com.bootcamp.covid19.repository.PersonRepo;
import com.bootcamp.covid19.repository.SymptomRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Covid19Application {

    public static void main(String[] args) {
        SpringApplication.run(Covid19Application.class, args);

        SymptomRepo.symptomList.add(new Symptom("123", "Fever", "High"));
        SymptomRepo.symptomList.add(new Symptom("124", "Cough", "Medium"));
        SymptomRepo.symptomList.add(new Symptom("125", "Headache", "Low"));

        PersonRepo.personList.add(new Person("312321", "Gabriela", "Mejia", 61, List.of(SymptomRepo.getSymptomByName("fever"))));
        PersonRepo.personList.add(new Person("09832", "Manuel", "Mejia", 71, List.of()));
        PersonRepo.personList.add(new Person("24912", "Guillermo", "Marcano", 65, List.of(SymptomRepo.getSymptomByName("Cough"))));
        PersonRepo.personList.add(new Person("2323236", "Liliana", "Trujillo", 53, List.of(SymptomRepo.getSymptomByName("Headache"))));

    }

}
