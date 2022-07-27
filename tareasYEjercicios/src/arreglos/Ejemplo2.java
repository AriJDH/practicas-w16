package arreglos;

import java.util.Scanner;

public class Ejemplo2 {

    private static final Scanner sc = new Scanner(System.in);
    private int[] sueldos;

    public void cargar() {
        sueldos = new int[5];
        for (int i = 0; i < sueldos.length; i++) {
            System.out.println("Ingrese el valor del sueldo: ");
            sueldos[i] = sc.nextInt();
        }
    }

    public void imprimir() {
        for (int j = 0; j < sueldos.length; j++) {
            System.out.println(sueldos[j]);
        }
    }

    public static void main(String[] args) {

        Ejemplo2 ej = new Ejemplo2();
        ej.cargar();
        ej.imprimir();

    }
}
