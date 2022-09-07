package ejerciciosIntegradoresP1PG.ejercicioIntegradorParte1;

import java.util.ArrayList;
import java.util.List;

public class Factura {

    private long id;
    private Cliente cliente;
    private List<Item> listaItems;
    private double totalCompra;

    public Factura() {
    }

    public Factura(long id, Cliente cliente, List<Item> listaItems, double totalCompra) {
        this.id = id;
        this.cliente = cliente;
        this.listaItems = listaItems;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", listaItems=" + listaItems +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
