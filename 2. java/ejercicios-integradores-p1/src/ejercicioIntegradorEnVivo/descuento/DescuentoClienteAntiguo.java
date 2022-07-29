package ejercicioIntegradorEnVivo.descuento;

import ejercicioIntegradorEnVivo.cliente.Cliente;
import ejercicioIntegradorEnVivo.localizador.Localizador;
import ejercicioIntegradorEnVivo.PaqueteTuristico;

import java.util.List;

public class DescuentoClienteAntiguo extends Descuento {

    public Boolean puedeHacerseCargoDe(Cliente unCliente, PaqueteTuristico unPaqueteTuristico, List<Localizador> unosLocalizadores) {
        return unosLocalizadores.size() >= 2;
    }

    @Override
    public Double aplicadoA(PaqueteTuristico unPaqueteTuristico) {
        return unPaqueteTuristico.precioTotal() * 95/100;
    }

}
