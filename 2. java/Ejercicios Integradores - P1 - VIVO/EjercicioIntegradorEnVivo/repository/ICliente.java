package EjercicioIntegradorEnVivo.repository;

import EjercicioIntegradorEnVivo.models.Cliente;
import EjercicioIntegradorEnVivo.models.Localizadores;

public interface ICliente {

    public Cliente crearCliente(Cliente cliente);

    public Cliente agregarLocalizador(Localizadores localizadores,Cliente cliente);

}
