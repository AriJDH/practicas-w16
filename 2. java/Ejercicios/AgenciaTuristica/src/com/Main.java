package com;

import com.clases.*;
import com.repositorio.RepositorioLocalizador;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
// caso 1:
        Cliente cliente = new Cliente("78787878", "Pepe");
        List<Comida> comidas = new ArrayList<>();
        comidas.add(new Comida(20, "papasFritas"));
        List<ReservaHotel> reservasHotel = new ArrayList<>();
        reservasHotel.add(new ReservaHotel(10, "Hotel Miami"));
        List<Transporte> transportes = new ArrayList<>();
        transportes.add(new Transporte(15, "Transportes pepe"));
        List<BoletoViaje> boletos = new ArrayList<>();
        boletos.add(new BoletoViaje(20, "Miami"));
        Localizador localizador = new Localizador(cliente);
        localizador.setBoletosViaje(boletos);
        localizador.setComidas(comidas);
        localizador.setTransportes(transportes);
        localizador.setReservasHotel(reservasHotel);
        System.out.println(localizador.calcularMonto());
        List<Localizador> listaLocalizadores = new ArrayList<>();
        listaLocalizadores.add(localizador);
        RepositorioLocalizador repo = new RepositorioLocalizador();
        repo.setLocalizadores(listaLocalizadores);

    localizador.toString();






    }
}

