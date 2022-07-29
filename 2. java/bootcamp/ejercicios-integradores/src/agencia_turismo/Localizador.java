package agencia_turismo;

import java.util.List;

public class Localizador {

    private Cliente cliente;
    private List<Reserva> reservas;

    private double precio;

    public Localizador(){
        this.cliente = new Cliente();
        this.reservas = List.of();
    }

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
