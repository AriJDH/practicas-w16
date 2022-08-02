package Repositorios;

import Servicios.*;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas = new ArrayList<>();
    private double costoTotal;

    public Localizador(){

    }
    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.costoTotal = calcularTotal();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public double getCostoTotal() { return costoTotal; }

    public void setCostoTotal(double costoTotal) { this.costoTotal = costoTotal; }

    public String mostrarDatos(){
        StringBuilder salida = new StringBuilder();
        for (Reserva reservaciones: this.reservas){
            salida.append(reservaciones.mostrarDatos());
        }
        return "Cliente: " + this.cliente.getNombre() + "\n"
                + salida.toString() + "\n"
                + "Costo Total: " + this.costoTotal;
    }

    public boolean esPaqueteCompleto(List<Reserva> reservas) {
        boolean paqueteCompleto = false;
        if (reservas.size() == 4){
            if (reservas.stream().anyMatch(x -> x instanceof ReservaDeHotel) &&
                    reservas.stream().anyMatch(x -> x instanceof ReservaTransporte) &&
                    reservas.stream().anyMatch(x -> x instanceof ReservaBoletos) &&
                    reservas.stream().anyMatch(x -> x instanceof ReservaComida)){
                paqueteCompleto = true;
            }
        }
        return paqueteCompleto;
    }

    public boolean esDobleHotelViaje(List<Reserva> reservas){
        return reservas.stream().filter(x -> x instanceof ReservaDeHotel).count() == 2 ||
                reservas.stream().filter(x -> x instanceof ReservaBoletos).count() == 2;
    }

    public Double calcularTotal(){
        int total = reservas.stream().mapToInt((reserva) -> {
            return reserva.getCosto();
        }).sum();
        double totalDescuentos = 0.0;
        if (esPaqueteCompleto(this.reservas)) totalDescuentos += 0.1;
        if (esDobleHotelViaje(this.reservas)) totalDescuentos += 0.05;

        return total - (total * totalDescuentos);
    }
}


