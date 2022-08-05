package com.example.covid19.service;

import com.example.covid19.dto.NivelSintomaDTO;
import com.example.covid19.dto.PersonaRiesgoDTO;
import com.example.covid19.dto.SintomaDTO;
import com.example.covid19.entity.Persona;
import com.example.covid19.entity.Sintoma;
import com.example.covid19.repository.CovidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CovidService {

    @Autowired
    private CovidRepository repository;

    public List<SintomaDTO> obtenerSintomas() {
        return repository.obtenerSintomas().stream()
                .map(s -> new SintomaDTO(s.getCodigo(), s.getNombre(), s.getNivel_de_gravedad()))
                .collect(Collectors.toList());
    }

    public Optional<NivelSintomaDTO> obtenerNivelSintoma(String nombre) {
        return repository.obtenerSintomas().stream()
                .filter(sintoma -> sintoma.getNombre().equals(nombre))
                .findFirst()
                .map(sintoma -> new NivelSintomaDTO(sintoma.getNivel_de_gravedad()));
    }

    public List<PersonaRiesgoDTO> obtenerPersonasRiesgo() {
        return repository.obtenerPersonas().stream()
                .filter(p -> p.getEdad() >= 60 && p.getSintomas().size() > 0)
                .map(p -> new PersonaRiesgoDTO(p.getNombre(), p.getApellido()))
                .collect(Collectors.toList());
    }
}
