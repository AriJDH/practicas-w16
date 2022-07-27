package arreglos;

import java.util.Scanner;

public class Ejemplo1 {
    private Scanner teclado;
    private int[] sueldos;
    public void cargar(){
        teclado=new Scanner(System.in);
        sueldos= new int[5];
        for (int i =0;i<sueldos.length;i++){
            System.out.println("ingrese el  valor del sueldo ");
            sueldos[i]=teclado.nextInt();
        }
    }

    public void print(){
        for (int i =0;i<sueldos.length;i++){
            System.out.println("el sueldo es: "+sueldos[i]);
        }
    }
    public static void main(String[] args) {
        Ejemplo1 ejemplo1= new Ejemplo1();
        ejemplo1.cargar();
        ejemplo1.print();
    }
}
