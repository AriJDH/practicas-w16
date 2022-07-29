package ejercicioIntegradorEnVivo;

import ejercicioIntegradorEnVivo.cliente.Cliente;
import ejercicioIntegradorEnVivo.cliente.ClienteService;
import ejercicioIntegradorEnVivo.localizador.LocalizadorService;

public class AgenciaDeTurismo {

    private final LocalizadorService localizadorService;
    private final ClienteService clienteService;

    public AgenciaDeTurismo() {
        this.localizadorService = new LocalizadorService();
        this.clienteService = new ClienteService();
    }

    public void registrarCompraDe(Cliente unCliente, PaqueteTuristico paqueteTuristico) {
        validarClienteEstaRegistrado(unCliente);
        localizadorService.registrarNuevoLocalizadorPara(unCliente, paqueteTuristico);
    }

    private void validarClienteEstaRegistrado(Cliente unCliente) {
        if (!clienteService.estaRegistrado(unCliente))
            throw new RuntimeException("No esta registrado el cliente " + unCliente.toString());
    }

    public void registrarCliente(Cliente unCliente) {
        clienteService.registrarCliente(unCliente);
    }
}
