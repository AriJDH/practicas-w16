package com.tomas.agencia.repository;

import com.tomas.agencia.models.Localizadores;

public class LocalizadoresRepository implements ILocalizadores{

    @Override
    public Localizadores crearLocalizador(Localizadores localizadores) {
        if(localizadores != null){
            System.out.println("Localizador creado");
            System.out.println(localizadores.toString());
            return localizadores;
        }

        System.out.println("Error en ingresar Localizador");
        return null;
    }
}