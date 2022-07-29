package ejercicioIntegradorEnVivo.descuento;

import ejercicioIntegradorEnVivo.cliente.Cliente;
import ejercicioIntegradorEnVivo.localizador.Localizador;
import ejercicioIntegradorEnVivo.PaqueteTuristico;

import java.util.List;

public abstract class Descuento {
    public static Descuento aplicableA(Cliente unCliente, PaqueteTuristico unPaqueteTuristico, List<Localizador> unosLocalizadoresPrevios) {
        var subclasses = List.of(new DescuentoClienteAntiguo(), new DescuentoHotelYViajes(), new DescuentoPaqueteCompleto());
        return subclasses.stream().filter(descuento -> descuento.puedeHacerseCargoDe(unCliente, unPaqueteTuristico, unosLocalizadoresPrevios)).findFirst().get();
    }

    public abstract Boolean puedeHacerseCargoDe(Cliente unCliente, PaqueteTuristico unPaqueteTuristico, List<Localizador> unosLocalizadores);

    public abstract Double aplicadoA(PaqueteTuristico unPaqueteTuristico);
}

