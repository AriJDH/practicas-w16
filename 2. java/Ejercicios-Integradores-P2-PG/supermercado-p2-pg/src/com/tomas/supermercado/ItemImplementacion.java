package com.tomas.supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImplementacion implements ICrud<Item>{

    List<Item> listaItems = new ArrayList<>();

    @Override
    public void guardar(Item objeto) {
        listaItems.add(objeto);
    }

    @Override
    public void mostrarDatos() {

        for(Item datoItem: listaItems) {
            System.out.println(datoItem.toString());
        }

    }

    @Override
    public Optional<Item> buscar(int id) {

        boolean itemExiste = false;
        for(Item datoItem: listaItems) {

            if(datoItem.getCodigo() == id) {
                System.out.println(datoItem.toString());
                itemExiste = true;

                return Optional.of(datoItem);
            }

        }

        if(!itemExiste) {
            System.out.println("El item no existe");
        }

        return Optional.empty();
    }

    @Override
    public List<Item> listarDatoCompleto() {
        return listaItems;
    }

    @Override
    public void eliminar(int id) {

        boolean itemExiste = false;
        for(Item datoItem: listaItems) {

            if(datoItem.getCodigo() == id) {
                itemExiste = true;
                listaItems.remove(datoItem);
            }

        }

        if(itemExiste) {
            System.out.println("El item fue elimindado");
        } else {
            System.out.println("El item no existe y por lo tanto no se ha podido eliminar ningún registro");
        }

    }

}
