package ejercicioIntegradorEnVivo.cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepositoryEnMemoria implements ClienteRepository {

        private List<Cliente> clientes;

        public ClienteRepositoryEnMemoria() {
            this.clientes = new ArrayList<>();
        }


    @Override
    public Optional<Cliente> getClienteConDNI(Integer unDNI) {
        return clientes.stream().filter(cliente -> cliente.getDni().equals(unDNI)).findFirst();
    }

    @Override
    public void guardar(Cliente unCliente) {
        clientes.add(unCliente);
    }
}
