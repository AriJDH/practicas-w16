package com.bootcamp;

import com.bootcamp.agencia.entitiy.*;
import com.bootcamp.agencia.repository.LocalizadorRepository;
import com.bootcamp.agencia.service.LocalizadorService;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        LocalizadorService localizadorService = new LocalizadorService();

        Cliente cliente = new Cliente(1, "Andres", "Roa");
        Cliente cliente2 = new Cliente(2, "Felipe", "Rodriguez");
        Cliente cliente3 = new Cliente(3, "Johan", "Sanchez");

        List<Reserva> reserva= List.of(new BoletoViaje(2000.0), new Comida(1200.0), new Hotel(4800.0), new Transporte(8000.0));
        Localizador localizadorCliente = new Localizador(cliente, reserva);
        Double total = localizadorService.calculcarTotal(localizadorCliente);
        System.out.println("El precio total del paquete con todos los descuentos es: " + total);
        localizadorCliente.setPrecio(total);
        LocalizadorRepository.agregarLocalizador(localizadorCliente);

    }
}
