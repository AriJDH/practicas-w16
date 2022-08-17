package com.bootcamp.agencia.entitiy;

import com.bootcamp.agencia.repository.LocalizadorRepository;

import java.util.stream.Collectors;

public abstract class Reserva {
    protected Double precio;

    public Reserva(Double precio) {
        this.precio = precio;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public static void diccionarioReservaPorTipo(String tipoResera){
        LocalizadorRepository.getAll().stream()
                .map(x -> x.getReservas())
                .forEach(y -> y.stream()
                        .filter(z -> z.getClass().getSimpleName().equalsIgnoreCase(tipoResera))
                        .collect(Collectors.toList())
                        .forEach(reserva -> System.out.println(reserva)));
    }
}
