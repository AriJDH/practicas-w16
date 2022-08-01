package EjerciciosIntegradores_Java.Ejercicio_Save_the_ropa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Prenda prenda1 = new Prenda("Levis", "Remera");
        Prenda prenda2 = new Prenda("Kevingston", "Pantalón");
        List<Prenda> listaPrendas = new ArrayList<>(List.of(prenda1, prenda2));

        GuardaRopa gr = new GuardaRopa();

        Integer num = gr.guardarPrendas(listaPrendas);

        System.out.println("Sus prendas fueron guardadas bajo el código: " + num);

        System.out.println("------------------");

        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el código que desea listar: ");
        Integer cod = scan.nextInt();

        System.out.println("------------------");

        System.out.println(gr.devolverPrendas(cod));

    }
}
