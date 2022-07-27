// AKA: Distribuidora
public class Ejercicio2 {
    public static void main(String[] args) {
        Producto productos[] = new Producto[3];

        // Hard-code version
        productos[0] = new Perecedero("Leche", 770, 3);
        productos[1] = new NoPerecedero("Atún", 550, "Enlatado");
        productos[2] = new Perecedero("Café Tostado", 1100, 150);

        System.out.println("Se venden: \n" +
                "1 Leche\n" +
                "2 Atún\n" +
                "2 Café Tostado\n");
        double total = productos[0].calcular(1) +
                productos[1].calcular(2) +
                productos[2].calcular(2);
        System.out.println("Precio Total: $" + total);

        /* TODO: Version donde se cargue un inventario por teclado
            y luego se pregunten cuales fueron los ventas.
            Según eso, recorrer el Array y sumar el total.
        */

    }
}
