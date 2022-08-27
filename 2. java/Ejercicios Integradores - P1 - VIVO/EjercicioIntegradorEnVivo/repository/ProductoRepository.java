package EjercicioIntegradorEnVivo.repository;

import EjercicioIntegradorEnVivo.models.Producto;

public class ProductoRepository implements IProducto{

    @Override
    public Producto crearProducto(Producto producto) {
        if(producto !=null){
            System.out.println("Producto creado");
            System.out.println(producto.toString());
            return producto;
        }

        System.out.println("Error en ingresar reserva");
        return null;



    }
}
