package ejercicioIntegradorEnVivo.cliente;

public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService() {
        this.clienteRepository = new ClienteRepositoryEnMemoria();
    }

    public boolean estaRegistrado(Cliente unCliente) {
        return clienteRepository.getClienteConDNI(unCliente.getDni()).isPresent();
    }

    public void registrarCliente(Cliente unCliente) {
        clienteRepository.guardar(unCliente);
    }
}
