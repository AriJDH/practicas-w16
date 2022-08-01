package save_the_ropa;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        GuardaRopa guardaRopa = new GuardaRopa();
        Scanner sc = new Scanner(System.in);

        Prenda prenda = new Prenda("Zara", "Pantalon");
        Prenda prenda2 = new Prenda("H&M", "Top");

        List<Prenda> prendaList = List.of(prenda, prenda2);

        System.out.println("Ropa guardada...");
        System.out.println("El codigo del guardaropa es: "+ guardaRopa.guardarPrendas(prendaList));

        System.out.println("");
        System.out.println("-------------------------------");
        System.out.println("Ingrese el codigo del guardaropa a consultar: ");
        int codigo = sc.nextInt();

        System.out.println("");
        System.out.println("Prendas del guardaropa con código: " + codigo);
        guardaRopa.devolverPrendas(codigo).forEach(System.out::println);

        System.out.println("");
        System.out.println("-------------------------------");
        System.out.println("Toda la ropa del guardaRopa");
        guardaRopa.mostrarPrendas();


        ///
        System.out.println("");
        System.out.println("-------------------------------");

        Prenda prenda3 = new Prenda("Stradivarius", "Zapatos");
        Prenda prenda4 = new Prenda("Mango", "Falda");

        List<Prenda> prendaList2 = List.of(prenda3, prenda4);

        System.out.println("Ropa guardada...");
        System.out.println("El codigo del guardaropa es: "+ guardaRopa.guardarPrendas(prendaList2));


        System.out.println("");
        System.out.println("-------------------------------");
        System.out.println("Toda la ropa del guardaRopa");
        guardaRopa.mostrarPrendas();


    }
}
