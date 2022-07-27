package estructuras;

import java.util.Scanner;

public class Ejemplo3 {
    public static void main(String[] args) {
        int dia;

        Scanner teclado=new Scanner(System.in);
        System.out.println("ingrese un nro valido para el dia de la semana");
        dia=teclado.nextInt();
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
            default: diaString = "no se encontro el dia";
                break;
        }
        System.out.println(diaString);
    }
}
