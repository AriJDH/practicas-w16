package practicesIntegrator1Live;

import practicesIntegrator1Live.Repositories.ClienteRepositorio;
import practicesIntegrator1Live.Repositories.LocalizadorRepositorio;
import practicesIntegrator1Live.models.Cliente;
import practicesIntegrator1Live.models.Localizador;
import practicesIntegrator1Live.models.Producto;
import practicesIntegrator1Live.models.TipoProducto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    // Crear cliente
    Cliente juanito = new Cliente("Juanito", 25, 1234);

    // Crear productos
    Producto hotel = new Producto(TipoProducto.HOTEL, 1000.0, "Hotel para juanito");
    Producto almuerzo = new Producto(TipoProducto.COMIDA, 300.0, "Almuerzo de juanito");
    Producto boleto = new Producto(TipoProducto.BOLETO, 100.0, "Boleto de juanito");
    Producto transporte = new Producto(TipoProducto.TRANSPORTE,900.0, " Transporte de juanito");
    Producto transporte1 = new Producto(TipoProducto.TRANSPORTE,900.0, " Transporte de juanito");

    Producto hotel2 = new Producto(TipoProducto.HOTEL, 2000.0, "Hotel para juanito");
    Producto boleto2 = new Producto(TipoProducto.BOLETO, 300.0, "Boleto de juanito");

    // Añadir los paquetes a la lista del paquete
    List<Producto> paquete = new ArrayList<>(Arrays.asList(hotel,almuerzo,boleto, transporte, transporte1));
    List<Producto> paquete2 = new ArrayList<>(Arrays.asList(hotel2, boleto2));


    // Crear un localizador
    Localizador localizador = new Localizador(juanito, paquete);
    Localizador localizador2 = new Localizador(juanito, paquete2);

    // Crear repositorio de clientes
    ClienteRepositorio listaClientes = new ClienteRepositorio();

    // Crear repositorio de localizador
    LocalizadorRepositorio listaLocalizador = new LocalizadorRepositorio();

    // Guardar un cliente
    listaClientes.guardar(juanito);

    // Guardar un localizador
    listaLocalizador.guardar(localizador);
    listaLocalizador.guardar(localizador2);

    System.out.println("------------Descuentos 1--------------");
    System.out.println(localizador.getTotalParcial());
    System.out.println(localizador.getTotalDescuento());

    System.out.println("------------Descuentos 2--------------");
    System.out.println(localizador2.getTotalParcial());
    System.out.println(localizador2.getTotalDescuento());

    System.out.println("------------Cantidad de localizadores vendidos--------------");
    System.out.println(listaLocalizador.cantidadLocalizadoresVendidos());

    System.out.println("------------Diccionario de reservas--------------");
    listaLocalizador.diccionarioReservas();

    System.out.println("------------total localizadores vendidos--------------");
    System.out.println(listaLocalizador.totalVentas());

    System.out.println("------------promedio localizadores vendidos--------------");
    System.out.println(listaLocalizador.promedioVentas());
  }
}
