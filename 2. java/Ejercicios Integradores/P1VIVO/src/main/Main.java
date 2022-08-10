package main;

import clases.*;
import interfaces.Compra;
import repos.ControlRepositorio;
import repos.Repositorio;
import repos.RepositorioCliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        Repositorio repositorio = new Repositorio();
        RepositorioCliente repositorioCliente = new RepositorioCliente();

        Boleto boletoViaje = new Boleto(100,"Viaje");
        Boleto boletoTransporte = new Boleto(200,"Transporte");
        Comida comida = new Comida(20, "Pasta");
        ReservaHotel reservaHotel = new ReservaHotel(3000, "Conrad");
        Viajero viajero = new Viajero("Pepe", "123");

        repositorioCliente.crearViajero(viajero);
        repositorio.crearLocalizadorConPaquete(boletoTransporte, boletoViaje, comida, reservaHotel, viajero);
        repositorio.getListaCompras().forEach(localizador -> System.out.println(localizador));

        ReservaHotel hotel1 = new ReservaHotel(1200, "X");
        ReservaHotel hotel2 = new ReservaHotel(800, "Y");
        Boleto boleto1 = new Boleto(500,"Viaje");
        Boleto boleto2 = new Boleto(500,"Viaje");

        repositorio.crearLocalizadorReserva(boleto1, boleto2, hotel1, hotel2, viajero);

        repositorio.crearLocalizadorReservaUnica(hotel1, viajero);

        ControlRepositorio controlRepositorio = new ControlRepositorio();
        controlRepositorio.obtenerDiccionario(repositorio);

    }





}
