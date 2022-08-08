package com.bootcamp.secondExercise;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<>();
        double totalPrice = 0;

        productsList.add(new Perecedero("Pescado", 4500, 3));//22500//11250
        productsList.add(new Perecedero("Aceite", 2300, 10));//9200
        productsList.add(new Perecedero("Arroz", 2000, 30));//8000
        productsList.add(new Perecedero("Mantequilla", 1500, 6));//6000

        for (Product product: productsList){
            //totalPrice = totalPrice + product.calculate(4);
            totalPrice = product.calculate(4);
        }
        System.out.println("El precio total es: "+totalPrice);
    }
}
