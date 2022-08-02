package repos;

import clases.Viajero;

import java.util.HashMap;
import java.util.List;

public class RepositorioCliente {
    private HashMap<String, Viajero> listaClientes = new HashMap<>();

    public void crearViajero(Viajero viajero){
        listaClientes.put(viajero.getDni(), viajero);
    }
}
