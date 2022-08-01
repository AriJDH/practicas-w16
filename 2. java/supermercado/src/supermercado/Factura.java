package supermercado;

import java.util.List;

public class Factura {
    private final Cliente cliente;
    private final List<Item> listaCompra;
    private final double total;

    public Factura(Cliente cliente, List<Item> listaCompra, double total) {
        this.cliente = cliente;
        this.listaCompra = listaCompra;
        this.total = total;
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

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", listaCompra=" + listaCompra +
                ", total=" + total +
                '}';
    }
}
