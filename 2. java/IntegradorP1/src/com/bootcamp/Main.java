package com.bootcamp;

import com.bootcamp.modelos.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Cliente juanito = new Cliente("Juanito", 25, 1234);
    Producto hotel = new Producto(TipoProducto.HOTEL, 1000.0, "Hotel para juanito");
    Producto almuerzo = new Producto(TipoProducto.COMIDA, 300.0, "Almuerzo de juanito");
    Producto boleto = new Producto(TipoProducto.BOLETO, 100.0, "Boleto de juanito");
    Producto transporte = new Producto(TipoProducto.TRANSPORTE,900.0, " Transporte de juanito");
    Producto transporte1 = new Producto(TipoProducto.TRANSPORTE,900.0, " Transporte de juanito");

    List<Producto> paquete = new ArrayList<>(Arrays.asList(hotel,almuerzo,boleto, transporte, transporte1));
//    paquete.add(hotel);
//    paquete.add(almuerzo);
//    paquete.add(boleto);
//    paquete.add(transporte);

    Localizador localizador = new Localizador(juanito, paquete);
    ClienteRepositorio listaClientes = new ClienteRepositorio();
    LocalizadorRepositorio listaLocalizador = new LocalizadorRepositorio();
    listaClientes.guardar(juanito);
    listaLocalizador.guardar(localizador);

    System.out.println("Escenario 1 ===========");
    System.out.println(localizador.getTotalParcial());
    System.out.println(localizador.getTotalDescuento());

  }
}
