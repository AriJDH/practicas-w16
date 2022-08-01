package poo.supermercadoElEconomico;

import java.util.ArrayList;

public class Factura {

    private Cliente cliente;
    private ArrayList<ItemFactura> items;
    private double totalCompra;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        this.items = new ArrayList<>();
        this.totalCompra = 0;
    }

    public Factura() {
    }

    private ItemFactura buscarItem(ItemFactura item) {
        ItemFactura itemFactura = null;
        for (ItemFactura i : this.items) {
            if (i.equals(item))
                itemFactura = item;
        }
        return itemFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ItemFactura> getItems() {
        return items;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public void agregarItem(ItemFactura itemFactura) {
        this.items.add(itemFactura);
        this.totalCompra += itemFactura.getCantidadComprada() * itemFactura.getCostoUnitario();
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", listItems=" + items +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
