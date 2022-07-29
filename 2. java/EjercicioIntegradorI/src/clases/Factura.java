package clases;

import java.util.List;

public class Factura {
    private int numeroFactura;
    private Cliente cliente;
    private List<Item> items;
    private double totalCompra;

    public Factura(int numeroFactura, Cliente cliente, List<Item> items, double totalCompra) {
        this.numeroFactura = numeroFactura;
        this.cliente = cliente;
        this.items = items;
        this.totalCompra = totalCompra;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
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

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "numeroFactura=" + numeroFactura +
                ", cliente=" + cliente +
                ", items=" + items +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
