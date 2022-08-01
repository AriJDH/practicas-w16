package supermercado;

import java.util.List;

public class Factura {
    private final Cliente cliente;
    private final List<Item> listaCompra;
    private final double total;

    public Factura(Cliente cliente, List<Item> listaCompra) {
        this.cliente = cliente;
        this.listaCompra = listaCompra;
        total = listaCompra.stream()
                .mapToDouble(item -> item.getCantidad() * item.getCostoUnitario())
                .sum();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getListaCompra() {
        return listaCompra;
    }

    public double getTotal() {
        return total;
    }
}
