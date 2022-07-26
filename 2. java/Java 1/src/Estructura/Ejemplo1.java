package Estructura;

import java.util.Scanner;

public class Ejemplo1 {
    static final int INCENTIVO = 1000;
    public static void main(String[] args) {
        int numeroUno, numeroDos;

            Scanner teclado = new Scanner(System.in);
            System.out.println("Ingrese primer valor");
            numeroUno = Integer.parseInt(teclado.nextLine());
            System.out.println("Ingrese segundo valor");
            numeroDos = Integer.parseInt(teclado.nextLine());
        while(numeroDos < numeroUno)
        {
            System.out.println("ERROR: el " + numeroDos + " es mayor que "+ numeroUno);
            System.out.println("Ingrese el segundo valor");
            numeroDos = Integer.parseInt(teclado.nextLine());
        }


    }
    public void validacionVenta()
    {
        int ventas = 20000;
        int objetivo = 20000;

        if(ventas > objetivo) {
            System.out.println("Satisfactoria "+ INCENTIVO);
        }else{
            System.out.println("No llego a objetivo");
        }
    }
    public void numeroPar()
    {
        int numero = 0;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese un número: ");
        numero = teclado.nextInt();
        teclado.close();
        if(numero%2== 0) {
            System.out.println("El número es par");
        }else {
            System.out.println("El número es impar");
        }

    }
    public void numeroMayor()
    {
        int numUno, numDos, numTres;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese un número: ");
        numUno =  teclado.nextInt();
        System.out.println("Ingrese un número: ");
        numDos =  teclado.nextInt();
        System.out.println("Ingrese un número: ");
        numTres =  teclado.nextInt();
        teclado.close();

        if(numUno> numDos && numUno > numTres){
            System.out.println(numUno + " Es mayor");
        }else if(numDos > numTres){
            System.out.println(numDos + " Es mayor");
        }else{
            System.out.println(numTres + " Es mayor");
        }
    }
    public void diaSemana()
    {
        int dia;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese un nro. valido para el día de la semana");
        dia = teclado.nextInt();
        teclado.close();
        String diaSemana;
        switch (dia)
        {
            case  1:
                diaSemana = "Lunes";
                break;
            case  2:
                diaSemana = "Martes";
                break;
            case  3:
                diaSemana = "Miercoles";
                break;
            case  4:
                diaSemana = " Jueves";
                break;
            case  5:
                diaSemana = "Viernes";
                break;
            case  6:
                diaSemana = "Sábado";
                break;
            case  7:
                diaSemana = "Domingo";
                break;
            default:
                diaSemana = "No es un día valido";
                break;
        }
        System.out.println("El día de la semana seleccionado: "+ diaSemana);
    }
}
