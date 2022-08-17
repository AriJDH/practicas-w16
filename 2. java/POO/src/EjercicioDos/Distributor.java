package EjercicioDos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Distributor {
    static List<Product> products = new ArrayList<>();
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        loadData();

        final int[] i = {1};
        List<Product> shoppingCart = new ArrayList<>();
        final double[] totalPay = {0};

        System.out.println("Bienvenido a la distribuidora Anggy");
        System.out.println("Los productos exsitentes en este momento son: ");
        products.stream().forEach(product -> {
            System.out.println(i[0] + ". " + product.toString());
            i[0]++;
        });

        do {
            System.out.print("Escoja el producto que desea comprar (ingrese el codigo): ");

            int productIndex = read.nextInt();
            shoppingCart.add(products.get(productIndex-1));
        } while(shoppingCart.size() < 4);

        System.out.println("Sus compras fueron: ");
        shoppingCart.stream().forEach(product -> {
            System.out.println("- " + product.toString());
            totalPay[0] = totalPay[0] + product.calcular(1);
        });
        System.out.println("Total a pagar: " + totalPay[0]);
    }


    public static void loadData() {
        products.add(new Perishable("Carne", 12000.0, 5));
        products.add(new Perishable("Queso", 7000.0, 1));
        products.add(new Perishable("Huevos", 10500.0, 3));
        products.add(new Perishable("Manzanas", 5300.0, 2));

        products.add(new Nonperishable("Atun", 4500.0, "Pez"));
        products.add(new Nonperishable("Arroz", 7450.0, "Cereal"));
        products.add(new Nonperishable("Pasta", 1200.0, "Cereal"));
        products.add(new Nonperishable("Almendras", 6500.0, "Frutos secos"));
    }
}
