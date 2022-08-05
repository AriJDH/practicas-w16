package com.example.ejercicioodtyresponseentity.Ejercicio2.Repository;

import com.example.ejercicioodtyresponseentity.Ejercicio2.Entity.Deporte;

import java.util.ArrayList;

public class DeporteRepository {
    int idpersona;
    ArrayList<Deporte> deportes = new ArrayList<>();
    int idDeporte;

    public ArrayList<Deporte> agregarDeporte(String nombreDeporte, String nivel) {
        idDeporte += 1;
        Deporte deporte = new Deporte(idDeporte,nombreDeporte,nivel);
        deportes.add(deporte);
        return deportes;
    }
}
