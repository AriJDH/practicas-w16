package Entity;

import java.util.List;
import java.util.stream.Collectors;

public class Localizador {
    private List<Reserva> reservas;

    public Localizador(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public double costoReserva(){
        double beneficio = 1;
        double costoTotal= reservas.stream()
                .mapToDouble(Reserva::getCosto)
                .sum();

        boolean hotel = reservas.stream()
                .filter(reservas->reservas.getClass()==Hotel.class)
                .collect(Collectors.toList()).size()>=1;

        boolean comida = reservas.stream()
                .filter(reservas->reservas.getClass()==Comida.class)
                .collect(Collectors.toList()).size()>=1;

        boolean transporte = reservas.stream()
                .filter(reservas->reservas.getClass()==Transporte.class)
                .collect(Collectors.toList()).size()>=1;

        boolean viaje = reservas.stream()
                .filter(reservas->reservas.getClass()==Viajes.class)
                .collect(Collectors.toList()).size()>=1;

        boolean viajesDos = reservas.stream()
                .filter(reservas->reservas.getClass()==Viajes.class)
                .collect(Collectors.toList()).size()>=2;

        boolean hotelDos = reservas.stream()
                .filter(reservas->reservas.getClass()==Hotel.class)
                .collect(Collectors.toList()).size()>=2;

        if(hotel && comida &&transporte && viaje )
            beneficio = 0.90;

        if (viajesDos || hotelDos)
            beneficio = 0.95;

        return costoTotal * beneficio;
    }
}
