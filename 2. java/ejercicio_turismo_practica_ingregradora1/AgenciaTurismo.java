package ejercicio_turismo;

import java.util.ArrayList;
import java.util.List;

public class AgenciaTurismo {

   private RepositoryCliente clientes;
   private Repository localizadores;

    public static void main(String[] args) {


    //falta agregar pruebas


    }



    public RepositoryCliente getClientes() {
        return clientes;
    }

    public void setClientes(RepositoryCliente clientes) {
        this.clientes = clientes;
    }

    public Repository getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(Repository localizadores) {
        this.localizadores = localizadores;
    }
}

