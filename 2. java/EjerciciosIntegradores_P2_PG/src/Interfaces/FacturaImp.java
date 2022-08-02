package Interfaces;

import Clases.Factura;

import java.util.*;

public class FacturaImp implements CRUD<Factura>{

    private static FacturaImp instance = null;

    public static FacturaImp getInstance(){
        if(instance == null){instance = new FacturaImp();}
        return instance;
    }
    List<Factura> listaFacturas = new ArrayList<>();


    @Override
    public void save(Factura objeto) {
    /*
    Antes de querer agregar una factura a una collection de facturas tener en cuenta que:
        Será necesario validar si el cliente asociado a la factura se encuentra registrado en la collection de clientes. En caso de que no, el mismo deberá ser creado.
        Será necesario crear una lista de items y asociarla a la factura creada.
        El campo total de la factura es un campo calculado, por lo cual, para poder asignar este valor deberemos recorrer la lista de items y realizar las operaciones matemáticas necesarias para obtener el total.
     */
    ClienteImp clienteImp = ClienteImp.getInstance();
    if(!clienteImp.buscar(objeto.getCliente().getDni()).isPresent()){
        clienteImp.save(objeto.getCliente());
    }
    listaFacturas.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        listaFacturas.forEach(System.out::println);
    }

    @Override
    public Optional<Factura> buscar(String id) {
        return listaFacturas.stream().filter(x->x.getCodigo().equals(id)).findFirst();
    }

    @Override
    public void eliminar(String id) {
        if(buscar(id).isPresent()){
            listaFacturas.removeIf(x->x.getCodigo().equals(id));
            System.out.println("se elimino "+id);
        }else
        {
            System.out.println("Ese codigo no se encuentra en el sistema");
        }
    }

    @Override
    public List<Factura> traerTodos() {
        return this.listaFacturas;
    }
}
