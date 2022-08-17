package com.bootcamp.agencia.service;

import com.bootcamp.agencia.entitiy.*;
import com.bootcamp.agencia.repository.LocalizadorRepository;

import java.util.List;
import java.util.stream.Collectors;

public class LocalizadorService {

    public Double calculcarTotal(Localizador localizador){
        Double precio = localizador.getReservas().stream()
                .mapToDouble(x -> x.getPrecio()).sum();

        var listaLocalizadorCliente = LocalizadorRepository.getLocalizadorPorCliente(localizador.getCliente().getId());

        Double descuentoTotal = 0.0;

        if(listaLocalizadorCliente.size() >= 2){
            descuentoTotal += 0.05;
        }
        if (poseeTodasLasReservas(localizador.getReservas())){
            descuentoTotal +=0.10;
        }
        if (poseeDosReservasHoteloDosBoletosVieje(localizador.getReservas())){
            descuentoTotal += 0.05;
        }

        return precio * (1-descuentoTotal);
    }

    public boolean poseeDosReservasHoteloDosBoletosVieje(List<Reserva> reservas) {
        Boolean hayDosBoletosViaje = reservas.stream().filter(x -> x.getClass() == BoletoViaje.class).collect(Collectors.toList()).size() >=2;
        Boolean hayReservaHotel = reservas.stream().filter(y -> y.getClass() == Hotel.class).collect(Collectors.toList()).size() >= 1;

        return hayDosBoletosViaje || hayReservaHotel;
    }

    public boolean poseeTodasLasReservas(List<Reserva> reservas) {
        return reservas.stream().map(Reserva::getClass).collect(Collectors.toSet()).size() == 4;
    }

    public void diccionarioTodasLasReservas(){

        System.out.println("--Diccionario de reservas---");
        System.out.println("<<Boletos de Viaje>>");
        Reserva.diccionarioReservaPorTipo(BoletoViaje.class.getSimpleName());
        System.out.println("");
        System.out.println("<<Reservas de Comida>>");
        Reserva.diccionarioReservaPorTipo(Comida.class.getSimpleName());
        System.out.println("");
        System.out.println("<<Reservas de Hotel>>");
        Reserva.diccionarioReservaPorTipo(Hotel.class.getSimpleName());
        System.out.println("");
        System.out.println("<<Reservas de Transporte>>");
        Reserva.diccionarioReservaPorTipo(Transporte.class.getSimpleName());
    }

    public double totalVentas(){
        return  LocalizadorRepository.getAll().stream()
                .mapToDouble(Localizador::getPrecio)
                .sum();
    }

    public double promedioDeVentas(){
        return LocalizadorRepository.getAll().stream()
                .mapToDouble(Localizador::getPrecio)
                .average().getAsDouble();
    }


}
