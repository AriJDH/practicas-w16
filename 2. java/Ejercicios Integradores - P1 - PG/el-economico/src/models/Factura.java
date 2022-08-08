package models;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> listaItems;
    private Double total_factura;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
    }

    public Double getTotal_factura() {
        return total_factura;
    }

    public void setTotal_factura(Double total_factura) {
        this.total_factura = total_factura;
    }

    public Factura(Cliente cliente, List<Item> listaItems, Double total_factura) {
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.total_factura = total_factura;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", listaItems=" + listaItems +
                ", total_factura=" + total_factura +
                '}';
    }
}
