package com.deportistas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deportistas.repositories.SportRepository;

import com.deportistas.dto.Persona;
import com.deportistas.dto.Deporte;

import com.deportistas.repositories.AthleteRepository;

@Service
public class SportService {
    @Autowired
    private SportRepository sportRepository;
    private AthleteRepository athleteRepository;

    public SportService() {
        this.sportRepository = new SportRepository();
        this.athleteRepository = new AthleteRepository();
    }

    public List<Deporte> findAll() {
        return sportRepository.findAll();
    }

    public Deporte findByName(String name) {
        return sportRepository.findByName(name);
    }

    public List<Persona> findSportsPersons() {
        return athleteRepository.findSportsPersons();
    }

    
}
