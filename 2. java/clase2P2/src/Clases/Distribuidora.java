package Clases;


public class Distribuidora {
    public static void main(String[] args) {
        Producto[] productos = new Producto[5];
        productos[0] = new Perecedero("Carne",40.54,3);
        productos[1] = new NoPerecedero("Azucar",5, "Comida");
        productos[2] = new Producto("Leche",8.99);
        productos[3] = new Perecedero("Queso",100,1);
        productos[4] = new Producto("Jabon",15.32);

        for (int i = 0; i < productos.length; i++) {
            System.out.println(productos[i].toString());
            System.out.println("Cantidad: "+(i+1)+ "\t\tPrecio total: "+productos[i].calcular(i+1));
            System.out.println();
        }

    }

}
