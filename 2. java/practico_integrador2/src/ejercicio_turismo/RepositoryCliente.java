package ejercicio_turismo;

import java.util.ArrayList;
import java.util.List;

public class RepositoryCliente {


    private List<Reserva> reservas = new ArrayList<>();


    public boolean checkCompletePackage(Cliente cliente) {

        boolean reservaHotel = false;
        boolean reservaBoletoTransporte = false;
        boolean reservaComida = false;
        boolean reservaTransporte = false;

        for (Reserva reserva : reservas) {

            if (cliente.equals(reserva.getCliente())) {
                if (reserva instanceof ReservaBoletoTransporte)
                    reservaBoletoTransporte = true;
                if (reserva instanceof ReservaComida)
                    reservaComida = true;
                if (reserva instanceof ReservaTransporte)
                    reservaTransporte = true;
                if (reserva instanceof ReservaHotel)
                    reservaHotel = true;


            }
        }
        if (reservaComida && reservaTransporte && reservaHotel && reservaBoletoTransporte)
            return true;
        return false;
    }


    public boolean checkClientLocalizadorQuantity(Cliente cli) {
        int contador = (int) reservas.stream().filter(reserva -> reserva.getCliente().getDni().equals(cli.getDni())).count();
        return contador > 2;

    }


    public boolean checkReservs(Cliente cli) {


        int cantReservas = (int) reservas.stream().filter(reserva -> reserva.getCliente().getDni().equals(cli.getDni())).filter(reserva -> reserva instanceof ReservaHotel || reserva instanceof ReservaBoletoTransporte).count();
        return cantReservas > 2;

    }


    public RepositoryCliente(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
