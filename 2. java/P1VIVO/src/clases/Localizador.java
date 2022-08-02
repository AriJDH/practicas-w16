package clases;

import interfaces.Compra;

import java.time.LocalDate;
import java.util.List;

public class Localizador {
    private LocalDate fecha;
    private List<Compra> listaCompras;
    private Viajero cliente;
    private double total;

    public Localizador(LocalDate fecha, List<Compra> listaCompras, Viajero cliente, double total) {
        this.fecha = fecha;
        this.listaCompras = listaCompras;
        this.cliente = cliente;
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "fecha=" + fecha +
                ", listaCompras=" + listaCompras +
                ", cliente=" + cliente +
                ", total=" + total +
                '}';
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }

    public Viajero getCliente() {
        return cliente;
    }

    public void setCliente(Viajero cliente) {
        this.cliente = cliente;
    }

    public int cantReservas(){
        return this.listaCompras.size();
    }
}
