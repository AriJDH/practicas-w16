import models.Cliente;
import repositorios.Clientes;

import java.util.Scanner;

public class Main {
    private static Clientes clientes = new Clientes();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("PARTE I");
        clientes.agregarCliente(new Cliente("Erika", "Altenburger", "35573387"));
        clientes.agregarCliente(new Cliente("Jessica", "Alexa", "37566555"));
        clientes.agregarCliente(new Cliente("Alicia", "Castro", "18549323"));

        System.out.println("1 - Mostrar clientes por pantalla");
        System.out.println(clientes.getListClientes().toString());

        int suboption = -1;
        while (suboption!=0){
            menu();
            suboption = scanner.nextInt();
            while (suboption==1){
                subMenuClientes();
                int suboptionCliente = -1;
                suboptionCliente = scanner.nextInt();
                if (suboptionCliente == 3){
                    suboption=-1;
                }
                while (suboptionCliente ==1){
                    System.out.println("Ingrese DNI a borrar");
                    String dni = scanner.next();
                    boolean rdo=clientes.eliminarCliente(dni);
                    if (rdo){
                        System.out.println("El cliente fue boorado exitosamente");
                        System.out.println(clientes.getListClientes().toString());
                        suboptionCliente = -1;
                    }else {
                        System.out.println("El cliente no fue encontrado");
                        suboptionCliente = -1;
                    }
                }
                while (suboptionCliente ==2){
                    System.out.println("Ingrese DNI a buscar");
                    String dni = scanner.next();
                    Cliente cliente = clientes.mostrarCliente(dni);
                    if (cliente != null){
                        System.out.println(cliente.toString());
                        suboptionCliente = -1;
                    }else {
                        System.out.println("Cliente no encontrado");
                        suboptionCliente = -1;
                    }
                }
            }
        }
    }
    public static void menu(){
        System.out.println("1 - Clientes");
        System.out.println("0 - Salir");
    }

    public static void subMenuClientes(){
        System.out.println("1 - Borrar cliente");
        System.out.println("2 - Mostrar cliente por dni");
        System.out.println("3 - Salir");
    }

}
