package com.tomas.agencia;

import com.tomas.agencia.models.Cliente;
import com.tomas.agencia.models.Localizadores;
import com.tomas.agencia.models.Producto;
import com.tomas.agencia.repository.ClienteRepository;
import com.tomas.agencia.repository.ProductoRepository;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("-----------Creación de productos------------");

        //Creando los productos
        Producto reservaDeHotel = new Producto(0L, "Reserva de hotel",20000);
        Producto comida = new Producto(1L, "Comida",1000);
        Producto boletosDeViaje = new Producto(2L, "Boletos de viaje",30000);
        Producto transporte = new Producto(3L, "Transporte",15654);

        ProductoRepository productoRepository = new ProductoRepository();

        //Verificando la creación de los productos
        productoRepository.crearProducto(reservaDeHotel);
        productoRepository.crearProducto(comida);
        productoRepository.crearProducto(boletosDeViaje);
        productoRepository.crearProducto(transporte);



        //Lista con el paquete completo
        List<Producto> paqueteCompleto = new ArrayList<Producto>();

        paqueteCompleto.add(reservaDeHotel);
        paqueteCompleto.add(comida);
        paqueteCompleto.add(boletosDeViaje);
        paqueteCompleto.add(transporte);

        //Lista con 2 boletos de hotel y 2 boletos de viaje
        List<Producto> paqueteHotelBoletos = new ArrayList<Producto>();

        paqueteHotelBoletos.add(reservaDeHotel);
        paqueteHotelBoletos.add(reservaDeHotel);
        paqueteHotelBoletos.add(boletosDeViaje);
        paqueteHotelBoletos.add(boletosDeViaje);

        //Lista con un solo producto
        List<Producto> paqueteProducto = new ArrayList<Producto>();

        paqueteProducto.add(reservaDeHotel);

        //Agregando los localizadores al cliente
        Localizadores localizadorCompleto = new Localizadores(0L,new ArrayList<>());
        localizadorCompleto.setProductos(paqueteCompleto);

        Localizadores localizadorHotelBoletos = new Localizadores(2L,new ArrayList<>());
        localizadorHotelBoletos.setProductos(paqueteHotelBoletos);

        Localizadores localizadorProducto = new Localizadores(3L,new ArrayList<>());
        localizadorProducto.setProductos(paqueteProducto);


        List<Localizadores> localizadores = new ArrayList<Localizadores>();
        localizadores.add(localizadorCompleto);
        localizadores.add(localizadorHotelBoletos);

        System.out.println();
        System.out.println("-----------Cliente con el paquete completo------------");

        ClienteRepository clienteRepositoryUno = new ClienteRepository();
        Cliente clienteUno= new Cliente("109728892", "Camilo", "Rojas", "328389392", new ArrayList<>());
        clienteRepositoryUno.agregarLocalizador(localizadorCompleto, clienteUno);


        System.out.println();
        System.out.println("-----------Cliente con el paquete 2 boletos de viaje y 2 de hotel------------");

        ClienteRepository clienteRepositoryDos = new ClienteRepository();
        Cliente clienteDos= new Cliente("109728892", "Camilo", "Rojas", "328389392", new ArrayList<>());
        clienteRepositoryDos.agregarLocalizador(localizadorHotelBoletos, clienteDos);

        System.out.println();
        System.out.println("-----------Cliente con el paquete de 1 solo producto------------");

        ClienteRepository clienteRepositoryTres = new ClienteRepository();
        Cliente clienteTres= new Cliente("109728892", "Camilo", "Rojas", "328389392", new ArrayList<>());
        clienteRepositoryDos.agregarLocalizador(localizadorProducto, clienteTres);


    }
}
