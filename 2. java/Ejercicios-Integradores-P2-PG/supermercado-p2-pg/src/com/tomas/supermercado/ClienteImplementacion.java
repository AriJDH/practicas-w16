package com.tomas.supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImplementacion implements ICrud <Cliente>{

    List<Cliente> listaCliente = new ArrayList<>();

    @Override
    public void guardar(Cliente objeto) {
        listaCliente.add(objeto);
    }

    @Override
    public void mostrarDatos() {

        for(Cliente datoCliente: listaCliente) {
            System.out.println(datoCliente.toString());
        }

    }

    @Override
    public Optional<Cliente> buscar(int id) {

        boolean clienteExiste = false;
        for(Cliente datoCliente: listaCliente) {

            if(datoCliente.getDni() == id) {
                System.out.println(datoCliente.toString());
                clienteExiste = true;

                return Optional.of(datoCliente);
            }

        }

        if(!clienteExiste) {
            System.out.println("El cliente no existe");
        }

        return Optional.empty();
    }

    @Override
    public List<Cliente> listarDatoCompleto() {
        return listaCliente;
    }

    @Override
    public void eliminar(int id) {

        boolean clienteExiste = false;
        for(Cliente datoCliente: listaCliente) {

            if(datoCliente.getDni() == id) {
                clienteExiste = true;
                listaCliente.remove(datoCliente);
            }

        }

        if(clienteExiste) {
            System.out.println("El cliente fue elimindado");
        } else {
            System.out.println("El cliente no existe y por lo tanto no se ha podido eliminar ningún registro");
        }

    }
}
