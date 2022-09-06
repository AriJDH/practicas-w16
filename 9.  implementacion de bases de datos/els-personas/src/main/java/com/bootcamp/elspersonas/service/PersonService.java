package com.bootcamp.elspersonas.service;
import com.bootcamp.elspersonas.model.Person;
import com.bootcamp.elspersonas.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void createPerson(Person newPerson) {
        personRepository.save(newPerson);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id).get();
    }

    public List<Person> getPersons() {
        var persons = personRepository.findAll();
        ArrayList<Person> result = new ArrayList();
        persons.forEach(person -> result.add(person));
        return result;
    }

    public void updatePerson(Long PersonId, Person updatedPerson) {
        updatedPerson.setId(PersonId);
        personRepository.save(updatedPerson);
    }
}
