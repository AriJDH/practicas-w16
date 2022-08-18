package com.example.covid19.service;

import com.example.covid19.dto.request.PersonReqDTO;
import com.example.covid19.dto.request.SymthompReqDTO;
import com.example.covid19.dto.response.FindRiskPersonDTO;
import com.example.covid19.entity.*;
import com.example.covid19.repository.IPersonRepository;
import com.example.covid19.repository.IPersonSymthompRepository;
import com.example.covid19.repository.IRepository;
import com.example.covid19.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    IPersonRepository personRepository;
    @Autowired
    IPersonSymthompRepository personSympthompIRepository;
    @Lazy
    @Autowired
    IRepository<ISympthomp> sympthompIRepository;
    public void add(PersonReqDTO person) {
        this.personRepository.add(new Person(person.getName(), person.getLastName(), person.getAge()));
    }
    public void addSymthomp(Integer personId, Integer symthompCode) {
        IPerson person = this.personRepository.findByPK(personId);
        ISympthomp sympthomp = this.sympthompIRepository.findByPK(symthompCode);
        if(person == null) {
            //TODO control de errores
            return;
        }
        if(sympthomp == null) {
            return;
        }
        this.personSympthompIRepository.add(new PersonSympthomp(person.getId(), sympthomp.getCode()));
    }
    public List<FindRiskPersonDTO> findRiskPerson() {
        List<IPerson> people = this.personRepository.findPeopleOlderThan(60);
        Map<Integer, IPersonSympthomp> map = this.personSympthompIRepository
                .findByListPersonIds(people.stream().map(IPerson::getAge).collect(Collectors.toList()));
        return Mapper
                .parseFindRiskPersonDTO(people
                        .stream()
                        .filter(iPerson -> map.get(iPerson.getId()) != null)
                        .collect(Collectors.toList()));
    }
}
