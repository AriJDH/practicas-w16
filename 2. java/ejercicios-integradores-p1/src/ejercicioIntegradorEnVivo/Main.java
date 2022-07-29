package ejercicioIntegradorEnVivo;

import ejercicioIntegradorEnVivo.cliente.Cliente;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        AgenciaDeTurismo agenciaDeTurismo = new AgenciaDeTurismo();

        Cliente cliente = new Cliente(1234, "Juan Perez");

        PaqueteTuristico paqueteCompleto = new PaqueteTuristico(
                List.of(Reserva.HOTEL, Reserva.COMIDA, Reserva.TRANSPORTE, Reserva.BOLETO_DE_VIAJES)
        );

        agenciaDeTurismo.registrarCliente(cliente);

        // Se aplica descuento del 10% porque es paquete completo
        agenciaDeTurismo.registrarCompraDe(cliente, paqueteCompleto);

        PaqueteTuristico otroPaquete = new PaqueteTuristico(
                List.of(Reserva.HOTEL, Reserva.HOTEL, Reserva.BOLETO_DE_VIAJES, Reserva.BOLETO_DE_VIAJES)
        );

        // Se aplica descuento del 5% por reserva por que hay 2 hoteles y 2 boletos de viajes.
        agenciaDeTurismo.registrarCompraDe(cliente, otroPaquete);

        // Se aplica descuento del 5% porque comprò dos localizadores
        agenciaDeTurismo.registrarCompraDe(cliente, new PaqueteTuristico(List.of(Reserva.HOTEL)));
    }

}
