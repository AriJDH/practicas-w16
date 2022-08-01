package EjercicioIntegrador_Parte1;

import java.util.List;

public class Factura {
    private Cliente cliente;
    List<Item> listaItem;
    double totalCompra;

    public Factura(Cliente cliente, List<Item> listaItem, double totalCompra) {
        this.cliente = cliente;
        this.listaItem = listaItem;
        this.totalCompra = totalCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListaItem() {
        return listaItem;
    }

    public void setListaItem(List<Item> listaItem) {
        this.listaItem = listaItem;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }
}
