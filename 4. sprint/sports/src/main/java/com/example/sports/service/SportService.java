package com.example.sports.service;

import com.example.sports.dto.response.SportDTO;
import com.example.sports.dto.response.SportLevelDTO;
import com.example.sports.entity.ISport;
import com.example.sports.exception.NotFoundException;
import com.example.sports.repository.ISportRepository;
import com.example.sports.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportService {

    @Autowired
    private ISportRepository sportRepository;

    public List<SportDTO> findALl() {
        List<ISport> sports = this.sportRepository.findAll();
        return Mapper.parseToSportDTO(sports);
    }
    public SportLevelDTO findByName(String name) {
        ISport sport = this.sportRepository.findByName(name);
        if(sport == null) {
            throw new NotFoundException("The sport does not exists in the database");
        }
        return Mapper.parseSportLevelDTO(sport);
    }
}
