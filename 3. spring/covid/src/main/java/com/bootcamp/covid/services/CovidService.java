package com.bootcamp.covid.services;

import com.bootcamp.covid.dtos.RiskPersonDTO;
import com.bootcamp.covid.dtos.SymptomDTO;
import com.bootcamp.covid.entities.Person;
import com.bootcamp.covid.entities.PersonSymptom;
import com.bootcamp.covid.entities.Symptom;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CovidService {
    private final Set<Person> people = new HashSet<>();
    private final Set<PersonSymptom> personSymptoms = new HashSet<>();
    private final Set<Symptom> symptoms = new HashSet<>();

    public CovidService() {
        Person p1 = new Person("1", "John", "Doe", 36);
        Person p2 = new Person("2", "Jhon", "Do", 63);
        Person p3 = new Person("3", "Jon", "Doo", 18);
        Person p4 = new Person("4", "Jn", "De", 40);

        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);

        Symptom s1 = new Symptom("11-1", "Fiebre", 2);
        Symptom s2 = new Symptom("123", "Tos", 1);
        Symptom s3 = new Symptom("0", "Algo", 3);

        symptoms.add(s1);
        symptoms.add(s2);
        symptoms.add(s3);

        personSymptoms.add(new PersonSymptom(p1, s1));
        personSymptoms.add(new PersonSymptom(p2, s2));
        personSymptoms.add(new PersonSymptom(p2, s3));
        personSymptoms.add(new PersonSymptom(p3, s3));
    }

    public List<SymptomDTO> getSymptoms() {
        return symptoms.stream()
                .map(s -> new SymptomDTO(s.getCode(), s.getName(), s.getSeverity()))
                .collect(Collectors.toList());
    }

    public SymptomDTO getSymptom(String name) {
        return symptoms.stream()
                .filter(s -> s.getName().equals(name))
                .map(s -> new SymptomDTO(s.getCode(), s.getName(), s.getSeverity()))
                .findFirst()
                .orElse(null);
    }

    private List<SymptomDTO> getPersonSymptoms(Person person) {
        return personSymptoms.stream()
                .filter(ps -> ps.getPerson().equals(person))
                .map(PersonSymptom::getSymptom)
                .map(s -> new SymptomDTO(s.getCode(), s.getName(), s.getSeverity()))
                .collect(Collectors.toList());
    }

    public List<RiskPersonDTO> getRiskPeople() {
        return people.stream()
                .map(p -> new RiskPersonDTO(
                        p.getId(),
                        p.getFirstname(),
                        p.getLastname(),
                        p.getAge(),
                        getPersonSymptoms(p)))
                .filter(rp -> !rp.getSymptoms().isEmpty() && rp.getAge() >= 60)
                .collect(Collectors.toList());
    }
}
