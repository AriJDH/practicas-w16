package supermercado;

import supermercado.repositorios.ClienteRepositorio;
import supermercado.repositorios.FacturaRepositorio;

import java.time.LocalDate;
import java.util.*;

public class Main {

    ClienteRepositorio cr = new ClienteRepositorio();
    FacturaRepositorio fr = new FacturaRepositorio();
    public void mostrarTodosClientes(){
        cr.getTodos().forEach(cliente ->System.out.println("\n" +cliente));
    }

    public void agregarFactura(Factura factura){
        if(validarCliente(factura.getCliente())){
            factura.setTotalCompra(calcularTotalFactura(factura.getItems()));
            fr.crear(factura);
        }else {
            cr.crear(factura.getCliente());
        }
    }

    public void mostrarTodasFacturas(){
        fr.getTodos().forEach(System.out::println);
    }

    public double calcularTotalFactura(Collection<Item> items){
      return items.stream().mapToDouble(value -> value.getCantidad()*value.getCostoUnitario()).sum();
    }

    public boolean validarCliente(Cliente cliente){

        var x = cr.getTodos();

        return x.contains(cliente);

    }

    public static void main(String[] args) {
        ClienteRepositorio cr = new ClienteRepositorio();
        FacturaRepositorio fr = new FacturaRepositorio();


        Main main = new Main();

        Cliente cliente1 = new Cliente("123456", "Gabriela", "Mejia");
        cr.crear(cliente1);

        Cliente cliente2 = new Cliente("19834873", "Guille", "Marcano");
        cr.crear(cliente2);

        Cliente cliente3 = new Cliente("834293", "Nico", "Mejia");
        cr.crear(cliente3);

        System.out.println("---Clientes registrados---");
        main.mostrarTodosClientes();

        System.out.println("");
        System.out.println("Eliminar cliente");
        String dni = "123456";
        cr.eliminar(dni);
        System.out.println("Cliente con dni: "+dni);
        main.mostrarTodosClientes();

        System.out.println("");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese dni del cliente a consultar");
        String dniConsultar = sc.nextLine();

        try{
            Cliente clienteAConsultar = (Cliente) cr.get(dniConsultar);
            System.out.println(clienteAConsultar);
        }catch (NoSuchElementException e){
            System.out.println("Cliente no existente");
        }

        System.out.println("");
        System.out.println("--Factura agregada correctamente---");

        Factura factura1 = new Factura();
        factura1.setCliente(cliente2);
        factura1.setId("243434");
        factura1.setItems(
                List.of(
                        new Item(23423, "Carne",2, 1500.0 ),
                        new Item(23232, "Papa", 3, 200.0)));

        main.agregarFactura(factura1);

        System.out.println("");
        System.out.println("--Mostrar todas las facturas---");
        main.mostrarTodasFacturas();
    }
}
