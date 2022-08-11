package com.deportistas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.deportistas.repositories.SportRepository;

import com.deportistas.dto.Deporte;
import com.deportistas.dto.DeportistaDTO;
import com.deportistas.exceptions.CustomDataNotFoundException;
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
        Deporte sport = sportRepository.findByName(name);

        if(sport == null) {
            throw new CustomDataNotFoundException(
                HttpStatus.NOT_FOUND,
                "Sport not found",
                "Deporte no encontrado"
            );
        }

        return sport;
    }

    public List<DeportistaDTO> findSportsPersons() {
        return athleteRepository.findSportsPersons();
    }

    
}
