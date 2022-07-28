import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args){
        List<Producto> listadoDeProductos = new ArrayList<>();
        Producto lecheDeAlmendras = new Producto("leche de almendras", 250);
        Producto fideosDeArroz = new Producto("fideos de arroz", 200);
        Producto cereales = new Producto("cereales", 50);
        Producto cafe = new Producto("cafe", 350);
        Producto untableDeCastañas = new Producto("untable de castañas", 175);

        listadoDeProductos.add(lecheDeAlmendras);
        listadoDeProductos.add(fideosDeArroz);
        listadoDeProductos.add(cereales);
        listadoDeProductos.add(cafe);
        listadoDeProductos.add(untableDeCastañas);

        for (Producto producto: listadoDeProductos ){
            System.out.println("Producto: " + producto.getNombre() +", " + "Precio unitario: "+  producto.getPrecio() +", " +"Precio total: " + producto.calcular(10));
        }
    }
}
