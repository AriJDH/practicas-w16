package Turismo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int exitNumber = 1;

        while (exitNumber != 0){
            mostrarMenu();
            exitNumber = teclado.nextInt();


        }

    }

    public static void mostrarMenu(){
        System.out.println("==================================");
        System.out.println("====           MENU           ====");
        System.out.println("==================================");
        System.out.println();

        System.out.println("Digita la opción de lo que quieres hacer");

        System.out.println("1) Inscribir una reserva");
        System.out.println("2) Inscribir un plan turístico");
        System.out.println("3) Inscribir un cliente");
        System.out.println("0) salir. ");
        System.out.print("Selección: ");
    }

}
