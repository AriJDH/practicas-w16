package com.example.deportista.Repository;

import com.example.deportista.Entity.Deporte;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RepositoryDeporte {
    private static List<Deporte> deportes = new ArrayList<>();

    public static List<Deporte> allDeportes(){
        Deporte deporte1 = new Deporte("Futbol","avanzado");
        Deporte deporte2 = new Deporte("Hockey","medio");
        deportes.add(deporte1);
        deportes.add(deporte2);
        return deportes;
    }




}
