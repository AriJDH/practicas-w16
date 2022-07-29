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
        List<Compra> listaPaquete= new ArrayList<Compra>();

        listaPaquete.add(boletoViaje);
        listaPaquete.add(boletoTransporte);
        listaPaquete.add(comida);
        listaPaquete.add(reservaHotel);

        repositorioCliente.crearViajero(viajero);

        repositorio.CrearLocalizador(LocalDate.now(),listaPaquete,viajero);



        ReservaHotel hotel1 = new ReservaHotel(1200, "X");
        ReservaHotel hotel2 = new ReservaHotel(800, "Y");
        Boleto boleto1 = new Boleto(500,"Viaje");
        Boleto boleto2 = new Boleto(500,"Viaje");

        List<Compra> lista2Reservas = new ArrayList<Compra>();
        lista2Reservas.add(hotel1);
        lista2Reservas.add(hotel2);
        lista2Reservas.add(boleto1);
        lista2Reservas.add(boleto2);

        repositorio.CrearLocalizador(LocalDate.now(),lista2Reservas,viajero);

        ReservaHotel hotel3 = new ReservaHotel(1200, "X");
        List<Compra> lista3Reservas = new ArrayList<Compra>();
        lista3Reservas.add(hotel3);
        repositorio.CrearLocalizador(LocalDate.now(),lista3Reservas,viajero);


        repositorio.getListaCompras().forEach(localizador -> System.out.println(localizador));

        ControlRepositorio controlRepo = new ControlRepositorio();

        System.out.println("cantidad de localizadores vendidos " + controlRepo.cantidadLocalizadoresVendidos(repositorio));
        System.out.println("cantidad total de reservas " + controlRepo.cantidadTotalReservas(repositorio));
        controlRepo.obtenerDiccionario(repositorio);
        System.out.println("cantidad total de ventas " + controlRepo.totalVentas(repositorio));
        System.out.println("promedio de ventas " + controlRepo.promedioTotalVentas(repositorio));

    }
}
