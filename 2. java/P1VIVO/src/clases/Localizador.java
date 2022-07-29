package clases;

import interfaces.Compra;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Localizador {
    private LocalDate fecha;
    private List<Compra> listaCompras;
    private Viajero cliente;
    private double total;

    public Localizador(LocalDate fecha, List<Compra> listaCompras, Viajero cliente) {
        this.fecha = fecha;
        this.listaCompras = listaCompras;
        this.cliente = cliente;

        double tot = listaCompras.stream().mapToDouble(x->x.getPrecio()).sum();
        this.total = tot - (tot * calcularDescuento(listaCompras, cliente));
        cliente.getListaLocalizador().add(this);
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


    public double calcularDescuento(List<Compra> listaCompras, Viajero viajero){
        double descuento = 0;

        int cantHoteles = listaCompras.stream().filter(x -> x instanceof ReservaHotel).collect(Collectors.toList()).size();
        int cantComida = listaCompras.stream().filter(x -> x instanceof Comida).collect(Collectors.toList()).size();
        int cantViaje = listaCompras.stream().filter(x -> x instanceof Boleto && (((Boleto) x).getTipo().equals("Viaje"))).collect(Collectors.toList()).size();
        int cantTransporte = listaCompras.stream().filter(x -> x instanceof Boleto && (((Boleto) x).getTipo().equals("Transporte"))).collect(Collectors.toList()).size();

        if (viajero.getListaLocalizador().size() >= 2){
            descuento += 0.05;
        }
        if(cantHoteles > 0 && cantComida > 0 && cantViaje > 0 && cantTransporte > 0)
        {
            descuento+=0.1;
        }
        if (cantHoteles >= 2 || cantViaje >= 2){
            descuento += 0.05;
        }
        return descuento;
    }
}
