package Supermercado;

import java.util.ArrayList;

public class Factura {
    private Cliente cliente;
    private ArrayList<Item> listaItems;
    private double total;

    public Factura(Cliente cliente, ArrayList<Item> listaItems, double total) {
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.total = total;
    }

    public Factura(Cliente cliente, ArrayList<Item> listaItems) {
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.total = this.listaItems.stream()
                .mapToDouble((item)->item.getCostoUnit())
                .sum();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(ArrayList<Item> listaItems) {
        this.listaItems = listaItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void addItem(Item item) {
        this.listaItems.add(item);
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", listaItems=" + listaItems +
                ", total=" + total +
                '}';
    }
}
