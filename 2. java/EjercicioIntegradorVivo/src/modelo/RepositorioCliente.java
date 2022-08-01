package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioCliente {
    private Map<Cliente, List<Localizador>> localizadores= new HashMap<>();

    public List<Localizador> historial(Cliente cliente){
        if(localizadores.containsKey(cliente)){
            return localizadores.get(cliente);
        }else{
            return new ArrayList<>();
        }
    }

    public void crearCliente(Cliente cliente){
        if(!buscarCliente(cliente)){
            localizadores.put(cliente,new ArrayList<>());
        }
    }

    public boolean buscarCliente(Cliente cliente){
        return localizadores.containsKey(cliente);
    }

    public void agregarLocalizador(Cliente cliente, Localizador localizador){
        if(buscarCliente(cliente)){
            this.localizadores.get(cliente).add(localizador);
        }else{
            crearCliente(cliente);
            this.localizadores.get(cliente).add(localizador);
        }
    }

    @Override
    public String toString() {
        return "RepositorioCliente{" +
                "localizadores=" + localizadores +
                '}';
    }
}
