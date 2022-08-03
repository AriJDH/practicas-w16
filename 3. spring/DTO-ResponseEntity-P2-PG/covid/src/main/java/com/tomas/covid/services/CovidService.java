package com.tomas.covid.services;

import com.tomas.covid.dtos.*;
import com.tomas.covid.entities.Persona;
import com.tomas.covid.entities.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CovidService {

    private final List<Persona> listaPersona = new ArrayList<>();
    private final List<Sintoma> listaSintoma = new ArrayList<>();

    //Constructor del servicio donde se están cargando los datos
    public CovidService() {

        Sintoma sintomaUno = new Sintoma(1L, "Fiebre", "Medio");
        Sintoma sintomaDos = new Sintoma(2L, "Escalofrios", "Bajo");

        listaSintoma.add(sintomaUno);
        listaSintoma.add(sintomaDos);

        List sintomaPersonaUno = new ArrayList();
        Persona personaUno = new Persona(1L,"Yolanda", "Herrera", 34, sintomaPersonaUno);
        listaPersona.add(personaUno);

        List sintomaPersonaDos = new ArrayList();
        sintomaPersonaDos.add(sintomaUno);
        sintomaPersonaDos.add(sintomaDos);
        Persona personaDos = new Persona(2L,"Sebastian", "Cifuentes", 65, sintomaPersonaDos);
        listaPersona.add(personaDos);

        List sintomaPersonaTres = new ArrayList();
        sintomaPersonaTres.add(sintomaUno);
        Persona personaTres = new Persona(3L,"Fernando", "Cabrera", 78, sintomaPersonaTres);
        listaPersona.add(personaTres);


    }

    //Método que obtiene todos los sintomas creados
    public ListaSintomaDto obtenerTodoSintoma(){

        ListaSintomaDto objListaSintomaDto = new ListaSintomaDto();

        objListaSintomaDto.setSintoma(listaSintoma.stream().map(sintoma ->{
            SintomaDto objSintomaDto = new SintomaDto();
            objSintomaDto.setCodigo(sintoma.getCodigo());
            objSintomaDto.setNombre(sintoma.getNombre());
            objSintomaDto.setNivelGravedad(sintoma.getNivelGravedad());

            return objSintomaDto;

        }).collect((Collectors.toList())));

        return objListaSintomaDto;

    }

    //Método que obtiene el nivel de gravedad del síntoma buscado
    public SintomaGravedadDto obtenerSintomaEspecifico(String nombre){

        Sintoma objSintoma = listaSintoma.stream()
                .filter(sintoma -> sintoma.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);

        if(objSintoma == null) {
            return null;
        }

        SintomaGravedadDto objSintomaGravedad = new SintomaGravedadDto();
        objSintomaGravedad.setNivelGravedad(objSintoma.getNivelGravedad());

        return objSintomaGravedad;
    }


    //Método que obtiene las personas con riesgos por edad mayor a 60 y por lo menos 1 síntoma presente
    public ListaPersonaDto obtenerPersonaRiesgo() {

        ListaPersonaDto objListaPersonaDto = new ListaPersonaDto();

        List personaFiltrada = new ArrayList<>();

        for(Persona elemento: listaPersona){

            if(elemento.getEdad() > 60 && elemento.getSintoma().size() > 0) {
                PersonaDto objPersonaDto = new PersonaDto();
                objPersonaDto.setNombre(elemento.getNombre());
                objPersonaDto.setApellido(elemento.getApellido());
                objPersonaDto.setSintoma(elemento.getSintoma());

                personaFiltrada.add(objPersonaDto);
            }

        }

         objListaPersonaDto.setPersona(personaFiltrada);
         return objListaPersonaDto;

    }

}
