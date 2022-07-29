package ejercicioIntegradorEnVivo.cliente;

import java.util.Optional;

public interface ClienteRepository {

    Optional<Cliente> getClienteConDNI(Integer unDNI);

    void guardar(Cliente unCliente);
}
