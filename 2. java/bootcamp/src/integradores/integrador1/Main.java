package integradores.integrador1;

import java.util.*;

public class Main {

    private static RepoClientes clientes;

    public static void main(String[] args) {
        int opcion = -1;
        Scanner teclado = new Scanner(System.in);

        clientes = new RepoClientes();

        Cliente cliente1 = new Cliente("12345", "Sofia", "Petrides");
        clientes.add(cliente1);
        Cliente cliente2 = new Cliente("67890", "Juan", "Perez");
        clientes.add(cliente2);
        Cliente cliente3 = new Cliente("24680", "Martin", "Gomez");
        clientes.add(cliente3);

        do{
            System.out.println("Menu Principal. Por favor, digite la opción que desee : \n 1: Agregar Cliente \n " +
                    "2: Mostrar Clientes \n 3: Eliminar Cliente \n 4: Agregar Factura \n 5: Mostrar Facturas \n " +
                    "6: Eliminar Factura \n 7: Salir" );

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    agregarCliente();
                    break;
               /* case 2:
                    mostrarParticipantes();
                    break;
                case 3:
                    eliminarParticipante();
                    break;
                case 4:
                    obtenerMonto();
                    break;*/
            }
        }while (opcion != 5);

        teclado.close();


        /*

        clientes.values().stream().forEach(System.out::println);

        System.out.println("Elimino Cliente: ");
        clientes.remove("24680");

        clientes.values().stream().forEach(System.out::println);


        System.out.println("Ingrese número de DNI: ");
        Scanner teclado = new Scanner(System.in);

        String dni = teclado.nextLine();
        teclado.close();

        if (clientes.containsKey(dni))
            System.out.println(clientes.get(dni));
        else
            System.out.println("El cliente no existe");
        */

    }

    private static void agregarCliente(){
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese DNI del cliente: ");
        String dni = teclado.nextLine();

        System.out.println("Ingrese Nombre del cliente: ");
        String nombre = teclado.nextLine();

        System.out.println("Ingrese apellido del cliente : ");
        String apellido = teclado.nextLine();

        Cliente cliente = new Cliente(dni, nombre, apellido);
        clientes.add(cliente);
    }
}
