package model;

import java.util.List;

public class Factura {
    private int codigoDeFactura;
    private Cliente cliente;
    private List<Item> listaDeItems;
    private double totalDeLaCompra;

    public Factura() {
    }
    public Factura(int codigoDeFactura, Cliente cliente, List<Item> listaDeItems, double totalDeLaCompra) {
        this.codigoDeFactura = codigoDeFactura;
        this.cliente = cliente;
        this.listaDeItems = listaDeItems;
        this.totalDeLaCompra = totalDeLaCompra;
    }

    public int getCodigoDeFactura() {
        return codigoDeFactura;
    }

    public void setCodigoDeFactura(int codigoDeFactura) {
        this.codigoDeFactura = codigoDeFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListaDeItems() {
        return listaDeItems;
    }

    public void setListaDeItems(List<Item> listaDeItems) {
        this.listaDeItems = listaDeItems;
    }

    public double getTotalDeLaCompra() {
        return totalDeLaCompra;
    }

    public void setTotalDeLaCompra(double totalDeLaCompra) {
        this.totalDeLaCompra = totalDeLaCompra;
    }
}

