package arrays;

import java.util.Scanner;

public class Ejemplo4 {
    public static void main(String[] args) {
    //de acuerdo al numero que ingresa es el día que se devuelve

        int number;
        System.out.println("Ingresá un numero del 1 al 7 y te diré a qué día corresponde");
        Scanner numberEntry = new Scanner(System.in);

        number = numberEntry.nextInt();

        numberEntry.close();

        switch(number){
            case 1: System.out.println("Es día Domingo");
            break;
            case 2: System.out.println("Es día Lunes");
                break;
            case 3: System.out.println("Es día Martes");
                break;
            case 4: System.out.println("Es día Miércoles");
                break;
            case 5: System.out.println("Es día Jueves");
                break;
            case 6: System.out.println("Es día Viernes");
                break;
            case 7: System.out.println("Es día Sábado");
                break;
            default: System.out.println("No válido");
        }

        //otra forma

        int dia;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese un número válido para el día de la semana");
        dia = teclado.nextInt();
        teclado.close();

        String diaString;

        switch (dia){
            case 1: diaString = "Es día Domingo";
                break;
            case 2: diaString = "Es día Lunes";
                break;
            case 3: diaString = "Es día Martes";
                break;
            case 4: diaString = "Es día Miércoles";
                break;
            case 5: diaString = "Es día Jueves";
                break;
            case 6: diaString = "Es día Viernes";
                break;
            case 7: diaString = "Es día Sábado";
                break;
            default: diaString = "No válido";
        }
        System.out.println(diaString);

    }
}

//LOS DOS CODIGOS => ERROR CONSULTAR
