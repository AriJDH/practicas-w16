package com.bootcamp.deportes.services;

import com.bootcamp.deportes.models.Deporte;
import com.bootcamp.deportes.models.Persona;
import com.bootcamp.deportes.models.SportPersonPOJO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeporteService {

    public static List<Deporte> cargarDeportes(){
        List<Deporte> deportes = new ArrayList<>();
        Persona p1 = new Persona("Rodrigo","Cifuentes",26);
        Persona p2 = new Persona("Alberto","Vasquez",25);
        Persona p3 = new Persona("Camilo","Munoz",24);
        Persona p4 = new Persona("Javier","Godoy",25);
        Persona p5 = new Persona("Cristian","Villegas",25);
        Persona p6 = new Persona("Tomas","Rey",20);

        List<Persona> personasPadel = new ArrayList<>();
        List<Persona> personasSoccer = new ArrayList<>();
        personasPadel.add(p4);
        personasPadel.add(p5);

        personasSoccer.add(p1);
        personasSoccer.add(p2);
        personasSoccer.add(p3);
        personasSoccer.add(p6);



        Deporte d1 = new Deporte("Padel","Profesional",personasPadel);
        Deporte d2 = new Deporte("Soccer","Amateur",personasSoccer);
        deportes.add(d1);
        deportes.add(d2);

        return deportes;
    }

    public static List<Persona> cargarPersona(){
        List<Persona> personas = new ArrayList<>();
        Persona p1 = new Persona("Rodrigo","Cifuentes",26);
        Persona p2 = new Persona("Alberto","Vasquez",25);
        Persona p3 = new Persona("Camilo","Munoz",24);
        Persona p4 = new Persona("Javier","Godoy",25);
        Persona p5 = new Persona("Cristian","Villegas",25);
        Persona p6 = new Persona("Tomas","Rey",20);
        personas.add(p1);
        personas.add(p2);
        personas.add(p3);
        personas.add(p4);
        personas.add(p5);
        personas.add(p6);

        return personas;
    }



    public List<Deporte> findSports(){
        return cargarDeportes();
    }

    public List<Deporte> findSportByName(String nombre){
        return cargarDeportes().stream().filter(d -> d.getNombre().equals(nombre)).collect(Collectors.toList());

    }

    public List<SportPersonPOJO> findSportPerson(){
        List<Deporte> deportes = cargarDeportes();
        List<SportPersonPOJO> sportsPersons = new ArrayList<>();



        for(Deporte deporte :deportes ){
            for(Persona persona : deporte.getPersonas()){
                SportPersonPOJO pojo = new SportPersonPOJO(persona.getNombre(),persona.getApellido(),deporte.getNombre());
                sportsPersons.add(pojo);
            }
        }

        return sportsPersons;

    }

}
