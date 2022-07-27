package practicesPOO2;

public class Distribuidora {
    public static void main(String[] args) {
        Producto[] productos = new Producto[3];

        productos[0] = new Perecedero("Pollo", 7.5, 1);
        productos[1] = new NoPerecedero("Queso", 4.2, "Refrigerado");
        productos[2] = new Producto("Jabon", 6.1);

        for (Producto producto: productos){
            System.out.println(producto.calcular(5));
        }
    }
}
