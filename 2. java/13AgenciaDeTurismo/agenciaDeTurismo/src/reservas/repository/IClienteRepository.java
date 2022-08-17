package reservas.repository;

import reservas.Cliente;
import reservas.TipoDeReservas;

import java.util.List;

public interface IClienteRepository {
    public List<TipoDeReservas> generarLocalizador(TipoDeReservas reservas);
    public void buscarReservasAnteriores();
    public Cliente crearCliente(String nombre, String dni);
}
