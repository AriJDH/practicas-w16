package repos;

import clases.Boleto;
import clases.Comida;
import clases.Localizador;
import clases.ReservaHotel;
import interfaces.Compra;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControlRepositorio {
    public int cantidadLocalizadoresVendidos(Repositorio repo){
        return repo.getListaCompras().size();
    }

    public int cantidadTotalReservas(Repositorio repo){
        return repo.getListaCompras().stream().mapToInt(x -> x.cantReservas()).sum();
    }

    public double totalVentas(Repositorio repo){
        return repo.getListaCompras().stream().mapToDouble(x -> x.getTotal()).sum();
    }

    public double promedioTotalVentas(Repositorio repo){
        return totalVentas(repo) / cantidadLocalizadoresVendidos(repo);
    }

    public void obtenerDiccionario(Repositorio repo){
        List<Boleto> listaBoletosViaje = new ArrayList<Boleto>();
        List<Boleto> listaBoletosTransporte = new ArrayList<Boleto>();
        List<ReservaHotel> listaReservaHotel = new ArrayList<ReservaHotel>();
        List<Comida> listaComida = new ArrayList<Comida>();

        repo.getListaCompras().forEach(x ->
        {
            x.getListaCompras().stream()
                    .forEach(y -> {
                      if(y instanceof Boleto && ((Boleto) y).getTipo().equals("Viaje")) {
                          listaBoletosViaje.add((Boleto) y);
                      }
                      if(y instanceof Boleto && ((Boleto) y).getTipo().equals("Transporte")) {
                            listaBoletosTransporte.add((Boleto) y);
                      }
                      if(y instanceof ReservaHotel ) {
                            listaReservaHotel.add((ReservaHotel) y);
                      }
                      if(y instanceof Comida ) {
                            listaComida.add((Comida) y);
                      }
                    });
        });
        System.out.println("Lista de boletos de viaje");
        System.out.println(listaBoletosViaje);
        System.out.println("Lista de boletos de Transporte");
        System.out.println(listaBoletosTransporte);
        System.out.println("Lista de Reservas de hotel");
        System.out.println(listaReservaHotel);
        System.out.println("Lista Reservas de comida");
        System.out.println(listaComida);


    }

}
