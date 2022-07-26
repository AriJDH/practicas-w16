package arreglos;

import javax.crypto.ExemptionMechanism;
import java.util.Scanner;

public class Ejemplo2 {

    private Scanner teclado;
    private int [] sueldos;

    public void cargar (){
        teclado = new Scanner(System.in);
        sueldos = new int [5];

        for (int i = 0; i < sueldos.length; i++){
            System.out.println("Ingrese sueldo para posicion " + i + " : ");
            sueldos[i] = teclado.nextInt();
        }
        teclado.close();
    }

    public void imprimir(){
        for(int j = 0; j < sueldos.length; j++){
            System.out.println("Sueldo de " + j + " : " +  sueldos[j]);
        }
    }

    public static void main(String[] args) {
        Ejemplo2 ejemplo2 = new Ejemplo2(); // Instanciamos metodos de la clase
        ejemplo2.cargar();
        ejemplo2.imprimir();
    }
}
