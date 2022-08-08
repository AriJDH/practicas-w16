package supermercadoElEconomico;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private String codigo;
    private Cliente cliente;
    private List<Item> listaDeItems;
    private double totalDeCompra;

    public Factura(){
        this.codigo = "";
        this.cliente = new Cliente();
        this.listaDeItems = new ArrayList();
        this.totalDeCompra = 0.0;
    }

    public Factura(String codigo, Cliente cliente, List<Item> listaDeItems, double totalDeCompra) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.listaDeItems = listaDeItems;
        this.totalDeCompra = totalDeCompra;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListaDeItems() {
        return this.listaDeItems;
    }

    public void setListaDeItems(List<Item> listaDeItems) {
        this.listaDeItems = listaDeItems;
    }

    public double getTotalDeCompra() {
        return this.totalDeCompra;
    }

    public void setTotalDeCompra(double totalDeCompra) {
        this.totalDeCompra = totalDeCompra;
    }
}
