package estructuras;

import java.util.Scanner;

public class Ejemplo1 {

    private static final int INCENTIVO = 10000;
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ejercicio1();
        ejercicio2();
        ejercicio3();

        sc.close();
    }

    private static void ejercicio1() {
        int ventas = 21000;
        int objetivo = 20000;

        if (ventas > objetivo) {
            System.out.println("Cantidad de ventas satisfactoria, su comision es de: $" + INCENTIVO);
        } else {
            System.out.println("No llego a objetivo");
        }
        System.out.println("Fin ejercicio 1");
    }

    private static void ejercicio2() {
        int num1, num2, num3;
        System.out.println("Ingrese primer numero: ");
        num1 = sc.nextInt();
        System.out.println("Ingrese segundo numero: ");
        num2 = sc.nextInt();
        System.out.println("Ingrese tercer numero: ");
        num3 = sc.nextInt();

        if (num1 > num2 && num1 > num3) {
            System.out.println("El numero " + num1 + " es el mayor");
        } else if (num2 > num1 && num2 > num3) {
            System.out.println("El numero " + num2 + " es el mayor");
        } else {
            System.out.println("El numero " + num3 + " es el mayor");
        }

        System.out.println("Fin ejercicio 2");
    }

    private static void ejercicio3() {
        int dia;
        System.out.println("Ingrese un dia: ");
        dia = sc.nextInt();

        String diaString;

        switch (dia) {
            case 1:
                diaString = "Domingo";
                break;
            case 2:
                diaString = "Lunes";
                break;
            case 3:
                diaString = "Martes";
                break;
            case 4:
                diaString = "Miercoles";
                break;
            case 5:
                diaString = "Jueves";
                break;
            case 6:
                diaString = "Viernes";
                break;
            case 7:
                diaString = "Sabado";
                break;
            default:
                diaString = "Dia invalido";
                break;
        }
        System.out.println(diaString);
        System.out.println("Fin ejercicio 3");
    }
}
