package arreglos;

import java.util.Scanner;

public class Ejemplo1 {
    private Scanner entrada;
    private int[] sueldos;

    public void cargarSueldos(){
        entrada = new Scanner(System.in);
        sueldos = new int[5];
        for (int i = 0; i < sueldos.length; i++) {
            System.out.printf("Ingrese el sueldo para el Indice ["+(i+1)+"]: "); //Se le suma +1 al indice para que no muestre 0.
            sueldos[i] = entrada.nextInt();
        }
    }

    public void imprimirSueldos(){
        for (int i = 0; i < sueldos.length; i++) {
            System.out.println("["+(i+1)+"] $"+sueldos[i]); //Se le suma +1 al indice para que no muestre 0.
        }
    }

    public static void main(String[] args) {
        Ejemplo1 ejemplo1 = new Ejemplo1();

        ejemplo1.cargarSueldos();

        ejemplo1.imprimirSueldos();
    }

}
