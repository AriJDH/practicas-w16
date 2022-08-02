package poo.agenciaDeTurismo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Localizador {

    private Cliente cliente;
    private double totalReserva;
    private double totalReservaConDescuento;
    boolean aplica5Desc;
    private List<Reservable> reservas;

    public Localizador(Cliente cliente, boolean aplicaDescuento5Porc) {
        this.cliente = cliente;
        this.totalReserva = 0;
        this.reservas = new ArrayList<>();
        this.aplica5Desc = aplicaDescuento5Porc;

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotalReserva() {
        return totalReserva;
    }

    public void setTotalReserva(double totalReserva) {
        this.totalReserva = totalReserva;
    }

    public List<Reservable> getReservas() {
        return reservas;
    }


    public void agregarReserva(Reservable reserva) {
        this.reservas.add(reserva);
        this.totalReserva += reserva.getPrecio();
        recalcularTotalConDescuento();
    }

    public void recalcularTotalConDescuento() {
        this.totalReservaConDescuento = totalReserva;

        descontar5PorDobleReserva("HOTEL");
        descontar5PorDobleReserva("VIAJE");

        if (aplica5Desc) {
            this.totalReservaConDescuento = totalReservaConDescuento * 0.95;
        }

        if (esPaqueteCompleto()) {
            this.totalReservaConDescuento = totalReservaConDescuento * 0.90;
        }
    }


    private void descontar5PorDobleReserva(String tipoReserva) {
        List<Reservable> cantReservas = this.reservas.stream().filter(res -> res.tipoReserva().equals(tipoReserva)).collect(Collectors.toList());
        if (cantReservas.size() >= 2) {
            double precioTotal = cantReservas.stream().mapToDouble(Reservable::getPrecio).sum();
            double precioDescontado = precioTotal * 0.05;
            this.totalReservaConDescuento -= precioDescontado;
        }
    }

    public boolean esPaqueteCompleto() {
        boolean paqueteCompleto = false;
        int contador = 0;

        if (this.reservas.stream().anyMatch(reserva -> reserva instanceof Hotel)) {
            contador++;
        }
        if (this.reservas.stream().anyMatch(reserva -> reserva instanceof Comida)) {
            contador++;
        }
        if (this.reservas.stream().anyMatch(reserva -> reserva instanceof Traslado)) {
            contador++;
        }
        if (this.reservas.stream().anyMatch(reserva -> reserva instanceof Viaje)) {
            contador++;
        }

        if (contador == 4)
            paqueteCompleto = true;
        return paqueteCompleto;
    }

    @Override
    public String toString() {
        return "\nLocalizador"
                + cliente +
                ", Total Reserva sin descuentos:" + totalReserva +
                ", Total Reserva con descuento:" + totalReservaConDescuento +
                ", " + reservas;
    }
}
