package EjercicioIntegrador2;

import EjercicioIntegrador2.Clases.GuardaRopa;
import EjercicioIntegrador2.Clases.Prenda;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int id=0;
        //Creacion de lista de prendas
        Prenda prenda = new Prenda("Nike", "Air Force one");
        Prenda prenda2 = new Prenda("Adidas", "Low");
        List<Prenda> listaPrenda = new ArrayList<>();
        listaPrenda.add(prenda);
        listaPrenda.add(prenda2);
        System.out.println("-----------------------------------------------------------------------------------------");

        //Guardar en MAP y mostrar en consola las prendas
        GuardaRopa guardaRopa = new GuardaRopa(listaPrenda);
        guardaRopa.guardarPrendas(listaPrenda);

        System.out.println("-----------------------------------------------------------------------------------------");

        //Limpio lista
        listaPrenda.clear();

        //Creacion de nueva lista
        Prenda prenda3 = new Prenda("Puma", "Maa");
        Prenda prenda4 = new Prenda("Lotto", "Tto");
        listaPrenda.add(prenda3);
        listaPrenda.add(prenda4);
        //Guardar en MAP y mostrar en consola las prendas
        guardaRopa.guardarPrendas(listaPrenda);

        System.out.println("-----------------------------------------------------------------------------------------");

        //Mostrar elementos guardados
        System.out.println("Elementos guardados: ");
        guardaRopa.getBodegaRopa().forEach((key, value) -> System.out.println("[Key] : " + key + " [Value] : " + value.toString()));
        System.out.println("-----------------------------------------------------------------------------------------");

        //Devolver prendas guardadas
        System.out.println("Ingrese el Id del listado de prendas que quiere retirar");
        Scanner entrada = new Scanner (System.in);
        id = entrada.nextInt();
        guardaRopa.retirarPrendas(id);
        System.out.println("-----------------------------------------------------------------------------------------");

        //Mostrar elementos guardados actualizados
        System.out.println("Elementos guardados actualizados: ");
        guardaRopa.getBodegaRopa().forEach((key, value) -> System.out.println("[Key] : " + key + " [Value] : " + value.toString()));
        System.out.println("-----------------------------------------------------------------------------------------");

        //consultar sobre prendas guardadas
        System.out.println("Ingrese el Id del listado de prendas que quiere consultar");
        id = entrada.nextInt();
        guardaRopa.consultarListado(id);
        System.out.println("-----------------------------------------------------------------------------------------");




    }
}
