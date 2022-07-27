import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {
        Perecedero producto1= new Perecedero("fideos",500,2);
        Perecedero producto2 = new Perecedero("fideos2",600,1);
        Perecedero producto3= new Perecedero("fideos3",400,3);
        Perecedero producto4 = new Perecedero("fideos4",500,2);
        NoPerecedero producto5 = new NoPerecedero("fideos5",500);

        List<Producto> productos = new ArrayList<>();
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);
        System.out.print(printFinalPrice(productos));


    }

    public static double printFinalPrice(List<Producto> productos){
        double total = 0;
        for(Producto producto : productos){
            total += producto.calculate(2);
        }
     return total;
    }
}
