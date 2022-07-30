package model;

import java.util.List;

public class Factura {
    private Long codigo;
    private Cliente cli;
    private List<Item> items;
    private double total;

    public Factura() {
    }

    public Factura(Long codigo, Cliente cli, List<Item> items) {
        this.codigo = codigo;
        this.cli = cli;
        this.items = items;
        this.total = calcularTotal();
    }

    private double calcularTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getCostoUnitario() * item.getCantidad();
        }
        return total;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "codigo=" + codigo +
                ", cli=" + cli.toString() +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}
