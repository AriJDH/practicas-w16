package supermercadoElEconomico.modules;

import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<Items> listaDeItems;

    public Factura(Cliente cliente, List<Items> listaDeItems) {
        this.cliente = cliente;
        this.listaDeItems = listaDeItems;
    }

    public Factura() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Items> getListaDeItems() {
        return listaDeItems;
    }

    public void setListaDeItems(List<Items> listaDeItems) {
        this.listaDeItems = listaDeItems;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", listaDeItems=" + listaDeItems +
                '}';
    }
}
