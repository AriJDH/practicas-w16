package integradores.integrador1;

import java.util.*;

public class Main {

   private static Supermercado supermercado = new Supermercado();

    public static void main(String[] args) {
        int opcion;
        Scanner teclado = new Scanner(System.in);

        supermercado.agregarCliente(12345L, "Sofia", "Petrides");
        supermercado.agregarCliente(67890L, "Juan", "Perez");
        supermercado.agregarCliente(24680L, "Martin", "Gomez");

        do{
            System.out.println("Menu Principal. Por favor, digite la opción que desee : \n 1: Agregar Cliente \n " +
                    "2: Mostrar Clientes \n 3: Eliminar Cliente \n 4: Mostrar Cliente  \n 5: Agregar Factura \n " +
                    "6: Mostrar Facturas \n 7: Eliminar Factura \n 8: Salir" );

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    agregarCliente();
                    break;
               case 2:
                    supermercado.mostrarClientes();
                    break;
                case 3:
                    eliminarCliente();
                    break;
                case 4:
                   mostrarCliente();
                    break;
                case 5:
                    agregarFactura();
                    break;
                case 6:
                    supermercado.mostrarFacturas();
                    break;
                case 7:
                    eliminarFactura();
                    break;
                default:
                    break;
            }
        }while (opcion != 8);

        teclado.close();

    }

    private static void agregarCliente(){
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese DNI del cliente: ");
        Long dni = teclado.nextLong();

        System.out.println("Ingrese Nombre del cliente: ");
        String nombre = teclado.nextLine();

        System.out.println("Ingrese apellido del cliente : ");
        String apellido = teclado.nextLine();

        teclado.close();

       supermercado.agregarCliente(dni, nombre, apellido);
    }


    private static void eliminarCliente() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese DNI del cliente a eliminar: ");
        Long dni = teclado.nextLong();

        teclado.close();

        supermercado.eliminarCliente(dni);
    }

    private static void mostrarCliente() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese DNI del cliente a consultar: ");
        Long dni = teclado.nextLong();

        supermercado.mostrarCliente(dni);
    }


    private static void agregarFactura(){
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese DNI del cliente asociado a la factura: ");
        Long dni = teclado.nextLong();

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

        return new Item(codigo, nombre, cant, precio);
    }

    private static void eliminarFactura() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese id de factura a eliminar: ");
        Long id = teclado.nextLong();

        supermercado.eliminarFactura(id);
    }

}
