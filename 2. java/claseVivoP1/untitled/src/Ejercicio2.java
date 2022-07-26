//package estructuras;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        int dia;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese un num. valido para el día de la semana.");
        dia = teclado.nextInt();
        String diaString;
        teclado.close();

        switch(dia){
            case 1:
                diaString="Lunes";
                break;
            case 2:
                diaString="Martes";
                break;
            case 3:
                diaString="Miercoles";
                break;
            case 4:
                diaString="Jueves";
                break;
            case 5:
                diaString="Viernes";
                break;
            case 6:
                diaString="Sábado";
                break;
            case 7:
                diaString="Domingo";
                break;
            default:
                diaString="[No Válido]";
        }

        System.out.println("El día ingresado es " + diaString);
    }
}
