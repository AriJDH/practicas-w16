package com.bootcamp.practico.repository;

import com.bootcamp.practico.dao.PersonajeDao;
import com.bootcamp.practico.dto.RequestPersonajeDTO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Data
@Repository
public class PersonajeRepository {

    @Autowired
    private PersonajeDao personajeDao;


    public void cargarPersonaje(List<RequestPersonajeDTO> body) {

        personajeDao.setPersonajes(personajeDao.getUtils().convertToPersonaje(body));
    }


}
