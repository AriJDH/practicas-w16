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
        List<Compra> listaBoletos = new ArrayList<>();
        List<Compra> listaComidas = new ArrayList<>();
        List<Compra> listaReservas = new ArrayList<>();

        repo.getListaCompras().forEach(x ->
        {
            x.getListaCompras().stream().filter(compra -> compra instanceof Boleto).forEach(compra -> listaBoletos.add(compra));
            x.getListaCompras().stream().filter(compra -> compra instanceof Comida).forEach(compra -> listaComidas.add(compra));
            x.getListaCompras().stream().filter(compra -> compra instanceof ReservaHotel).forEach(compra -> listaReservas.add(compra));
        });

        System.out.println(listaBoletos);
        System.out.println(listaComidas);
        System.out.println(listaReservas);



    }

}
