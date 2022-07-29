import Reservas.Hotel;
import Reservas.Reserva;
import Reservas.Viajes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Localizador {
    protected Cliente cli;
    protected ArrayList<Reserva> reservas;

    public Localizador(Cliente cli, ArrayList<Reserva> reservas) {
        this.cli = cli;
        this.reservas = reservas;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cli=" + cli +
                ", reservas=" + reservas +
                '}';
    }

    public Double CalcularPrecio(){
        Double costo = 0.0;

        for(Reserva reserva:reservas){
            if(reserva instanceof Hotel){

            }
        }

        for(Reserva reserva:reservas){
            costo += reserva.obtCosto();
        }

        System.out.println(costo);

        //reservas.stream().filter(reserva -> reserva instanceof Hotel);
        List<Reserva> res = reservas.stream().filter(reserva -> reserva instanceof Hotel).collect(Collectors.toList());
        if(res.size()>=2){
            reservas.stream().filter(reserva -> reserva instanceof Hotel).forEach(reserva -> reserva.aplicarDescuento(5.0));
        }

        List<Reserva> res2 = reservas.stream().filter(reserva -> reserva instanceof Viajes).collect(Collectors.toList());
        if(res2.size()>=2){
            reservas.stream().filter(reserva -> reserva instanceof Viajes).forEach(reserva -> reserva.aplicarDescuento(5.0));
        }

        System.out.println(reservas);
        return costo;
    }
}
