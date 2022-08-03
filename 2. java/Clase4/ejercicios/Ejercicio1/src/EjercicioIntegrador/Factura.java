package EjercicioIntegrador;

import java.util.List;

public class Factura {
    private Clientes cliente;
    private List<Items> listaItems;
    private double totalCompra;
    private int codigo;

    public Factura() {
    }

    public Factura(Clientes cliente, List<Items> listaItems, double totalCompra,int codigo) {
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.totalCompra = totalCompra;
        this.codigo=codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Clientes getNombre() {
        return cliente;
    }

    public void setNombre(Clientes cliente) {
        this.cliente = cliente;
    }

    public List<Items> getListaItems() {
        return listaItems;
    }


    public void setListaItems(List<Items> listaItems) {
        this.listaItems = listaItems;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "nombre=" + cliente +
                ", listaItems=" + listaItems +
                ", totalCompra=" + totalCompra +
                ", totalCompra=" + codigo +
                '}';
    }
}
