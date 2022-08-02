package Interfaces;

import Clases.Item;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ItemImp implements CRUD<Item>{
    List<Item> listItems = new ArrayList<>();
    private static ItemImp instance = null;

    public static ItemImp getInstance(){
        if(instance == null){instance = new ItemImp();}
        return instance;
    }
    @Override
    public void save(Item objeto) {
        listItems.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
listItems.forEach(System.out::println);
    }

    @Override
    public Optional<Item> buscar(String id) {
        return listItems.stream().filter(x->x.getCodigo().equals(id)).findFirst();
    }

    @Override
    public void eliminar(String id) {
        if(buscar(id).isPresent()){
            listItems.removeIf(x->x.getCodigo().equals(id));
            System.out.println("se elimino "+id);
        }else
        {
            System.out.println("Ese codigo no se encuentra en el sistema");
        }
    }

    @Override
    public List<Item> traerTodos() {
        return this.listItems;
    }
}
