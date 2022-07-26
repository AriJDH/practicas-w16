package estructuras;

import java.util.Scanner;

public class Ejemplo1 {
    /*
    // Ejecicio 1

    static final int INCENTIVO = 10000; // Se define una constante

    public static void main(String[] args) { // Metodo principal donde se va a ejecutar el programa

        int ventas = 11000;
        int objetivo = 20000;

        if (ventas > objetivo){
            System.out.println("Satisfactoria: " + INCENTIVO);
        } else {
            System.out.println("No llego al objetivo");

        }

    }*/
    /*
    // Ejecicio 2
    public static void main(String[] args) {
        int numero;
        System.out.println("Ingrese un número: ");
        Scanner teclado = new Scanner(System.in); // Aca se instancia una clase con "new"
        numero = teclado.nextInt();
        teclado.close(); // En caso de tomar un ingreso de dato como Scanner, se recomienda cerrarlo

        if (numero%2 == 0){
            System.out.println("El numero es Par");
        } else{
            System.out.println("El numero es impar");
        }

    }*/
    /*
    // Ejecicio 3
    public static void main(String[] args) {
        int dia;
        System.out.println("Ingrese un numero de Dia");
        Scanner teclado = new Scanner(System.in);
        dia = teclado.nextInt();
        String diaString;
        teclado.close();

        switch (dia){
            case 1: diaString = "Lunes";
                    break;
            case 2: diaString = "Martes";
                break;
            case 3: diaString = "Miercoles";
                break;
            case 4: diaString = "Jueves";
                break;
            case 5: diaString = "Viernes";
                break;
            case 6: diaString = "Sabado";
                break;
            case 7: diaString = "Domingo";
                break;
            default: diaString = "Dia no valido";
                break;
        }
        System.out.println(diaString);
    }
    */
    /*
    //Ejecicio 4
    public static void main(String[] args) {
        int num1, num2;
        System.out.println("Ingrese valor de num1");
        Scanner teclado = new Scanner(System.in);
        num1 = Integer.parseInt(teclado.nextLine());
        System.out.println("Ingrese valo de num2");
        num2 = Integer.parseInt(teclado.nextLine());

        while (num2 < num1){
            System.out.println("Error: el " + num1 + " es mayor que " + num2);
            System.out.println("Ingrese valo de num2");
            num2 = Integer.parseInt(teclado.nextLine());
        }
        System.out.println("Sali del ciclo...");
        teclado.close();
    }
    */
}
