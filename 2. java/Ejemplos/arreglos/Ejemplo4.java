package arreglos;

import java.util.Scanner;

public class Ejemplo4 {


    private Scanner entrada;
    private int [] sueldos;
    public void cargar(){
        entrada = new Scanner(System.in);
        sueldos = new int[5];
        for (int i = 0; i < sueldos.length; i++) {
            System.out.println("Ingrese el sueldo nro "+(i+1));
            sueldos[i]=Integer.parseInt(entrada.nextLine());
        }
    }

public void imprimir(){
    for (int i = 0; i < sueldos.length; i++) {
        System.out.println("Sueldo "+(i+1)+" "+sueldos[i]);
    }
}
    public static void main(String[] args) {
Ejemplo4 ejemplo4 = new Ejemplo4();
ejemplo4.cargar();
ejemplo4.imprimir();


    }
}
