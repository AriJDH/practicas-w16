package supermercado;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Supermercado {
    private final Set<Cliente> clientes = new HashSet<>();
    private final Set<Factura> facturas = new HashSet<>();

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Factura crearFactura(Cliente cliente, List<Item> items) {
        double total = items.stream()
                .mapToDouble(item -> item.getCantidad() * item.getCostoUnitario())
                .sum();
        agregarCliente(cliente);
        Factura f = new Factura(cliente, items, total);
        facturas.add(f);
        return f;
    }

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public Set<Factura> getFacturas() {
        return facturas;
    }

    @Override
    public String toString() {
        return "Supermercado{" +
                "clientes=" + clientes +
                ", facturas=" + facturas +
                '}';
    }
}
