package integrador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//ClientRepository
public class Supermercado implements ISupermercado {
    private final List<ICliente> clientes;
    Supermercado() {
        this.clientes = new ArrayList<ICliente>();
    }
    @Override
    public void agregarCliente(ICliente cliente) {
        this.clientes.add(cliente);
    }
    @Override
    public void borrarCliente(int dni) {
        this.clientes.removeIf(iCliente -> dni == iCliente.getDni());
    }
}

