package main;

import modelo.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Repositorio repo = new Repositorio();
        RepositorioCliente repoCliente = new RepositorioCliente();

        List<Reserva> reservas = new ArrayList<>();
        reservas.add(new Hotel(3, 100, "The good hotel", "doble"));
        reservas.add(new Hotel(2, 50, "The bad hotel", "simple"));
        reservas.add(new BoletoViaje("Bogotá", "Medellín", 1, 45));
        reservas.add(new Comida("comida en hotel", 20, 5));
        reservas.add(new Transporte(5, "carro", 20));

        Cliente cliente = new Cliente("145864DA56A", "John", "Doe", "123456789");

        Localizador loc = repo.agregarLocalizadorCliente(cliente, reservas, repoCliente);
        System.out.println("precio total: " + reservas.stream().mapToDouble(Reserva::darPrecio).sum());
        System.out.println("precio final: " + loc.getTotal());

        reservas = new ArrayList<>();
        reservas.add(new Hotel(3, 100, "The good hotel", "doble"));
        reservas.add(new Hotel(2, 50, "The bad hotel", "simple"));
        reservas.add(new BoletoViaje("Bogotá", "Medellín", 1, 45));
        reservas.add(new BoletoViaje("Medellín", "Bucaramanga", 1, 50));

        loc = repo.agregarLocalizadorCliente(cliente, reservas, repoCliente);
        System.out.println("precio total: " + reservas.stream().mapToDouble(Reserva::darPrecio).sum());
        System.out.println("precio final: " + loc.getTotal());

        reservas = new ArrayList<>();
        reservas.add(new Hotel(3, 100, "The good hotel", "doble"));

        loc = repo.agregarLocalizadorCliente(cliente, reservas, repoCliente);
        System.out.println("precio total: " + reservas.stream().mapToDouble(Reserva::darPrecio).sum());
        System.out.println("precio final: " + loc.getTotal());
    }
}
