package ejerciciosIntegradoresP1PG.ejercicioIntegradorParte1;

import java.util.ArrayList;
import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<Item> listaItems;
    private double totalCompra;

    public Factura() {
    }

    public Factura(Cliente cliente, List<Item> listaItems, double totalCompra) {
        this.cliente = cliente;
        this.listaItems = new ArrayList<>();
        this.totalCompra = totalCompra;
    }

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

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", listaItems=" + listaItems +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
