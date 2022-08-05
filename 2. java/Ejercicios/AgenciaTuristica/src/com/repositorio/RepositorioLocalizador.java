package com.repositorio;

import com.clases.Localizador;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioLocalizador {
    private static List<Localizador> localizadores;

    public RepositorioLocalizador() {
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        RepositorioLocalizador.localizadores = localizadores;
    }

    public boolean clienteVip(String dni) {
        if (localizadores!=null) {
            List<Localizador> clientesXDni = localizadores.stream()
                    .filter(localizador -> localizador.getCliente().getDni().equals(dni)).collect(Collectors.toList());
            System.out.println(clientesXDni.stream().count());
            return clientesXDni.stream().count() >= 2;
        }else{
            return false;
        }

    }

}


