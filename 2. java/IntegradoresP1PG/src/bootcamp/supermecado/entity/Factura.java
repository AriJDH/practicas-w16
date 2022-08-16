package bootcamp.supermecado.entity;

import java.util.List;

public class Factura {
    private Integer id;
    private Cliente cliente;
    private List<Item> items;
    private Double totalCompra;

    public Factura(){}

    public Factura(Integer id, Cliente cliente, List<Item> items, Double totalCompra) {
        this.id = id;
        this.cliente = cliente;
        this.items = items;
        this.totalCompra = totalCompra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", items=" + items +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
