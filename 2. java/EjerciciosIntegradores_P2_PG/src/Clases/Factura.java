package Clases;

import java.util.List;

public class Factura {
    private Cliente cliente;
    List<Item> listaItem;
    double totalCompra;
    String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", listaItem=" + listaItem +
                ", totalCompra=" + totalCompra +
                ", codigo='" + codigo + '\'' +
                '}';
    }

    public Factura(Cliente cliente, List<Item> listaItem, String codigo) {
        /*
    Antes de querer agregar una factura a una collection de facturas tener en cuenta que:
        Será necesario crear una lista de items y asociarla a la factura creada.
        El campo total de la factura es un campo calculado, por lo cual, para poder asignar este valor deberemos recorrer la lista de items y realizar las operaciones matemáticas necesarias para obtener el total.
     */
        this.cliente = cliente;
        this.listaItem = listaItem;
        this.codigo = codigo;
        this.totalCompra = listaItem.stream().mapToDouble(x->x.getCostoUnitario()*x.getCantComprada()).sum();
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
