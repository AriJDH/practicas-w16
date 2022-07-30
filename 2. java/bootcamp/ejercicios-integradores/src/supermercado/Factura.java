package supermercado;

import java.util.List;

public class Factura {

    private String id;
    private Cliente cliente;
    private List<Item> items;
    private Double totalCompra;

    public Factura(){}

    public Factura(Cliente cliente, List<Item> items, Double totalCompra, String id) {
        this.cliente = cliente;
        this.items = items;
        this.totalCompra = totalCompra;
        this.id = id;
    }

    @Override
    public String toString() {
        return "-Id: " + id +
                "\n-Cliente: " + cliente.getNombre() + " " + cliente.getApellido() +
                "\n-Total compra: " + totalCompra;
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

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
