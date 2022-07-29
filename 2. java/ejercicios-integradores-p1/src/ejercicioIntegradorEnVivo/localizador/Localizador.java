package ejercicioIntegradorEnVivo.localizador;

import ejercicioIntegradorEnVivo.PaqueteTuristico;
import ejercicioIntegradorEnVivo.Reserva;
import ejercicioIntegradorEnVivo.cliente.Cliente;
import ejercicioIntegradorEnVivo.descuento.Descuento;

import java.util.List;

public class Localizador {

    private final Cliente cliente;
    private final Double total;
    private List<Reserva> reservas;

    public Localizador(Cliente unCliente, PaqueteTuristico unPaqueteTuristico, Descuento descuento) {
        this.cliente = unCliente;
        this.total = descuento.aplicadoA(unPaqueteTuristico);
        this.reservas = unPaqueteTuristico.getReservas();
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", total=" + total +
                ", reservas=" + reservas +
                '}';
    }
}
