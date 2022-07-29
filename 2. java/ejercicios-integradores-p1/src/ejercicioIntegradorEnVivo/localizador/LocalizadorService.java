package ejercicioIntegradorEnVivo.localizador;

import ejercicioIntegradorEnVivo.PaqueteTuristico;
import ejercicioIntegradorEnVivo.cliente.Cliente;
import ejercicioIntegradorEnVivo.descuento.Descuento;

import java.util.List;

public class LocalizadorService {

    private final LocalizadorRepository localizadorRepository;

    public LocalizadorService() {
        localizadorRepository = new LocalizadorRepositoryEnMemoria();
    }

    public void registrarNuevoLocalizadorPara(Cliente unCliente, PaqueteTuristico unPaqueteTuristico) {
        List<Localizador> localizadoresRegistrados = localizadorRepository.localizadoresDe(unCliente);
        Descuento descuento = Descuento.aplicableA(unCliente, unPaqueteTuristico, localizadoresRegistrados);
        Localizador localizador = new Localizador(unCliente, unPaqueteTuristico, descuento);

        localizadorRepository.guardar(localizador);
    }
}
