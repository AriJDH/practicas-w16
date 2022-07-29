package EjercicioIntegrador;

import java.util.List;

public class Factura {
    private List<Clientes> nombre;
    private List<Items> listaItems;
    private Integer totalCompra;

    public Factura(List<Clientes> nombre, List<Items> listaItems, Integer totalCompra) {
        this.nombre = nombre;
        this.listaItems = listaItems;
        this.totalCompra = totalCompra;
    }

    public List<Clientes> getNombre() {
        return nombre;
    }

    public void setNombre(List<Clientes> nombre) {
        this.nombre = nombre;
    }

    public List<Items> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Items> listaItems) {
        this.listaItems = listaItems;
    }

    public Integer getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Integer totalCompra) {
        this.totalCompra = totalCompra;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "nombre=" + nombre +
                ", listaItems=" + listaItems +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
