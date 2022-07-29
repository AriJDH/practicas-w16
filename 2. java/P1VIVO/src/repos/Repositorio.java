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

    public void CrearLocalizador(LocalDate fecha, List<Compra> lista, Viajero cliente){
        Localizador localizador = new Localizador(fecha,lista,cliente);
        listaCompras.add(localizador);
    }

}
