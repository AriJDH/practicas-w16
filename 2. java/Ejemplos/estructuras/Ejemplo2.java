package estructuras;

import java.util.Scanner;

public class Ejemplo2 {
    public static void main(String[] args) {

        int dia;
        String diaString;
        System.out.println("Ingrese un numero de dia valido");
        Scanner entrada = new Scanner (System.in);
        dia =entrada.nextInt();

        switch(dia){
            case 1: diaString ="Lunes";
            break;
            case 2: diaString ="Martes";
                break;
            case 3: diaString ="Miercoles";
                break;
            case 4: diaString ="Jueves";
                break;
            case 5: diaString ="Viernes";
                break;
            case 6: diaString ="Sabado";
                break;
            case 7: diaString ="Domingo";
                break;
            default: diaString="Dia no valido";
            break;
        }
        System.out.println(diaString);
    }
}
