package agenciaDeTurismo.repositorio;

import agenciaDeTurismo.Localizador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeLocalizadores {

    private static List<Localizador> localizadores = new ArrayList<>();

    public static void agregarLocalizador(Localizador localizador){
        localizadores.add(localizador);
    }

    public static List<Localizador> getLocalizadoresByCliente(String dni){
        return localizadores.stream().filter(localizador -> localizador.getCliente().getDni().equals(dni)).collect(Collectors.toList());
    }

    public static List<Localizador> getAll(){
        return localizadores;
    }
}
