package com.bootcamp.agencia.repository;

import com.bootcamp.agencia.entitiy.Localizador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LocalizadorRepository {
    private static List<Localizador> localizadores = new ArrayList<>();

    public static void agregarLocalizador(Localizador localizador){
        localizadores.add(localizador);
    }

    public static List<Localizador> getLocalizadorPorCliente(Integer id){
        return localizadores.stream()
                .filter(x -> x.getCliente().getId().equals(id))
                .collect(Collectors.toList());
    }

    public static List<Localizador> getAll(){
        return localizadores;
    }
}
