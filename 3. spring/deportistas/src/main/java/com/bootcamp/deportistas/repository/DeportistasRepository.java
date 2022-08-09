package com.bootcamp.deportistas.repository;

import com.bootcamp.deportistas.models.Deportista;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@NoArgsConstructor
public class DeportistasRepository {
    ArrayList<Deportista> deportistaArray;

    public void addDeportistas(Deportista deportista) {
        deportistaArray.add(deportista);
    }
}
