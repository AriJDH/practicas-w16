package bootcamp.supermecado;

import bootcamp.supermecado.entity.Cliente;
import bootcamp.supermecado.entity.Factura;
import bootcamp.supermecado.entity.Item;
import bootcamp.supermecado.repository.ClienteRepository;
import bootcamp.supermecado.repository.FacturaRepository;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

        ClienteRepository cr = new ClienteRepository();
        FacturaRepository fr = new FacturaRepository();

        public void mostrarTodosLosClientes(){
            cr.getTodos().forEach(System.out::println);
        }

        public void agregarFactura(Factura factura){
            if(validarCliente(factura.getCliente())){
                factura.setTotalCompra(calcularTotalFactura(factura.getItems()));
                fr.crear(factura);
            }else{
                cr.crear(factura.getCliente());
            }
        }

        public void mostraTodasFacturas(){
            fr.getTodos().forEach(System.out::println);
        }

        public Double calcularTotalFactura(Collection<Item> items){
            return items.stream().mapToDouble(x -> x.getCantidadComprada()*x.getCosotUnitario()).sum();
        }

        public Boolean validarCliente(Cliente cliente){

            var x = cr.getTodos();

            return  x.contains(cliente);

        }


    public static void main(String[] args) {
        ClienteRepository cr = new ClienteRepository();
        FacturaRepository fr = new FacturaRepository();

        Main main = new Main();

        Cliente cliente1 = new Cliente(21, "Gabriela", "Mejia");
        cr.crear(cliente1);

        Cliente cliente2 = new Cliente(1983487, "Guille", "Marcano");
        cr.crear(cliente2);

        Cliente cliente3 = new Cliente(8293, "Nico", "Mejia");
        cr.crear(cliente3);

        System.out.println("");
        System.out.println("Eliminar cliente");
        Integer dni = 21;
        cr.eliminar(dni);
        System.out.println("Cliente con dni: "+dni);
        main.mostrarTodosLosClientes();

        System.out.println("");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese dni del cliente a consultar");
        Integer dniConsultar = sc.nextInt();

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
        factura1.setId(243434);
        factura1.setItems(
                List.of(
                        new Item(23423, "Carne",2, 1500.0 ),
                        new Item(23232, "Papa", 3, 200.0)));

        main.agregarFactura(factura1);

        System.out.println("");
        System.out.println("--Mostrar todas las facturas---");
        main.mostraTodasFacturas();

    }
}
