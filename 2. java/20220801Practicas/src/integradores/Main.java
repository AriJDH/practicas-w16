package integradores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Prenda p1 = new Prenda("Nike", "Remera");
        Prenda p2 = new Prenda("Adidas", "Short");

        List<Prenda> lista =  new ArrayList<>(Arrays.asList(p1,p2));

        GuardaRopa armario = new GuardaRopa();

        int id = armario.guardarPrendas(lista);
        System.out.println("Guarde prendas con ID: " + id);
        System.out.println("Muestro Guardaropas");
        armario.mostrarPrendas();
        System.out.println("Elimino prenda");
        System.out.println(armario.devolverPrendas(id));
        System.out.println("Muestro Guardaropas2");
        armario.mostrarPrendas();

    }

}
