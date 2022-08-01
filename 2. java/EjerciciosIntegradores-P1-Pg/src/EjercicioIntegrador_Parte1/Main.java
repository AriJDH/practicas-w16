package EjercicioIntegrador_Parte1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String,Cliente> listaClientes = new HashMap<String,Cliente>();

        listaClientes.put("1234", new Cliente("juan","1234","perez"));
        listaClientes.put( "4567",new Cliente("Martin","4567","gonzales"));
        listaClientes.put( "8910",new Cliente("Carla","8910","Rodriguez"));

        System.out.println("recorrido y printeo de la lista de clientes");
        listaClientes.forEach((x,y)-> System.out.println(y));

        System.out.println("eliminacion de uno y printeo");
        listaClientes.remove("4567");
        listaClientes.forEach((x,y)-> System.out.println(y));

        System.out.println("ingrese el dni de el que desea buscar");
        Scanner sc = new Scanner(System.in);
        String dni = sc.next();

        if(listaClientes.containsKey(dni)){
            System.out.println("la informacion del clientes es:");
            System.out.println(listaClientes.get(dni));
        }else{
            System.out.println("ese cliente no esta ingresado");
        }

    }
}
