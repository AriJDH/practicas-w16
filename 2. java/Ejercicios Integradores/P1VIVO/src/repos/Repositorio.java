package repos;

import clases.*;
import interfaces.Compra;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Repositorio {
    private List<Localizador> listaCompras = new ArrayList<>();


    public List<Localizador> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Localizador> listaCompras) {
        this.listaCompras = listaCompras;
    }

    public void crearLocalizadorConPaquete(Boleto boletoTransporte, Boleto boletoViaje, Comida comida, ReservaHotel reservaHotel, Viajero viajero){

        List<Compra> listaComprass = new ArrayList<>(Arrays.asList(boletoTransporte, boletoViaje, comida, reservaHotel));
        LocalDate fechaHoy = LocalDate.now();

        double total = 0;
        for (Compra c: listaComprass){
            total += c.getPrecio();
        }

        total = total - (total * calcularDescuento(listaComprass, viajero, true));


        Localizador localizador = new Localizador(fechaHoy, listaComprass, viajero, total);
        viajero.getListaLocalizador().add(localizador);
        listaCompras.add(localizador);
    }

    public double calcularDescuento(List<Compra> listaCompras, Viajero viajero, boolean esPaquete){
        double descuento = 0;

        if (viajero.getListaLocalizador().size() >= 2){
            descuento += 0.05;
        }

        if (esPaquete){
            descuento += 0.1;
        }

        List<Compra> listaHoteles = listaCompras.stream().filter(x -> x instanceof ReservaHotel).collect(Collectors.toList());
        List<Compra> listaBoletos = listaCompras.stream().filter(y -> y instanceof Boleto && ((Boleto) y).getTipo().equals("Viaje")).collect(Collectors.toList());

        if (listaHoteles.size() >= 2 || listaBoletos.size() >= 2){
            descuento += 0.05;
        }

        return descuento;
    }

    public void crearLocalizadorReserva(Boleto boleto1, Boleto boleto2, ReservaHotel hotel1, ReservaHotel hotel2, Viajero viajero){
        List<Compra> listaComprass = new ArrayList<>(Arrays.asList(boleto1, boleto2, hotel1, hotel2));
        LocalDate fechaHoy = LocalDate.now();

        double total = 0;
        for (Compra c: listaComprass){
            total += c.getPrecio();
        }

        total = total - (total * calcularDescuento(listaComprass, viajero, false));


        Localizador localizador = new Localizador(fechaHoy, listaComprass, viajero, total);
        viajero.getListaLocalizador().add(localizador);
        listaCompras.add(localizador);
        System.out.println(localizador);
    }

    public void crearLocalizadorReservaUnica(ReservaHotel hotel, Viajero viajero){
        List<Compra> listaComprass = new ArrayList<>(Arrays.asList(hotel));
        LocalDate fechaHoy = LocalDate.now();

        double total = 0;
        for (Compra c: listaComprass){
            total += c.getPrecio();
        }

        total = total - (total * calcularDescuento(listaComprass, viajero, false));


        Localizador localizador = new Localizador(fechaHoy, listaComprass, viajero, total);
        viajero.getListaLocalizador().add(localizador);
        listaCompras.add(localizador);
        System.out.println(localizador);
    }


}
