package Arreglos;

import java.util.Scanner;

public class Vector {
    private Scanner teclado;
    private  int[] sueldo;

    public void cargar(){
        teclado = new Scanner(System.in);
        sueldo = new int[5];
        for(int i = 0; i <sueldo.length; i++ )
        {
            System.out.println("Ingrese el valor del sueldo: ");
            sueldo[i] = teclado.nextInt();
        }
    }
    public void imprimir(){
        for(int i = 0; i <sueldo.length; i++ )
        {
            System.out.println(sueldo[i]);
        }
    }

    public static  void main(String[] args){
        Vector ejercicioDos = new Vector();
        ejercicioDos.cargar();
        ejercicioDos.imprimir();
    }
}
