package com.tomas.supermercado;

/**
 * Desarrollador: Tomas Octavio Rodriguez Herrera
 * Fecha: 01 de Agosto 2022
 */

import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<Item> items;
    private double totalCompra;
    private int codigo;

    public Factura() {

    }

    public Factura(Cliente cliente, List<Item> items, double totalCompra, int codigo) {
        this.cliente = cliente;
        this.items = items;
        this.totalCompra = totalCompra;
        this.codigo = codigo;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", items=" + items +
                ", totalCompra=" + totalCompra +
                ", codigo=" + codigo +
                '}';
    }
}
