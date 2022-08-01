package EjerciciosIntegradores_Java.Ejercicio_Agencia_de_turismo;

import EjerciciosIntegradores_Java.Ejercicio_Agencia_de_turismo.Reservas.Hotel;
import EjerciciosIntegradores_Java.Ejercicio_Agencia_de_turismo.Reservas.Reserva;
import EjerciciosIntegradores_Java.Ejercicio_Agencia_de_turismo.Reservas.Viajes;
import EjerciciosIntegradores_Java.Ejercicio_Agencia_de_turismo.Reservas.Transporte;
import EjerciciosIntegradores_Java.Ejercicio_Agencia_de_turismo.Reservas.Comida;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Localizador {
    private Cliente cli;
    private List<Reserva> reservas;

    public Localizador(Cliente cli, List<Reserva> reservas) {
        this.cli = cli;
        this.reservas = reservas;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cli=" + cli +
                ", reservas=" + reservas +
                '}';
    }

    private boolean primerDescuento(List<Localizador> lista){

        if(lista.stream().filter(loc -> loc.getCli().getId() == this.cli.getId()).count() >= 3){
            return true;
        } else {
            return false;
        }

    }

    private boolean segundoDescuento(){

        if(reservas.size() < 4)
            return false;

        if(reservas.stream().filter(reserva -> reserva instanceof Comida).count() == 0)
            return false;
        if(reservas.stream().filter(reserva -> reserva instanceof Hotel).count() == 0)
            return false;
        if(reservas.stream().filter(reserva -> reserva instanceof Transporte).count() == 0)
            return false;
        if(reservas.stream().filter(reserva -> reserva instanceof Viajes).count() == 0)
            return false;

        return true;
    }

    public Double calcularPrecio(List<Localizador> lista){

        Double costo = 0.0;
        Double descTotal = 0.0;

        if(primerDescuento(lista))
            descTotal += 0.05;

        if(segundoDescuento())
            descTotal += 0.1;

        List<Reserva> res = reservas.stream().filter(reserva -> reserva instanceof Hotel).collect(Collectors.toList());
        if(res.size()>=2){
            reservas.stream().filter(reserva -> reserva instanceof Hotel).forEach(reserva -> reserva.aplicarDescuento(5.0));
        }

        List<Reserva> res2 = reservas.stream().filter(reserva -> reserva instanceof Viajes).collect(Collectors.toList());
        if(res2.size()>=2){
            reservas.stream().filter(reserva -> reserva instanceof Viajes).forEach(reserva -> reserva.aplicarDescuento(5.0));
        }

        for(Reserva reserva:reservas){
            costo += reserva.obtCosto();
        }

        costo *= (1-descTotal);

        return costo;
    }
}
