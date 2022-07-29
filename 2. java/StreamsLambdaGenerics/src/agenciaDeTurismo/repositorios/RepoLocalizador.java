package agenciaDeTurismo.repositorios;

import agenciaDeTurismo.dominio.Localizador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepoLocalizador {

    private List<Localizador> localizadores = new ArrayList<>();

    public void agregarLocalizador(Localizador nuevoLocalizador){

        nuevoLocalizador.setTotal(nuevoLocalizador.getSubtotal());

        List<Localizador> lozalizadoresClientes = localizadores
                .stream()
                .filter(elem -> elem.getCliente() == nuevoLocalizador.getCliente())
                .collect(Collectors.toList());

        if(localizadores.size > 2)
            nuevoLocalizador.setTotal(nuevoLocalizador.getTotal() * 0.95);

        localizadores.add(nuevoLocalizador);
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

}
