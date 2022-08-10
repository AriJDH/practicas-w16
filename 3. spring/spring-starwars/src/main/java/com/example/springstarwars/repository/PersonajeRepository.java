package com.example.springstarwars.repository;

import com.example.springstarwars.dao.PersonajeDao;
import com.example.springstarwars.dto.RequestPersonajeDTO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@Repository
public class PersonajeRepository {
    @Autowired
    private PersonajeDao personajeDao;

    public void cargarPersonajes(List<RequestPersonajeDTO> body) {
        this.personajeDao.setPersonajes(personajeDao.getUtils().convertToPersonajeList(body));
    }
}
