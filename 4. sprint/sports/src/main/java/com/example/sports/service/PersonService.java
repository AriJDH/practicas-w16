package com.example.sports.service;

import com.example.sports.dto.response.PersonWithSportDTO;
import com.example.sports.entity.IPerson;
import com.example.sports.entity.ISport;
import com.example.sports.entity.Person;
import com.example.sports.repository.IPersonRepository;
import com.example.sports.repository.ISportRepository;
import com.example.sports.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private ISportRepository sportRepository;
    @Autowired
    private IPersonRepository personRepository;
    public List<PersonWithSportDTO> findSportsPersons() {
        List<IPerson> sportsman = this.personRepository.findAllSportsman();
        Map<Integer, ISport> sports = this.sportRepository.findByIds(sportsman.stream().map(IPerson::getSportId).collect(Collectors.toList()));
        return Mapper.parsePersonWithSportDTO(sportsman, sports);
    }
}
