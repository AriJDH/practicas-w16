package ejercicioIntegradorEnVivo.descuento;

import ejercicioIntegradorEnVivo.cliente.Cliente;
import ejercicioIntegradorEnVivo.localizador.Localizador;
import ejercicioIntegradorEnVivo.PaqueteTuristico;
import ejercicioIntegradorEnVivo.Reserva;

import java.util.List;
import java.util.stream.Collectors;

public class DescuentoHotelYViajes extends Descuento {

    public Boolean puedeHacerseCargoDe(Cliente unCliente, PaqueteTuristico unPaqueteTuristico, List<Localizador> unosLocalizadores) {

        return unPaqueteTuristico.tieneReservasDeTipo(Reserva.HOTEL, 2) || unPaqueteTuristico.tieneReservasDeTipo(Reserva.BOLETO_DE_VIAJES, 2);
    }

    @Override
    public Double aplicadoA(PaqueteTuristico unPaqueteTuristico) {
        List<Reserva> hotelesYViajes =
                unPaqueteTuristico
                        .getReservas()
                        .stream()
                        .filter(reserva -> reserva.equals(Reserva.HOTEL) || reserva.equals(Reserva.BOLETO_DE_VIAJES))
                        .collect(Collectors.toList());

        Double precioADescontar = hotelesYViajes.stream().mapToDouble(Reserva::getPrice).sum() * 5/100;

        return unPaqueteTuristico.precioTotal() - precioADescontar;
    }

}
