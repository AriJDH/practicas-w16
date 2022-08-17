package reservas.repository;

import reservas.Cliente;
import reservas.TipoDeReservas;

import java.util.List;

public class ClienteRepository implements IClienteRepository{


    @Override
    public List<TipoDeReservas> generarLocalizador(TipoDeReservas reservas) {
        return null;
    }

    @Override
    public void buscarReservasAnteriores() {

    }

    @Override
    public Cliente crearCliente(String nombre, String dni) {
        Cliente cliente = new Cliente(nombre,dni);
        return cliente;
    }
}
