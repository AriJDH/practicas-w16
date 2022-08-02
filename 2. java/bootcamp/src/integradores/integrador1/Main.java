package integradores.integrador1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int opcion;
        Scanner teclado = new Scanner(System.in);

        Supermercado supermercado = new Supermercado();

        supermercado.agregarCliente("12345", "Sofia", "Petrides");
        supermercado.agregarCliente("67890", "Juan", "Perez");
        supermercado.agregarCliente("24680", "Martin", "Gomez");

        do{
            System.out.println("Menu Principal. Por favor, digite la opción que desee : \n 1: Agregar Cliente \n " +
                    "2: Mostrar Clientes \n 3: Eliminar Cliente \n 4: Mostrar Cliente  \n 5: Agregar Factura \n " +
                    "6: Mostrar Facturas \n 7: Eliminar Factura \n 8: Salir" );

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    agregarCliente(supermercado);
                    break;
               case 2:
                    supermercado.mostrarClientes();
                    break;
                case 3:
                    eliminarCliente(supermercado);
                    break;
                case 4:
                   mostrarCliente(supermercado);
                    break;
                case 5:
                    mostrarCliente(supermercado);
                    break;
            }
        }while (opcion != 8);

        teclado.close();


        /*

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

    private static void agregarCliente(Supermercado supermercado){
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese DNI del cliente: ");
        String dni = teclado.nextLine();

        System.out.println("Ingrese Nombre del cliente: ");
        String nombre = teclado.nextLine();

        System.out.println("Ingrese apellido del cliente : ");
        String apellido = teclado.nextLine();

        teclado.close();

       supermercado.agregarCliente(dni, nombre, apellido);
    }


    private static void eliminarCliente(Supermercado supermercado) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese DNI del cliente a eliminar: ");
        String dni = teclado.nextLine();

        teclado.close();

        supermercado.eliminarCliente(dni);
    }

    private static void mostrarCliente(Supermercado supermercado) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese DNI del cliente a consultar: ");
        String dni = teclado.nextLine();

        teclado.close();

        supermercado.mostrarCliente(dni);
    }


    private static void agregarFactura(Supermercado supermercado){
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese DNI del cliente asociado a la factura: ");
        String dni = teclado.nextLine();

        if (!supermercado.existeCliente(dni)) {
            System.out.println("Ingrese Nombre del cliente: ");
            String nombre = teclado.nextLine();

            System.out.println("Ingrese apellido del cliente : ");
            String apellido = teclado.nextLine();

            supermercado.agregarCliente(dni, nombre, apellido);
        }

        Cliente cliente = supermercado.mostrarCliente(dni);

        List<Item> items = new ArrayList<>();
        int opcion;
        do {
            System.out.println("1- Ingresar item \n 2-Finalizar Facturacion");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    Item item = agregarItem();
                    items.add(item);
                    break;
                case 2:
                    break;
            }
        }
        while (opcion !=2);

        Factura factura = new Factura(cliente, items);
        supermercado.agregarFactura(factura);

        System.out.println("El total de la factura es = " + factura.getTotal());

    }


    private static Item agregarItem(){
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese código del item: ");
        String codigo = teclado.nextLine();

        System.out.println("Ingrese nombre del item: ");
        String nombre = teclado.nextLine();

        System.out.println("Ingrese precio del item: ");
        double precio = teclado.nextDouble();

        System.out.println("Ingrese cantidad comprada del item: ");
        int cant = teclado.nextInt();

        teclado.close();

        return new Item(codigo, nombre, cant, precio);
    }
}
