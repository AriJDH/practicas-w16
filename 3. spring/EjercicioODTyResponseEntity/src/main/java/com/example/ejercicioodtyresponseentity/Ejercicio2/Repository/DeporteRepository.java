package com.example.ejercicioodtyresponseentity.Ejercicio2.Repository;

import com.example.ejercicioodtyresponseentity.Ejercicio2.Entity.Deporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public class DeporteRepository {
    ArrayList<Deporte> deportes = new ArrayList<>();

    public void agregarDeporte(Deporte deporte) {
        deportes.add(deporte);
    }
    public ArrayList<Deporte> showDeportes() {return deportes;}




}
