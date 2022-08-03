package com.example.ejcovid19.services;

import com.example.ejcovid19.entities.Sintoma;
import lombok.Data;

import java.util.List;

@Data
public class SintomaService
{
    private List<Sintoma> sintomas = List.of(
            new Sintoma(1, "fiebre", "Alta"),
            new Sintoma(2, "tos", "Media"),
            new Sintoma(3, "dificultad para respirar", "Baja")
    );

    public Sintoma getSintoma(String name)
    {
        try{
            var sintoma = sintomas.stream()
                    .filter(s -> s.getNombre().equalsIgnoreCase(name))
                    .findFirst()
                    .orElse(null);

            if(sintoma == null)
                throw new Exception("Sintoma no encontrado");

            return sintoma;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }

    }

}
