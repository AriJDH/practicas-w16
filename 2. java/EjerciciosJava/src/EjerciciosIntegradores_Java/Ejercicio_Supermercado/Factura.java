package EjerciciosIntegradores_Java.Ejercicio_Supermercado;

import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<Item> listaItems;
    private Double total;

    public Factura() {}

    public Factura(Cliente cliente, List<Item> listaItems) {
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.total = calcularTotal();
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

    public Double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", listaItems=" + listaItems +
                ", total=" + total +
                '}';
    }

    private Double calcularTotal(){

        Double costoTotal = 0.0;

        for(Item item : listaItems){
            costoTotal += (item.getCostoUnitario() * item.getCantComprada());
        }

        return costoTotal;
    }
}
