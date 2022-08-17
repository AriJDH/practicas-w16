package com.bootcamp.agencia.entitiy;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;

    private Double precio;

    public Localizador() {
        this.cliente = new Cliente();
        this.reservas =List.of();
    }

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = new Cliente();
        this.reservas = reservas;
    }




    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
