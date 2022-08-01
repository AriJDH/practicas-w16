package EjerciciosIntegradores_Java.Ejercicio_Agencia_de_turismo;

import EjerciciosIntegradores_Java.Ejercicio_Agencia_de_turismo.Reservas.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConsultasLocalizadores {

    private List<Localizador> lista;

    public ConsultasLocalizadores() {}

    public ConsultasLocalizadores(List<Localizador> lista) {
        this.lista = lista;
    }

    public List<Localizador> getLista() {
        return lista;
    }

    public void setLista(List<Localizador> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "ConsultasLocalizadores{" +
                "lista=" + lista +
                '}';
    }

    public int cantidadLocVendidos(){
        return this.lista.size();
    }

    public int cantidadReservas(){
        int cant = 0;

        for(Localizador loc : lista){
            cant += loc.getReservas().size();
        }

        return cant;
    }

    public void reservasxTipo(){

        lista.stream().forEach(reservas -> reservas.getReservas().stream().filter(reserva -> reserva instanceof Comida).forEach(System.out::println));
        lista.stream().forEach(reservas -> reservas.getReservas().stream().filter(reserva -> reserva instanceof Hotel).forEach(System.out::println));
        lista.stream().forEach(reservas -> reservas.getReservas().stream().filter(reserva -> reserva instanceof Transporte).forEach(System.out::println));
        lista.stream().forEach(reservas -> reservas.getReservas().stream().filter(reserva -> reserva instanceof Viajes).forEach(System.out::println));

    }

    public Double totalVentas(){
        Double total = 0.0;

        for(Localizador loc : lista){
            total += loc.calcularPrecio(lista);
        }

        return total;
    }

    public Double promedio(){
        Double total = totalVentas();
        int cantLoc = cantidadLocVendidos();

        return total/cantLoc;

    }

}
