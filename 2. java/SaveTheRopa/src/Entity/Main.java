package Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner leer = new Scanner(System.in);
    public static void main(String[] args) {
        Wardrobe wardrobe = new Wardrobe();

         new ArrayList<>();

        Integer opcionmenu = 0;
        do {
            opcionmenu = printMenu();
            if (opcionmenu == 1) {
                Integer opcionprenda = 0;
                List<Garment> garments = new ArrayList<>();
                do {
                    opcionprenda = printMenuGarment();
                    if (opcionprenda == 1) {
                        System.out.println("Ingrese las prenda a guardar.");
                        Garment garment = saveGarment();
                        garments.add(garment);
                    } else if (opcionprenda == 2) {
                        wardrobe.guardarPrendas(garments);
                    }
                } while (opcionprenda != 2);

            } else if (opcionmenu == 2) {
                wardrobe.mostrarPrendas();
            } else if (opcionmenu == 3) {
                System.out.println("\n\n\n\n\n\n");
                System.out.print("Ingrese el localizador de prendas: ");
                Integer localizador = leer.nextInt();
                System.out.println("---------------------------------------");
                for (Garment garment: wardrobe.devolverPrendas(localizador)) {
                    System.out.println(" - Marca: " + garment.getBrand() + " / Modelo: " + garment.getModel() );
                }
                System.out.println("---------------------------------------");
            }
        } while (opcionmenu != 4);

    }

    public static Integer printMenu() {
        System.out.println("1. Guardar Prendas");
        System.out.println("2. Mostrar prendas");
        System.out.println("3. Mostrar prendas en localizador");
        System.out.println("4. salir");
        System.out.print("Ingrese la opcion deseada: ");
        return leer.nextInt();
    }

    public static Integer printMenuGarment() {
        System.out.println("1. Ingresar prenda");
        System.out.println("2. No ingresar más prendas");
        System.out.print("Ingrese la opcion deseada: ");
        return leer.nextInt();
    }

    public static Garment saveGarment() {
        Garment garment = new Garment();

        System.out.print("Marca: ");
        garment.setBrand(leer.next());

        System.out.print("Modelo: ");
        garment.setModel(leer.next());

        return garment;
    }
}
