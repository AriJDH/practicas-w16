package agenciaDeTurismo.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
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

    public double getSubtotal() {

        Predicate<Reserva> condicionHoteles = (reserva -> reserva instanceof Hotel);
        aplicarDescuento(condicionHoteles);
        Predicate<Reserva> condicionBoletos = (reserva -> reserva instanceof BoletosDeViaje);
        aplicarDescuento(condicionBoletos);

        double costo = reservas.stream().mapToDouble(Reserva::getPrecio).sum();

        return esPaqueteCompleto() ? costo * 0.9 : costo;
    }


    private void aplicarDescuento(Predicate<Reserva> condicion) {
        List<Reserva> hoteles;
        hoteles = reservas
                .stream()
                .filter(condicion::test)
                .collect(Collectors.toList());

        if (hoteles.size() == 2) {
            reservas.forEach(reserva -> {
                if (condicion.test(reserva)) {
                    double nuevoCosto = reserva.getPrecio() * 0.95;
                    reserva.setPrecio(nuevoCosto);
                }
            });
        }
    }

    public boolean esPaqueteCompleto() {
        return
                reservas.stream().anyMatch(e -> e instanceof Hotel) &&
                        reservas.stream().anyMatch(e -> e instanceof Comida) &&
                        reservas.stream().anyMatch(e -> e instanceof BoletosDeViaje) &&
                        reservas.stream().anyMatch(e -> e instanceof BoletosDeTransporte);

    }
}
