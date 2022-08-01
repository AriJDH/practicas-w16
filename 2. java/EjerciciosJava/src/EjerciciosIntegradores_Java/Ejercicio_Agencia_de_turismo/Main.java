package EjerciciosIntegradores_Java.Ejercicio_Agencia_de_turismo;

import EjerciciosIntegradores_Java.Ejercicio_Agencia_de_turismo.Reservas.Hotel;
import EjerciciosIntegradores_Java.Ejercicio_Agencia_de_turismo.Reservas.Reserva;
import EjerciciosIntegradores_Java.Ejercicio_Agencia_de_turismo.Reservas.Viajes;
import EjerciciosIntegradores_Java.Ejercicio_Agencia_de_turismo.Reservas.Transporte;
import EjerciciosIntegradores_Java.Ejercicio_Agencia_de_turismo.Reservas.Comida;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Localizador> localizadores = new ArrayList<>();

        Cliente cli = new Cliente(1,"Pedro Picapiedra");
        Cliente cli1 = new Cliente(2,"Jessica Rodriguez");
        Cliente cli2 = new Cliente(3,"Luis Perez");
        Cliente cli3 = new Cliente(4,"Lucas Fernandez");

        List<Cliente> clientes = new ArrayList<>(List.of(cli,cli1,cli2,cli3));
        Clientes listaClientes = new Clientes(clientes);

        //Primer localizador - Caso 1
        Reserva res1 = new Hotel(500.0);
        Reserva res2 = new Comida(300.0);
        Reserva res3 = new Transporte(100.0);
        Reserva res4 = new Viajes(50.0);
        List<Reserva> reservas1 = new ArrayList<>(List.of(res1,res2,res3,res4));
        Localizador loc1 = new Localizador(cli1,reservas1);
        localizadores.add(loc1);
        //

        System.out.println(localizadores.get(0));
        System.out.println(loc1.calcularPrecio(localizadores));

        //Segundo Localizador - Caso 3
        Reserva res5 = new Hotel(300.0);
        Reserva res6 = new Hotel(300.0);
        Reserva res7 = new Viajes(100.0);
        Reserva res8 = new Viajes(100.0);
        List<Reserva> reservas2 = new ArrayList<>(List.of(res5,res6,res7,res8));
        Localizador loc2 = new Localizador(cli1,reservas2);
        localizadores.add(loc2);

        System.out.println(localizadores.get(1));
        System.out.println(loc2.calcularPrecio(localizadores));

        //
        //Tercer localizador - Caso 1
        Reserva res9 = new Hotel(1000.0);
        List<Reserva> reservas3 = new ArrayList<>(List.of(res9));
        Localizador loc3 = new Localizador(cli1,reservas3);
        localizadores.add(loc3);

        System.out.println(localizadores.get(2));
        System.out.println(loc3.calcularPrecio(localizadores));
        //

        // Parte 2
        ConsultasLocalizadores consultasLocalizadores = new ConsultasLocalizadores(localizadores);
        System.out.println("----------------------");
        System.out.println("Cantidad de localizadores vendidos: " + consultasLocalizadores.cantidadLocVendidos());
        System.out.println("----------------------");
        System.out.println("Cantidad total de reservas: " + consultasLocalizadores.cantidadReservas());
        System.out.println("----------------------");
        System.out.println("Diccionario de todas las reservas clasificadas por tipo: ");
        consultasLocalizadores.reservasxTipo();
        System.out.println("----------------------");
        System.out.println("Total de ventas: " + consultasLocalizadores.totalVentas());
        System.out.println("----------------------");
        System.out.println("Promedio total de ventas: " + consultasLocalizadores.promedio());

    }
}
