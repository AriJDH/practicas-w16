package herencia;

public class Distribuidora {

    public static void main(String[] args) {

        Producto[] productosNoPerecederos = new NoPerecedero[5];

        productosNoPerecederos[1] = new NoPerecedero("Mouse", 20, "Tecnología");
        productosNoPerecederos[0] = new NoPerecedero("Laptop", 1000, "Tecnología");
        productosNoPerecederos[2] = new NoPerecedero("Libreta", 5, "Papelería");
        productosNoPerecederos[3] = new NoPerecedero("Audifonos", 15, "Tecnología");
        productosNoPerecederos[4] = new NoPerecedero("Boligrafo", 1, "Papelería");

        Producto[] productosPerecederos = new Perecedero[5];

        productosPerecederos[1] = new Perecedero("Queso", 2, 1);
        productosPerecederos[0] = new Perecedero("Manzana", 25, 2);
        productosPerecederos[2] = new Perecedero("Carne de res", 2300, 1);
        productosPerecederos[3] = new Perecedero("Lechuga", 15, 2);
        productosPerecederos[4] = new Perecedero("Papas", 6, 3);

        System.out.println("----- Productos No Perecederos ------");
        System.out.println(">>Precio total al vender 5 productos<<");
        for (int i = 0; i < productosNoPerecederos.length; i++) {
            System.out.println(productosNoPerecederos[i].toString()+ " \n Precio total: " +  productosNoPerecederos[i].calcular(5));
        }

        System.out.println("");
        System.out.println("----- Productos Perecederos ------");
        System.out.println(">>Precio total al vender 5 productos<<");
        for (int i = 0; i < productosPerecederos.length; i++) {
            System.out.println(productosPerecederos[i].toString() + " \n Precio total: " +  productosPerecederos[i].calcular(5));
        }

    }
}
