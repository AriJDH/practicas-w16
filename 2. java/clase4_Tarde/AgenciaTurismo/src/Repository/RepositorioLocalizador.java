package Repository;

import Entity.Localizador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioLocalizador {
    private Map<String, List<Localizador>> localizadores;

    public int getLocalizadores(String cliente){
        return (localizadores.get(cliente).size());
    }

    public void addLocalizador(String cliente, Localizador l){
        if (localizadores.get(cliente)==null){
            List<Localizador> aux = new ArrayList<>();
            aux.add(l);
            localizadores.put(cliente,aux);
        }
        else
            localizadores.get(cliente).add(l);
    }

    public RepositorioLocalizador() {
        localizadores = new HashMap<>();
    }

    public double historialCliente(String cliente){
        double beneficio = 1;
        if (localizadores.size()!=0 && localizadores.get(cliente).size() >= 2)
            beneficio= 0.95;
        return beneficio;
    }
}
