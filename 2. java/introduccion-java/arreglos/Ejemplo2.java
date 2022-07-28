package arreglos;

import java.util.Scanner;

public class Ejemplo2 {
    private Scanner teclado;
    private int[] sueldos;

    public void cargar(){
        teclado = new Scanner(System.in);
        sueldos = new int[5];

        for (int i = 0; i < sueldos.length; i++) {
            System.out.println("Introduce el sueldo");
            sueldos[i] = teclado.nextInt();
        }
    }

    public void imprimir(){
        for (int i = 0; i < sueldos.length; i++) {
            System.out.println("El sueldo es: " + sueldos[i]);
        }
    }

    public static void main(String[] args) {
        Ejemplo2 ejemplo2 = new Ejemplo2();
        ejemplo2.cargar();
        ejemplo2.imprimir();

    }
}
