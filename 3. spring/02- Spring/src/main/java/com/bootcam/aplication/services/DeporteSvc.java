package com.bootcam.aplication.services;

import com.bootcam.aplication.entities.Deporte;
import com.bootcam.aplication.entities.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeporteSvc {
    private List<Deporte> lstDeporte;
    private List<Persona> lstPersona;

    public DeporteSvc() {
        llenadoVariable();
    }



    private void llenadoVariable(){
        this.lstDeporte = new ArrayList<>();
        this.lstPersona = new ArrayList<>();
        this.lstDeporte.add(new Deporte("Soccer", "Medio"));
        this.lstDeporte.add(new Deporte("Tenis", "Alto"));
        this.lstDeporte.add(new Deporte("Natación", "Básico"));

        this.lstPersona.add(new Persona("Pedro", "Lara", 26));
        this.lstPersona.add(new Persona("Julio", "Troncoso", 21));
        this.lstPersona.add(new Persona("Maria", "Lopez", 25));

    }
}
