package estructuras;

import java.util.Scanner;

public class Ejemplo4 {
    public static void main(String[] args) {
        int num1,num2;
        Scanner teclado=new Scanner(System.in);
        System.out.println("Ingrese el primer valor ");
        num1=Integer.parseInt(teclado.nextLine());
        System.out.println("Ingrese el segundo valor ");
        num2=Integer.parseInt(teclado.nextLine());
        while ( num2 <= num1 ){
            System.out.println("error: el "+num2+"es mayor que "+num1);
            System.out.println("ingrese el segundo valor");
            num2 =Integer.parseInt(teclado.nextLine());
        }
        System.out.println("sali del ciclo");
        teclado.close();

    }
}
