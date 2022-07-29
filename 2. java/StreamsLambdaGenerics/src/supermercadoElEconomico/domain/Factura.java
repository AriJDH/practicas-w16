package supermercadoElEconomico.domain;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items = new ArrayList<>();
    private double totalCompra;

    public Factura(Cliente cliente, List<Item> items, double totalCompra) {
        this.cliente = cliente;
        this.items = items;
        this.totalCompra = totalCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void agregaritem(Item item) {
        this.items.add(item);
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }
}
