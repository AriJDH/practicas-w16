package repos;

import clases.Boleto;
import clases.Localizador;
import interfaces.Compra;

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
        List<Boleto> listaBoletos = new List<Boleto>();

        repo.getListaCompras().forEach(x ->
        {
            List<Boleto> listaNuevaBoletos = x.getListaCompras().stream().filter(y -> y instanceof Boleto && ((Boleto) y).getTipo().equals("Viaje")).collect(Collectors.toList());
        });


    }

}
