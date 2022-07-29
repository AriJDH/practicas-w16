package agencia_turismo;

import agencia_turismo.repositorios.LocalizadorRepo;

import java.util.stream.Collectors;

public abstract class Reserva {

    protected Double precio;

    public Reserva(Double precio) {
        this.precio = precio;
    }

    public static void diccionarioReservaPorTipo(String tipoReserva){

        LocalizadorRepo.getAll().stream()
                .map(localizador -> localizador.getReservas())
                .forEach(reservas -> reservas.stream().filter(reserva -> reserva.getClass().getSimpleName().equals(tipoReserva)).collect(Collectors.toList())
                        .forEach(reserva -> System.out.println(reserva)));
    }

}
