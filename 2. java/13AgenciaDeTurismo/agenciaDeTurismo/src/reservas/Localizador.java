package reservas;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    List<TipoDeReservas> reservasCliente;
    private double totalReserva;

    public Localizador() {
    }

    public Localizador(Cliente cliente, List<TipoDeReservas> reservasCliente, double totalReserva) {
        this.cliente = cliente;
        this.reservasCliente = reservasCliente;
        this.totalReserva = totalReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<TipoDeReservas> getReservasCliente() {
        return reservasCliente;
    }

    public void setReservasCliente(List<TipoDeReservas> reservasCliente) {
        this.reservasCliente = reservasCliente;
    }

    public double getTotalReserva() {
        return totalReserva;
    }

    public void setTotalReserva(double totalReserva) {
        this.totalReserva = totalReserva;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", reservasCliente=" + reservasCliente +
                ", totalReserva=" + totalReserva +
                '}';
    }

    public void localizadorDos(){
        System.out.println("\nDescuento de 5% en futuras compras");
    }

    public double paqueteCompleto(){
        System.out.println("\nDescuento de 10% en el total de la factura");
        return this.totalReserva - (this.totalReserva * 0.10);
    }

    public double reservasDosiguales(){
        System.out.println("\nDescuento de 5% en las reservas realizadas");
        return this.totalReserva - (this.totalReserva * 0.05);
    }
}
