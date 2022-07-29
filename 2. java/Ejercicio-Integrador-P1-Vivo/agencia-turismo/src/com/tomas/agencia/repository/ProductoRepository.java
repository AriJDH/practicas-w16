package com.tomas.agencia.repository;

import com.tomas.agencia.models.Producto;

public class ProductoRepository implements IProducto{

    @Override
    public Producto crearProducto(Producto producto) {

        if(producto != null){
            System.out.println("Producto creado");
            System.out.println(producto.toString());
            return producto;
        }

        System.out.println("Error en ingresar reserva");
        return null;



    }
}
