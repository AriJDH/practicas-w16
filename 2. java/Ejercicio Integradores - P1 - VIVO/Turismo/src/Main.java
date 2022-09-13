import clientes.Cliente;
import clientes.Clientes;
import localizadores.Localizador;
import localizadores.Localizadores;
import reservas.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static Localizadores localizadores = new Localizadores();
    public static Clientes clientes = new Clientes();

    public static void main(String[] args) {

        Cliente cli = new Cliente(1,"Pedro Picapiedra");
        Cliente cli1 = new Cliente(2,"Jessica Rodriguez");
        Cliente cli2 = new Cliente(3,"Luis Perez");
        Cliente cli3 = new Cliente(4,"Lucas Fernandez");

        clientes.addCliente(cli);
        clientes.addCliente(cli1);
        clientes.addCliente(cli2);
        clientes.addCliente(cli3);

        //PARTE 1

        //Primer Localizador - Caso 2
        Reserva res = new Hotel(500.0);
        Reserva res1 = new Comida(300.0);
        Reserva res2 = new Transporte(100.0);
        Reserva res3 = new Viaje(50.0);
        ArrayList<Reserva> reservas = new ArrayList<>(List.of(res,res1,res2,res3));
        Localizador loc = new Localizador(cli1, reservas);
        localizadores.addLocalizador(loc);


        //
        //Segundo localizador - Caso 3
        Reserva res4 = new Hotel(800.0);
        Reserva res5 = new Hotel(800.0);
        Reserva res6 = new Viaje(100.0);
        Reserva res7 = new Viaje(100.0);
        ArrayList<Reserva> reservas2 = new ArrayList<>(List.of(res4,res5,res6,res7));
        Localizador loc1 = new Localizador(cli1,reservas2);
        localizadores.addLocalizador(loc1);

        //
        //Segundo localizador - Caso 1
        Reserva res8 = new Hotel(500.0);
        Reserva res9 = new Comida(300.0);
        Reserva res10 = new Transporte(100.0);
        Reserva res11 = new Viaje(50.0);
        ArrayList<Reserva> reservas3 = new ArrayList<>(List.of(res8,res9,res10,res11));
        Localizador loc2 = new Localizador(cli1,reservas3);
        localizadores.addLocalizador(loc2);

        //PARTE 2

        System.out.println("Cantidad de localizadores vendidos: " + cantidadDeLocalizadoresVendidos());
        System.out.println("Cantidad total de reservas: " + cantidadTotalDeReservas());
        reservasClasificadasPorTipo();
        System.out.println("El total vendido es de: " + totalDeVenta());
        System.out.println("Promedio total de ventas: " + promedioTotalDeVentas());

    }

    private static int cantidadDeLocalizadoresVendidos(){
        return localizadores.getListaLocalizador().size();
    }

    private static double cantidadTotalDeReservas(){
        return localizadores.getListaLocalizador().stream()
                .map(localizador -> localizador.getListaReservas().size())
                .mapToDouble(Integer::doubleValue).sum();
    }

    private static void reservasClasificadasPorTipo(){
        List<Reserva> reservas = new ArrayList<>();

        localizadores.getListaLocalizador().stream()
                .forEach(localizador -> localizador.getListaReservas().stream()
                        .forEach(reserva -> reservas.add(reserva)));

        Map<String, Long> reservasMap = reservas.stream()
                .collect(Collectors.groupingBy(reserva -> reserva.getClass().getName(), Collectors.counting()));

        System.out.println(reservasMap);
    }

    private static double totalDeVenta(){
        return localizadores.getListaLocalizador().stream()
                .map(localizador -> localizador.getTotal())
                .mapToDouble(Double::doubleValue).sum();
    }

    private static double promedioTotalDeVentas(){
        return totalDeVenta()/cantidadDeLocalizadoresVendidos();
    }


}
