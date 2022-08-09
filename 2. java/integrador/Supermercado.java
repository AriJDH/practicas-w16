package integrador;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {
    private final List<ICliente> clientes;
    Supermercado() {
        this.clientes = new ArrayList<ICliente>();
    }

    public void agregarCliente(ICliente cliente) {
        this.clientes.add(cliente);
    }
}
