package localizadores;

import clientes.Cliente;
import reservas.Hotel;
import reservas.Reserva;
import reservas.Viaje;

import java.util.List;
import java.util.stream.Collectors;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> listaReservas;
    private Double total;

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public Localizador(Cliente cliente, List<Reserva> listaReservas) {
        this.cliente = cliente;
        this.listaReservas = listaReservas;
    }


    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", listaReservas=" + listaReservas +
                ", total=" + total +
                '}';
    }

    public boolean paqueteCompleto(){
        long countHotel=0;
        long countViaje=0;
        long countComida=0;
        long countTransporte=0;

        countHotel= listaReservas.stream()
                .filter(x -> x instanceof Hotel)
                .count();
        countViaje= listaReservas.stream()
                .filter(x -> x instanceof Hotel)
                .count();
        countComida= listaReservas.stream()
                .filter(x -> x instanceof Hotel)
                .count();
        countTransporte= listaReservas.stream()
                .filter(x -> x instanceof Hotel)
                .count();

        if (countHotel==0){
            return false;
        }else if (countComida==0) {
            return false;
        } else if (countTransporte==0) {
            return false;
        }else if (countViaje==0){
            return false;
        }
        return true;
    }

    public void aplicarDescuentoDobleReserva(){
        //Tiene dos o más reservas de hotel o viaje, se aplica descuento sobre la reserva
        List<Reserva> lstReservas = listaReservas.stream()
                .filter(x -> x instanceof Hotel)
                .collect(Collectors.toList());
        if (lstReservas.size()>=2){
            listaReservas.stream()
                    .filter(x -> x instanceof Hotel || x instanceof Viaje)
                    .forEach(x -> x.aplicarDescuento(5.0));
        }
    }


    public Double calcularTotal(){
        Double total=0.0;

        this.aplicarDescuentoDobleReserva();

        total = listaReservas.stream()
                .mapToDouble(x -> x.getPrecio())
                .sum();

        //tiene paquete completo se aplica descuento sobre el total
        if (paqueteCompleto()==true){
            total = total - (total * (0.1));
        }
        return total;
    }

}
