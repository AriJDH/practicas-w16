package estructuras;

import java.util.Scanner;

public class Ejemplo4 {

    public static void main(String[] args) {
        int dia;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese un Nro. válido para el día de la semana: ");
        dia = entrada.nextInt();
        entrada.close();
        String diaString;

        switch (dia) {
            case 1:
                diaString = "Lunes";
                break;
            case 2:
                diaString = "Martes";
                break;
            case 3:
                diaString = "Miércoles";
                break;
            case 4:
                diaString = "Jueves";
                break;
            case 5:
                diaString = "Viernes";
                break;
            case 6:
                diaString = "Sábado";
                break;
            case 7:
                diaString = "Domingo";
                break;
            default:
                diaString = "Día no válido";
                break;
        }
        System.out.println(diaString + ".");
    }

}
