package practica.ejerciciosintegradores;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Localizador {

    protected ArrayList<PaqueteTuristico> paquetesTuristicos;
    protected Cliente cliente;
    protected double total;

    public Localizador(ArrayList<PaqueteTuristico> paquetesTuristicos, Cliente cliente, double total) {
        this.paquetesTuristicos = paquetesTuristicos;
        this.cliente = cliente;
        this.total = this.calcularTotal(total);
    }

    protected double calcularTotal(double totalInicial) {
        double descuento = 0;
        Repositorio repositorio = Repositorio.getInstance();

        if (repositorio.getTotalLocalizadoresPorCliente(this.getCliente().getDni()) >= 2) {
            descuento += 5;
        }
        if (this.tienePaqueteCompleto()) {
            descuento += 10;
        }
        if (this.tieneDosHotelODosBoletos()) {
            descuento += 5;
        }

        return totalInicial - (totalInicial * (descuento / 100));
    }

    public ArrayList<PaqueteTuristico> getPaquetesTuristicos() {
        return paquetesTuristicos;
    }

    public void setPaquetesTuristicos(ArrayList<PaqueteTuristico> paquetesTuristicos) {
        this.paquetesTuristicos = paquetesTuristicos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean tienePaqueteCompleto() {
        for (PaqueteTuristico paqueteTuristico : this.getPaquetesTuristicos()) {
            if (paqueteTuristico.esPaqueteCompleto()) {
                return true;
            }
        }
        return false;
    }

    public boolean tieneDosHotelODosBoletos() {
        int reservaHotel = 0;
        int reservaBoleto = 0;
        for (PaqueteTuristico paqueteTuristico : this.getPaquetesTuristicos()) {
            if (paqueteTuristico.isReservaHotel()) {
                reservaHotel++;
            }
            if (paqueteTuristico.isBoletosViaje()) {
                reservaBoleto++;
            }
            if (reservaHotel == 2 || reservaBoleto == 2) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "paquetesTuristicos=" + paquetesTuristicos +
                ", cliente=" + cliente +
                ", total=" + total +
                '}';
    }
}
