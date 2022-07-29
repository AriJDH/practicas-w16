package ejercicioIntegradorEnVivo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PaqueteTuristico {

    private List<Reserva> reservas;

    public PaqueteTuristico(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public boolean esPaqueteCompleto() {
        return reservas.containsAll(Arrays.asList(Reserva.values()));
    }

    public Double precioTotal() {
        return reservas.stream().mapToDouble(Reserva::getPrice).sum();
    }

    public boolean tieneReservasDeTipo(Reserva unTipoDeReserva, int unaCantidadDeReservas) {
        return reservas.stream().filter(reserva -> reserva.equals(unTipoDeReserva)).count() >= unaCantidadDeReservas;
    }
}
