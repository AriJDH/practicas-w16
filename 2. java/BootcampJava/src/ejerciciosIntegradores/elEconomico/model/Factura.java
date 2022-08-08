package ejerciciosIntegradores.elEconomico.model;

import java.util.List;

public class Factura {

    private Long codigo;
    private Cliente cli;
    private List<Item> listaItems;
    private double total;

    public Factura() {
    }

    public Factura(Long codigo, Cliente cli, List<Item> listaItems, double total) {
        this.codigo = codigo;
        this.cli = cli;
        this.listaItems = listaItems;
        this.total = total;
    }
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "codigo=" + codigo +
                ", cli=" + cli.toString() +
                ", listaItems=" + listaItems +
                ", total=" + total +
                '}';
    }
}
