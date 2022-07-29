package ejercicioIntegradorEnVivo.descuento;

import ejercicioIntegradorEnVivo.cliente.Cliente;
import ejercicioIntegradorEnVivo.localizador.Localizador;
import ejercicioIntegradorEnVivo.PaqueteTuristico;

import java.util.List;

public class DescuentoPaqueteCompleto extends Descuento {

    public Boolean puedeHacerseCargoDe(Cliente unCliente, PaqueteTuristico unPaqueteTuristico, List<Localizador> unosLocalizadores) {
        return unPaqueteTuristico.esPaqueteCompleto();
    }

    @Override
    public Double aplicadoA(PaqueteTuristico unPaqueteTuristico) {
        return unPaqueteTuristico.precioTotal() - unPaqueteTuristico.precioTotal() * 0.10;
    }

}
