package agenciaDeTurismo.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Localizador {

    private List<Reserva> reservas = new ArrayList<>();
    private Cliente cliente;
    private double total;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void agregarReserva(Reserva reserva) {
      reservas.add(reserva);
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

    public double getSubtotal(){

        return reservas.stream().mapToDouble(Reserva::getCosto).sum();
    }

    private boolean aplicarDescuentoHoteles(){
        List<Reserva> hoteles;
        hoteles = reservas
                .stream()
                .filter(reserva -> reserva instanceof Reserva)
        .collect(Collectors.toList());

        return hoteles.size()>2;
    }
}
