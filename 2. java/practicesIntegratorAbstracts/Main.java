package practicesIntegratorAbstracts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    // Personalizada lista
    static List<Integer> listSerie = new ArrayList<>();

    // Personalizada numero
    static Serie serie = new Serie(listSerie, 0);

    // Serie por defecto lista
    static List<Integer> listSerie2 = new ArrayList<>();

    // Serie por defecto numero 2
    static Serie2 serie2 = new Serie2(listSerie2);


    public static void main(String[] args) {

        System.out.println("Seleccione alguna de las siguientes opciones:");
        System.out.println("1. Serie personalizada");
        System.out.println("2. Serie por defecto - numero 2");
        int optinionMain = sc.nextInt();

        if (optinionMain == 1) {
            Main.scannerOption();
        } else if (optinionMain == 2) {
            Main.scannerOptionDefault2();
        } else {
            System.out.println("Programa finalizado");
        }
    }

    private static void scannerOption() {

        System.out.println("Seleccione alguna de las siguientes opciones:");
        System.out.println("1. Inicializar la serie");
        System.out.println("2. Agregar el siguiente numero de a la serie");
        System.out.println("3. Resetear la serie");
        System.out.println("4. Salir del programa");

        int result = sc.nextInt();

        if (result == 1) {
            int resultNumberInit = Main.numberInitOption();
            serie.createWithInitialBase(resultNumberInit);
            Main.scannerOption();
        } else if (result == 2) {
            List<Integer> resultList = serie.countNetxNumber();
            resultList.forEach(System.out::println);
            Main.scannerOption();
        } else if (result == 3) {
            serie.resetListNumbers();
            listSerie.forEach(System.out::println);
            Main.scannerOption();
        } else {
            System.out.println("Programa finalizado");
        }
    }

    private static int numberInitOption() {
        System.out.println("Con que numero desea iniciar la serie?");
        return sc.nextInt();
    }

    private static int numberOptionDefaultSerie2() {

        System.out.println("Seleccione alguna de las siguientes opciones:");
        System.out.println("1. Agregar el siguiente numero de a la serie");
        System.out.println("2. Resetear la serie");
        System.out.println("3. Salir del programa");
        return sc.nextInt();
    }

    private static void scannerOptionDefault2() {

        int resultSerie2 = Main.numberOptionDefaultSerie2();

        if (resultSerie2 == 1) {
            List<Integer> resultList2 = serie2.countNetxNumber();
            resultList2.forEach(System.out::println);
            Main.scannerOptionDefault2();
        } else if (resultSerie2 == 2) {
            serie2.resetListNumbers();
            Main.scannerOptionDefault2();
        } else {
            System.out.println("Programa finalizado");
        }
    }
}
