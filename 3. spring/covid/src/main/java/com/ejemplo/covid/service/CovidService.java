package com.ejemplo.covid.service;

import com.ejemplo.covid.dto.*;
import com.ejemplo.covid.entity.Persona;
import com.ejemplo.covid.entity.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CovidService {

    List<Sintoma> sintomas = new ArrayList<>();
    List<Persona> personas = new ArrayList<>();

    public List<Sintoma> chargeSymptom() {
        sintomas.add(new Sintoma(1,"Fiebre",4));
        sintomas.add(new Sintoma(1,"Dolor de Cabeza",5));
        sintomas.add(new Sintoma(1,"Perdida del olfato",6));

        return sintomas;
    }

    public List<Persona> chargePerson() {
        personas.add(new Persona(1,"Juan","Hernandez",23));
        personas.add(new Persona(2,"Sebastian","Anzola",63));

        return personas;
    }

    public SintomaDTO findSymptom() {
        List<Sintoma> sintomas = chargeSymptom();
        return new SintomaDTO(sintomas);
    }

    public ResSintomaDTO findSymptom(ReqSintomaDTO nombre) {
        List<Sintoma> sintomas = chargeSymptom();

        ResSintomaDTO sintoma = new ResSintomaDTO();
        for (Sintoma sin : sintomas) {
            if (sin.getNombre().equals(nombre.getNombre())) {
                sintoma.setNivel(sin.getNivelDeGravedad());
            }
        }

        return sintoma;
    }

    public List<ResPersonaDTO> findRiskPerson() {
        List<Sintoma> sintomas = chargeSymptom();
        List<Persona> personas = chargePerson();

        ResPersonaDTO resPersonaDTO = new ResPersonaDTO(personas.get(0), sintomas);
        ResPersonaDTO resPersonaDTO1 = new ResPersonaDTO(personas.get(1), sintomas);

        List<ResPersonaDTO> list = new ArrayList<>(Arrays.asList(resPersonaDTO,resPersonaDTO1));

        for (ResPersonaDTO res : list) {
            if (res.getPersona().getEdad() < 60) {
                list.remove(res);
            }
        }

        return list;
    }

}
