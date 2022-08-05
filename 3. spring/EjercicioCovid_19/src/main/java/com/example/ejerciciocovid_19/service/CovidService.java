package com.example.ejerciciocovid_19.service;

import com.example.ejerciciocovid_19.Enums.NivelGravedad;
import com.example.ejerciciocovid_19.dtos.PersonaConSintomasDto;
import com.example.ejerciciocovid_19.dtos.SintomaDto;
import com.example.ejerciciocovid_19.dtos.SintomaGravedadDto;
import com.example.ejerciciocovid_19.entities.Persona;
import com.example.ejerciciocovid_19.entities.Sintoma;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CovidService {
    private Map<String,Sintoma> sintomasMap;
    private Map<Integer,Persona> personasMap;

    public CovidService() {
        sintomasMap = new HashMap<>();
        personasMap = new HashMap<>();

        Sintoma fiebre = new Sintoma("1", "fiebre", NivelGravedad.HIGH);
        Sintoma dolorCabeza = new Sintoma("2", "dolorCabeza", NivelGravedad.MEDIUM);
        Sintoma fatiga = new Sintoma("3", "fatiga", NivelGravedad.LOW);
        Sintoma diarrea = new Sintoma("4", "diarrea", NivelGravedad.MEDIUM);

        sintomasMap.put(fiebre.getCodigo(), fiebre);
        sintomasMap.put(dolorCabeza.getCodigo(), dolorCabeza);
        sintomasMap.put(fatiga.getCodigo(), fatiga);
        sintomasMap.put(diarrea.getCodigo(), diarrea);

        List<Sintoma> listaSintomas1 = new ArrayList<>();
        List<Sintoma> listaSintomas2 = new ArrayList<>();
        List<Sintoma> listaSintomas3 = new ArrayList<>();

        listaSintomas1.add(fiebre);
        listaSintomas1.add(diarrea);
        listaSintomas1.add(fatiga);

        listaSintomas2.add(dolorCabeza);
        listaSintomas2.add(fatiga);

        listaSintomas3.add(diarrea);

        Persona juan = new Persona(1,"Juan","Perez",30,listaSintomas3);
        Persona martina = new Persona(2,"Martina","Lopez",45,listaSintomas2);
        Persona pepe = new Persona(3,"Pepe","Gonzales",65,listaSintomas1);
        Persona ana = new Persona(4,"Ana","Maria",62,null);

        personasMap.put(juan.getId(),juan);
        personasMap.put(martina.getId(),martina);
        personasMap.put(pepe.getId(),pepe);
        personasMap.put(ana.getId(),ana);
    }

    public List<SintomaDto> obtenerListaSintomasCargados(){
        return sintomasMap.values().stream().map(x->new SintomaDto(x.getCodigo(),x.getNombre(),x.getNivel_de_gravedad().toString())).collect(Collectors.toList());
    }

    public SintomaGravedadDto buscarSintoma(String nombreSintoma){
        Optional<Sintoma> sintoma = sintomasMap.values().stream().filter(x->x.getNombre().equalsIgnoreCase(nombreSintoma)).findFirst();

        if(sintoma.isPresent()){
            return new SintomaGravedadDto(sintoma.get().getNivel_de_gravedad().toString());
        }else return null;
    }

    public List<PersonaConSintomasDto> buscarPersonasDeRiesgo(){
        List<PersonaConSintomasDto> listaRetorno = new ArrayList<>();
        personasMap.forEach((x,y)->{
            if(y.getEdad()>=60 && y.getSintomas()!=null){
                List<String> listaSintomas =  new ArrayList<>();
                y.getSintomas().forEach(z->listaSintomas.add(z.getNombre()));
                listaRetorno.add(new PersonaConSintomasDto(y.getNombre(),y.getApellido(),listaSintomas));
            }
        });
        return listaRetorno;
    }
}
