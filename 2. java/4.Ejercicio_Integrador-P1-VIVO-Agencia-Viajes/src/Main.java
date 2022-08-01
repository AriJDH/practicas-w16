import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Localizador> listaDeLocalizadores = new ArrayList<>();
        List<Reserva> listaReserva1 = new ArrayList<>();
        List<Reserva> listaReserva2 = new ArrayList<>();
        List<Reserva> listaReserva3 = new ArrayList<>();


        Cliente cliente1 = new Cliente("Jota", "Cavallo", "345 609 5567", "107383", "pslekq@gmail.com");

        Comida menuSencillo = new Comida("Tres comidas tipo buffet", 250);
        Hotel reservaHotel = new Hotel("Marriot", 700);
        BoletosViajes pasajesAvion = new BoletosViajes("Vuelos ida y vuelta", 400);
        Transporte transporteInterno = new Transporte("Traslado de aeropuerto a hotel", 150);

        //punto 1

        Reserva reservaDeCliente1 = new Reserva(menuSencillo, reservaHotel, pasajesAvion, transporteInterno);
        reservaDeCliente1.costoTotalReservaCalculadora();
        listaReserva1.add(reservaDeCliente1);

        Agencia_Turismo agencia = new Agencia_Turismo(listaDeLocalizadores);

        //COSTO TOTAL RESERVA
        Localizador localizador1 = new Localizador(cliente1, listaReserva1, agencia);
        localizador1.costoTotalReservaCalculadora();

        listaDeLocalizadores.add(localizador1);
        System.out.println("**** LOCALIZADOR 01: \n" + localizador1);

        //punto 2
        Reserva reserva2DeCliente1 = new Reserva(reservaHotel, pasajesAvion);
        reserva2DeCliente1.costoTotalReservaCalculadora();

        Reserva reserva3DeCliente1 = new Reserva(reservaHotel, pasajesAvion);
        reserva3DeCliente1.costoTotalReservaCalculadora();

        listaReserva2.add(reserva2DeCliente1);
        listaReserva2.add(reserva3DeCliente1);

        Localizador localizador2 = new Localizador(cliente1, listaReserva2, agencia);
        localizador2.costoTotalReservaCalculadora();
        listaDeLocalizadores.add(localizador2);
        System.out.println("**** LOCALIZADOR 02: \n" + localizador2);

        //punto3
        Reserva reserva4DeCliente1 = new Reserva(reservaHotel);
        reserva4DeCliente1.costoTotalReservaCalculadora();
        listaReserva3.add(reserva4DeCliente1);

        Localizador localizador3 = new Localizador(cliente1, listaReserva3, agencia);
        localizador3.costoTotalReservaCalculadora();
        listaDeLocalizadores.add(localizador3);
        System.out.println("**** LOCALIZADOR 03: \n" + localizador3);


    }
}
