package Entity;

import Repository.RepositorioCliente;
import Repository.RepositorioLocalizador;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RepositorioCliente repositorioCliente = new RepositorioCliente();
        RepositorioLocalizador repositorioLocalizador = new RepositorioLocalizador();
        Cliente c = new Cliente("Cliente1","Apellido1","123456");
        repositorioCliente.addClientes(c);
        List<Reserva> aux = new ArrayList<>();

        //PAQUETE COMPLETO APLICA DESCUENTO 10%

        Comida reserva_comida = new Comida(100.0);
        Hotel reserva_hotel = new Hotel(100.0);
        Transporte reserva_transporte = new Transporte(100.0);
        Viajes reserva_viaje = new Viajes(100.0);
        aux.add(reserva_comida);
        aux.add(reserva_hotel);
        aux.add(reserva_transporte);
        aux.add(reserva_viaje);
        Localizador loc = new Localizador(aux);
        double costoTotal = repositorioLocalizador.historialCliente(c.getDni())*loc.costoReserva();
        System.out.println("Costo Total es: " + costoTotal);
        repositorioLocalizador.addLocalizador(c.getDni(),loc);

        //APLICA DESCUENTO 2 RESERVAS DE HOTEL 5%

        List<Reserva> aux3 = new ArrayList<>();
        Hotel reserva_hotel3 = new Hotel(300.0);
        Hotel reserva_hotel4 = new Hotel(300.0);
        aux3.add(reserva_hotel3);
        aux3.add(reserva_hotel4);
        Localizador loc3 = new Localizador(aux3);
        double costoTotal3 = repositorioLocalizador.historialCliente(c.getDni())*loc3.costoReserva();
        System.out.println("Costo Total es: " + costoTotal3);
        repositorioLocalizador.addLocalizador(c.getDni(),loc3);

        //APLICA DESCUENTO DE HISTORIAL <= 2

        List<Reserva> aux2 = new ArrayList<>();
        Comida reserva_comida2 = new Comida(100.0);
        Viajes reserva_viaje2 = new Viajes(100.0);
        aux2.add(reserva_comida2);
        aux2.add(reserva_viaje2);
        Localizador loc2 = new Localizador(aux2);
        double costoTotal2 = repositorioLocalizador.historialCliente(c.getDni())*loc2.costoReserva();
        System.out.println("Costo Total es: " + costoTotal2);
        repositorioLocalizador.addLocalizador(c.getDni(),loc3);


    }





}
