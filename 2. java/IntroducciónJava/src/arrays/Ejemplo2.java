package arrays;

import java.util.Scanner;

public class Ejemplo2 {
    public static void main(String[] args) {
    //dado un numero que ingresa por consola verificar si es par o impar

        int number;
        System.out.println("Ingrese un número: ");

        //Scanner, clase para ingresar datos por consola y si o si le paso System.in
        Scanner dataEntry = new Scanner(System.in);

        number = dataEntry.nextInt();
        //si no uso mas el ingreso de datos buena practica cerrarlo
        dataEntry.close();

        if (number % 2 == 0){
           System.out.println("El número "+ number + " es par");
        }
        else{
            System.out.println("El número "+ number + " es impar");
        }

    }
}
