package ejerciciosIntegradores.agenciaViaje;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    private List<Localizador> localizadores;

    public Repositorio() {
        this.localizadores = new ArrayList<>();
    }

    public void guardarLocalizador(Localizador localizador){
        localizador = aplicarDescuento(localizador);
        localizadores.add(localizador);
    }

    public Localizador aplicarDescuento(Localizador localizador){
        Double porcentajeDescuento = 0d;

        //Dos localizadores previos
        if(localizadores.stream().filter(x -> x.getCliente().getNombre()
                .equals(localizador.getCliente().getNombre())).count() >= 2) {
            porcentajeDescuento += 0.05;
        }
        //Es paquete completo
        if (esPaqueteCompleto(localizador.getReservas())){
            porcentajeDescuento += 0.10;
        }
        //Dos reservas de hotel o boleto viaje
        if(esDescuentoDobleReserva(localizador.getReservas())) {
            porcentajeDescuento += 0.05;
        }

        Double descuento = localizador.getTotal() * porcentajeDescuento;
        localizador.setTotal(localizador.getTotal() - descuento);

        return localizador;
    }

    public List<Localizador> obtenerLocalizadores(){
        return this.localizadores;
    }

    public boolean esPaqueteCompleto(List<Reserva> reservas) {
        if(reservas.size() < 4){
            return false;
        }

        if(reservas.stream().filter(x -> x instanceof Hotel).count() == 0) {
            return false;
        } else if(reservas.stream().filter(x -> x instanceof BoletoViaje).count() == 0) {
            return false;
        } else if(reservas.stream().filter(x -> x instanceof Comida).count() == 0) {
            return false;
        } else if(reservas.stream().filter(x -> x instanceof Transporte).count() == 0) {
            return false;
        }

        return true;
    }

    public boolean esDescuentoDobleReserva(List<Reserva> reservas) {
        if(reservas.stream().filter(x -> x instanceof Hotel).count() == 2) {
            return true;
        } else if(reservas.stream().filter(x -> x instanceof BoletoViaje).count() == 2) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Repositorio{" +
                "localizadores=" + localizadores +
                '}';
    }
}
