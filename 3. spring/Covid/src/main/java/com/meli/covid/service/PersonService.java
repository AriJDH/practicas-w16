package com.meli.covid.service;

import com.meli.covid.dto.PersonDto;
import com.meli.covid.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    @Autowired
    IPersonRepository personRepository;

    @Override
    public List<PersonDto> findRiskPerson() {
        return personRepository.findRiskPerson();
    }
}
