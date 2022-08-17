import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Parte I: crear 3 clientes
        Cliente cliente1 = new Cliente("1","Yenny","Chipamo");
        Cliente cliente2 = new Cliente("2","Mario","Lopéz");
        Cliente cliente3 = new Cliente("3","Nelson","Mar");

        //guardarlos en una colección
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        //Recorrer y mostrar por pantalla
        System.out.println("Lista de Clientes");
        for(Cliente listClientes : clientes){
            System.out.println(listClientes);
        }

        //Eliminar un cliente
        clientes.remove(1);

        //volver a imprimir los clientes
        System.out.println("\nLista de Clientes");
        for(Cliente listClientes : clientes){
            System.out.println(listClientes);
        }

        Scanner sc= new Scanner(System.in);
        System.out.println("\nIngrese DNI del cliente a buscar: ");
        String dniBuscar = sc.nextLine();

        //Buscar y mostrar por pantalla

        boolean control = false;

        for(Cliente listClientes : clientes){
            if(listClientes.getDni().equals(dniBuscar)) {
                System.out.println("\nCliente Encontrado:");
                System.out.println(listClientes);
                control=true;
            }
        }

        if(!control)
            System.out.println("\nCliente no Encontrado.");

    }
}
