package integrador.agencia_turismo;


import integrador.agencia_turismo.models.*;
import integrador.agencia_turismo.repositorios.LocalizadorRepo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    LocalizadorRepo localizadorRepo;

    public Main() {
        this.localizadorRepo = LocalizadorRepo.getInstance();
    }

    public Double calcularTotal(Localizador localizador) {

        Double precio = localizador.calcularTotal();
        Double descuentoTotal = 0d;

        List<Localizador> listaLocalizadoresCliente = this.localizadorRepo.getLocalizadoresByCliente(localizador.getCliente().getDni());


        Map<String, Long> reservas = localizador.getReservas().stream()
                .collect(Collectors.groupingBy(reserva -> reserva.getClass().getSimpleName(), Collectors.counting()));

        if (listaLocalizadoresCliente.size() >= 2) descuentoTotal += 0.05;
        if (poseeTodasLasReservas(reservas)) descuentoTotal += 0.10;
        if (poseeDosReservaHotelODosBoletosViaje(reservas)) descuentoTotal += 0.05;

        return precio * (1 - descuentoTotal);
    }

    public boolean poseeTodasLasReservas(Map<String, Long> reservas) {
        return reservas.keySet().size() == 4;
    }

    public boolean poseeDosReservaHotelODosBoletosViaje(Map<String, Long> reservas) {
        boolean hayDosBoletosViaje = false;
        boolean hayReservasHoteles = false;
        if (reservas.containsKey("BoletoViaje")) hayDosBoletosViaje = reservas.get("BoletoViaje") >= 2;
        if (reservas.containsKey("Hotel")) hayReservasHoteles = reservas.get("Hotel") >= 2;
        return hayDosBoletosViaje || hayReservasHoteles;
    }

    public static void main(String[] args) {
        Main main = new Main();
        LocalizadorRepo localizadorRepo = LocalizadorRepo.getInstance();

        Cliente cliente1 = new Cliente("123456", "Gabriela", "Mejia");
        Cliente cliente2 = new Cliente("09876", "Pepito", "Perez");
        Cliente cliente3 = new Cliente("35865", "Juan", "Perez");

        List<Reserva> reservas = List.of(new BoletoViaje(2000.0), new Comida(1300.0), new Hotel(5000.0), new Transporte(7000.0));
        Localizador localizadorCliente1 = new Localizador(cliente1, reservas);
        localizadorRepo.agregarLocalizador(localizadorCliente1);

        System.out.println("PARTE 1");
        System.out.println("El precio total del paquete con todos los descuentos es: " + main.calcularTotal(localizadorCliente1));

        List<Reserva> reservasCliente2 = List.of(new Comida(1300.0), new Hotel(5000.0), new Transporte(7000.0));
        Localizador localizadorCliente2 = new Localizador(cliente2, reservasCliente2);
        localizadorRepo.agregarLocalizador(localizadorCliente2);

        System.out.println("El precio total del paquete sin descuentos es: " + main.calcularTotal(localizadorCliente2));

        List<Reserva> reservasCliente3 = List.of(new BoletoViaje(1300.0), new BoletoViaje(5000.0), new Hotel(7000.0), new Hotel(5000.0));
        Localizador localizadorCliente3 = new Localizador(cliente3, reservasCliente3);
        localizadorRepo.agregarLocalizador(localizadorCliente3);
        System.out.println("El precio total con dos boletos y dos hoteles: " + main.calcularTotal(localizadorCliente3));

        List<Reserva> reservascliente1_2 = List.of(new BoletoViaje(2000.0), new Comida(1300.0), new Hotel(5000.0), new Transporte(7000.0));
        Localizador localizadorCliente1_2 = new Localizador(cliente1, reservascliente1_2);
        localizadorRepo.agregarLocalizador(localizadorCliente1_2);

        List<Reserva> reservascliente1_3 = List.of(new BoletoViaje(2000.0), new Comida(1300.0), new Hotel(5000.0), new Transporte(7000.0));
        Localizador localizadorCliente1_3 = new Localizador(cliente1, reservascliente1_3);
        System.out.println("El precio total con 3 localizadores: " + main.calcularTotal(localizadorCliente1_3));
        localizadorRepo.agregarLocalizador(localizadorCliente1_3);

        System.out.println("PARTE 2");
        System.out.println("Cantidad de localizadores: " + localizadorRepo.getAll().size());

        System.out.println("Cantidad total de reservas: " + localizadorRepo.getAll().stream()
                .mapToInt(localizador -> localizador.getReservas().size())
                .sum()
        );

        System.out.println("Reservas clasificadas por tipo: " + localizadorRepo.getAll().stream()
                .map(localizador -> localizador.getReservas())
                .flatMap(r -> r.stream())
                .collect(Collectors.groupingBy(reserva -> reserva.getClass().getSimpleName(), Collectors.counting())));


        System.out.println("Total de ventas: $" + localizadorRepo.getAll().stream()
                .mapToDouble(Localizador::calcularTotal)
                .sum()
        );


        System.out.println("Promedio de ventas: $" + localizadorRepo.getAll().stream()
                .mapToDouble(Localizador::calcularTotal)
                .average()
                .getAsDouble()
        );

    }

}
