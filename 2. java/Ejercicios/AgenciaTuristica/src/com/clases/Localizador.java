package com.clases;

import com.repositorio.RepositorioLocalizador;

import java.math.BigDecimal;
import java.util.List;

import static java.math.BigDecimal.ZERO;

public class Localizador {
    private List<BoletoViaje> boletosViaje;
    private List<Comida> comidas;
    private List<ReservaHotel> reservasHotel;
    private List<Transporte> transportes;
    private Cliente cliente;



    public Double calcularMonto() {
Double montoTotal=0d;
        if (boletosViaje != null)
            montoTotal = boletosViaje.stream()
                    .map(Producto::getValor)
                    .reduce(0d, Double::sum);
       if(comidas!=null)
        montoTotal += comidas.stream()
                .map(Producto::getValor)
                .reduce(0d, Double::sum);
       if(reservasHotel!=null)
       montoTotal += reservasHotel.stream()
                .map(Producto::getValor)
                .reduce(0d, Double::sum);
       if(transportes!=null)
        montoTotal += transportes.stream()
                .map(Producto::getValor)
                .reduce(0d, Double::sum);

        if (esFullPack(boletosViaje, comidas, reservasHotel, transportes)) {
            montoTotal = (double) Math.round(montoTotal / 1.10);
        } else {
            if (aplicaDescuentoHotel(reservasHotel)) {
                montoTotal = (double) Math.round(montoTotal / 1.05);
            } else {
                if (aplicaDescuentoBoletoViaje(boletosViaje)) {
                  montoTotal = (double) Math.round(montoTotal / 1.05);
                } else {
                    if (clienteVip(cliente.getDni())) {
                        montoTotal = (double) Math.round(montoTotal / 1.05);
                    }
                }
            }


        }

        return montoTotal;
    }


    public Localizador(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<BoletoViaje> getBoletosViaje() {
        return boletosViaje;
    }

    public void setBoletosViaje(List<BoletoViaje> boletosViaje) {
        this.boletosViaje = boletosViaje;
    }

    public List<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(List<Comida> comidas) {
        this.comidas = comidas;
    }

    public List<ReservaHotel> getReservasHotel() {
        return reservasHotel;
    }

    public void setReservasHotel(List<ReservaHotel> reservasHotel) {
        this.reservasHotel = reservasHotel;
    }

    public List<Transporte> getTransportes() {
        return transportes;
    }

    public void setTransportes(List<Transporte> transportes) {
        this.transportes = transportes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }



    public Boolean esFullPack(List<BoletoViaje> boletosViaje, List<Comida> comidas, List<ReservaHotel> reservasHotel, List<Transporte> transportes) {

        return boletosViaje!=null && comidas!=null && reservasHotel!=null && transportes!=null;
    }

    public boolean aplicaDescuentoHotel(List<ReservaHotel> reservasHotel) {
        if(reservasHotel!=null){
            return reservasHotel.stream().count() >= 2;
        }else{
            return false;
        }

    }

    public boolean aplicaDescuentoBoletoViaje(List<BoletoViaje> boletosViaje) {
        if(boletosViaje!=null) {
            return boletosViaje.stream().count() >= 2;
        }else{
            return false;
        }
    }

    public boolean clienteVip(String dni) {
        RepositorioLocalizador repo = new RepositorioLocalizador();
        return repo.clienteVip(dni);

    }

    @Override
    public String toString() {
        return "Localizador" +
                "boletosViaje:\n Monto -----  Destino" + boletosViaje.stream().map(boletoViaje -> {
            return boletoViaje.getValor()+" ---- "+boletoViaje.getDestino();}) +
                ", comidas=" + comidas.stream().toString() +
                ", reservasHotel=" + reservasHotel.stream().toString() +
                ", transportes=" + transportes.stream().toString() +
                ", cliente=" + cliente.toString() +
                '}';
    }
}
