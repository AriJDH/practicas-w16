package EjercicioSupermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static EjercicioSupermercado.ClienteRepository clienteRepo = new EjercicioSupermercado.ClienteRepository();
    public static List<Factura> facturas = new ArrayList<>();

    public static void main(String[] args) {

        /*Parte 1*/
        /*
        System.out.println("Crear 3 cliente y mostrar sus datos");
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("49867865", "German", "Rodriguez"));
        clientes.add(new Cliente("48347501", "Romina", "Garcia"));
        clientes.add(new Cliente("49876543", "Oliver", "Rodriguez"));
        clientes.forEach(System.out::println);

        System.out.println("Eliminar uno y mostrar datos de los demas");
        clientes.remove(clientes.size() - 1);
        clientes.forEach(System.out::println);

        System.out.println("Ingresar un CI, si esta muestro sus datos:");
        Scanner teclado = new Scanner(System.in);
        String ci = teclado.nextLine();

        boolean found = false;
        int i = 0;
        do{
            if(clientes.get(i).getCi().equals(ci)){
                System.out.println(clientes.get(i).toString());
                found = true;
            }
            i++;
        } while (!found && i < clientes.size());

        if (!found)
            System.out.println("No se encontro el cliente");
        */
        /*End Parte 1*/

        /*Parte 2*/

        clienteRepo.addCliente(new Cliente("49867865", "German", "Rodriguez"));
        clienteRepo.addCliente(new Cliente("48347501", "Romina", "Garcia"));
        clienteRepo.addCliente(new Cliente("49876543", "Oliver", "Rodriguez"));

        mainMenu();
    }

    public static void mainMenu(){
        Scanner teclado = new Scanner(System.in);
        int menuSeleccionado;

        System.out.println("------------------------------------------------------");
        System.out.println("Seleccione una opcion");
        System.out.println("------------------------------------------------------");
        System.out.println("1: Nueva factura");
        System.out.println("2: Ver facturas");
        System.out.println("3: Nuevo cliente");
        System.out.println("4: Editar cliente");
        System.out.println("5: Eliminar cliente");
        System.out.println("------------------------------------------------------");
        menuSeleccionado = teclado.nextInt();

        switch(menuSeleccionado){
            case 1:
                nuevaFactura();
                break;
            case 2:
                verFacturas();
                break;
            case 3:
                nuevoCliente();
                break;
            case 4:
                editarCliente();
                break;
            case 5:
                eliminarCliente();
        }
    }

    public static void backToMainMenu(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Presione ENTER tecla para volver al menu.");
        System.out.println("------------------------------------------------------");
        teclado.nextLine();
        mainMenu();
    }

    public static void nuevaFactura(){
        System.out.println("------------------------------------------------------");
        System.out.println("NUEVA FACTURA");
        System.out.println("------------------------------------------------------");

        Cliente c = ingresarCliente();
        List<Item> items = ingresarItems();
        double total = getTotal(items);

        Factura f = new Factura(c, items, total);
        facturas.add(f);

        System.out.println("Factura creada correctamente.");

        backToMainMenu();
    }

    public static void verFacturas(){
        for(Factura f:facturas){
            System.out.println(f.toString());
        }
        backToMainMenu();
    }

    private static Cliente ingresarCliente(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el documento:");
        String cli_doc = teclado.nextLine();

        Cliente cli  = clienteRepo.get(cli_doc);
        if(cli != null){
            System.out.println("Cliente encontrado en el sistema.");
            return cli;
        }
        else{
            System.out.println("Ingrese nombre:");
            String cli_nom = teclado.nextLine();
            System.out.println("Ingrese apellido:");
            String cli_ape = teclado.nextLine();

            Cliente cli_new = new Cliente(cli_doc, cli_nom, cli_ape);
            clienteRepo.create(cli_new);

            return cli_new;
        }
    }

    private static void editarCliente(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el documento:");
        String cli_doc = teclado.nextLine();

        Cliente cli  = clienteRepo.get(cli_doc);
        if(cli != null){
            System.out.println("Cliente encontrado en el sistema.");
            System.out.println("Que dato desea editar?");
            System.out.println("1- Nombre");
            System.out.println("2- Apellido");
            int menu = teclado.nextInt();
            String dato = "";

            Scanner teclado2 = new Scanner(System.in);
            if(menu == 1){
                System.out.println("Ingrese nombre:");
                dato = teclado2.nextLine();
                cli.setNombre(dato);
            }
            if(menu == 2){
                System.out.println("Ingrese apellido:");
                dato = teclado2.nextLine();
                cli.setApellido(dato);
            }
            clienteRepo.update(cli);
        }
        else{
            System.out.println("No se encontro el cliente en el sistema");
        }

        backToMainMenu();
    }

    private static void nuevoCliente(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el documento:");
        String cli_doc = teclado.nextLine();

        Cliente cli  = clienteRepo.get(cli_doc);
        if(cli != null){
            System.out.println("Ya existe un cliente con ese documento.");
        }
        else{
            System.out.println("Ingrese nombre:");
            String cli_nom = teclado.nextLine();
            System.out.println("Ingrese apellido:");
            String cli_ape = teclado.nextLine();

            Cliente cli_new = new Cliente(cli_doc, cli_nom, cli_ape);
            clienteRepo.create(cli_new);

            System.out.println("Cliente creado correctamente");
        }
        backToMainMenu();
    }

    private static void eliminarCliente(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el documento:");
        String cli_doc = teclado.nextLine();

        Cliente cli  = clienteRepo.get(cli_doc);
        if(cli != null){
            clienteRepo.remove(cli_doc);
        }
        else{
            System.out.println("No existe un cliente con ese documento.");
        }
        backToMainMenu();
    }

    private static List<Item> ingresarItems(){

        List<Item> items = new ArrayList<>();
        nuevoItem(items);

        return items;
    }

    private static void nuevoItem(List<Item> items) {
        System.out.println("NUEVO ITEM");

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el codigo:");
        String item_code = teclado.nextLine();

        System.out.println("Ingrese el nombre:");
        String item_nom = teclado.nextLine();

        System.out.println("Ingrese cantidad:");
        int item_cant = teclado.nextInt();

        System.out.println("Ingrese costo unitario:");
        double item_cost = teclado.nextDouble();

        Item item = new Item(item_code, item_nom, item_cant, item_cost);
        items.add(item);

        Scanner teclado2 = new Scanner(System.in);
        System.out.println("Item agregado correctamente. Desea agregar otro item? (s = si, pulse otra tecla para continuar.)");
        String respuesta = teclado2.nextLine();

        if(respuesta.equals("s"))
            nuevoItem(items);
    }

    private static double getTotal(List<Item> items) {
        double total = 0;
        for (Item i:items){
            total += i.getCosto() * i.getCantidad();
        }
        return total;
    }
}
