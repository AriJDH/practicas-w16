package arrays;

import java.util.Scanner;

public class Ejemplo5 {
    //el primer numero tiene que ser mayor que el segundo
    public static void main(String[] args) {
        Scanner entry = new Scanner(System.in);
        int num1, num2;

        System.out.println("Ingrese el primer número");
        num1 = Integer.parseInt(entry.nextLine()); //para asegurarme que sea un numero

        System.out.println("Ingrese el segundo número");
        num2 = Integer.parseInt(entry.nextLine());

        while(num1 >= num2){
            System.out.println("Bien!! El número " + num1 + " es mayor al " + num2);
            System.out.println("Ingrese el segundo número");
            num2 = Integer.parseInt(entry.nextLine());
        }
        entry.close();
        System.out.println("Fin del juego, el número debía ser menor");
    }
}

class Ejemplo5DoWhile{
    public static void main(String[] args) {
        Scanner entryData3 = new Scanner(System.in);
        int number1, number2;

        System.out.println("Ingrese el primer número");
        number1 = Integer.parseInt(entryData3.nextLine());

        do{
            System.out.println("Bien");
            System.out.println("Ingrese el segundo número");
            number2 = Integer.parseInt(entryData3.nextLine());

        }while (number2 <= number1);
        entryData3.close();
        System.out.println("Fin del juego, el segundo número debía ser menor al primero");
    }
}
