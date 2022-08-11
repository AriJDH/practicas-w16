package integrador.supermercado;

import integrador.supermercado.models.Cliente;
import integrador.supermercado.models.DetalleFactura;
import integrador.supermercado.models.Factura;
import integrador.supermercado.models.Item;
import integrador.supermercado.repository.ClienteRepository;
import integrador.supermercado.repository.DetalleFacturaRepository;
import integrador.supermercado.repository.FacturaRepository;
import integrador.supermercado.repository.ItemRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private ClienteRepository clienteRepository;
    private ItemRepository itemRepository;
    private FacturaRepository facturaRepository;
    private DetalleFacturaRepository detalleFacturaRepository;
    private Scanner sc;

    public Main() {
        this.clienteRepository = ClienteRepository.getInstance();
        this.itemRepository = ItemRepository.getInstance();
        this.facturaRepository = FacturaRepository.getInstance();
        this.detalleFacturaRepository = DetalleFacturaRepository.getInstance();
        this.sc = new Scanner(System.in);
    }

    public int leerSeleccion(){
        int seleccion;
        seleccion = sc.nextInt();
        sc.nextLine();
        return seleccion;
    }

    public int seleccionInvalida(int min, int max){
        System.out.printf("Seleccione una opción valida [%s - %s]:\n", min, max);
        int seleccion = leerSeleccion();
        return seleccion;
    }

    private Integer mostrarOpciones(List<?> opciones, Boolean mostrarVolver){
        int cantidadElementos = opciones.size();

        for (int i = 0; i < opciones.size(); i++) System.out.printf("%s. %s.\n", i+1, opciones.get(i));
        if(mostrarVolver) System.out.printf("%s. Para salir.\n", cantidadElementos + 1);

        int seleccion = leerSeleccion();
        while (
                (mostrarVolver && seleccion > cantidadElementos + 1) ||
                        (!mostrarVolver && seleccion > cantidadElementos) && seleccion < 1
        ){
            seleccion = seleccionInvalida(1, mostrarVolver ? cantidadElementos + 1 : cantidadElementos);
        }
        return seleccion - 1;
    }

    public DetalleFactura agregarItemFactura(Factura factura){
        List<Item> items = this.itemRepository.getAll();
        System.out.println("Seleccione un item para continuar:");
        Item item = items.get(mostrarOpciones(items, Boolean.FALSE));
        System.out.println("Introduzca la cantidad para el item seleccionado:");
        int cantidad = leerSeleccion();

        return this.detalleFacturaRepository.save(new DetalleFactura(item, cantidad, factura));
    }

    public boolean menuAgregarItem(){
        System.out.println("¿Desea agregar un item?");
        System.out.println("1. Sí.");
        System.out.println("2. No.");

        Integer seleccion = leerSeleccion();
        while(seleccion<1 || seleccion>2) seleccion = seleccionInvalida(1,2);
        if(seleccion.equals(1)) return true;
        return false;
    }

    public boolean menuPrincipal(){
        System.out.println("Seleccione una opción:");
        System.out.println("1. Crear factura.");
        System.out.println("2. Listar clientes.");
        System.out.println("3. Listar facturas.");
        System.out.println("4. Salir.");
        Integer seleccion = this.leerSeleccion();
        while(seleccion<1 || seleccion>4) seleccion = seleccionInvalida(1,4);
        if(seleccion.equals(4)) return false;
        else if(seleccion.equals(1)) this.menuCrearFactura();
        else if(seleccion.equals(2)) this.menuListarClientes();
        else if(seleccion.equals(3)) this.menuListarFacturas();
        return true;
    }

    public void menuCrearFactura(){
        Factura factura = new Factura();
        this.facturaRepository.save(factura);

        while(this.menuAgregarItem()) {
            factura.agregarDetalleFactura(this.agregarItemFactura(factura));
        }
        factura.setCliente(this.menuBuscarCliente());
        System.out.println(factura);
    }

    public Cliente menuBuscarCliente(){
        System.out.println("Ingrese el DNI del cliente para agregarlo a la factura:");
        String documento = sc.nextLine();
        Optional<Cliente> cliente = this.clienteRepository.findOne(documento);
        if(cliente.isPresent()) return cliente.get();
        return this.menuCrearCliente(documento);
    }

    public Cliente menuCrearCliente(String documento){
        System.out.printf("Crear cliente para el DNI %s:\n", documento);
        Cliente cliente = new Cliente();
        cliente.setDni(documento);
        System.out.println("Ingrese el nombre:");
        cliente.setNombre(sc.nextLine());
        System.out.println("Ingrese el apellido:");
        cliente.setApellido(sc.nextLine());

        this.clienteRepository.save(cliente);
        return cliente;
    }

    public void menuListarClientes(){
        System.out.println("Clientes registrados:");
        this.clienteRepository.getAll().forEach(System.out::println);
    }

    public void menuListarFacturas(){
        System.out.println("Facturas registradas:");
        this.facturaRepository.getAll().forEach(System.out::println);
    }

    public static void main(String[] args) {
        Main aplicacion = new Main();

        Cliente cliente1 = new Cliente("39613288", "Gianni", "Tiezzi");
        Cliente cliente2 = new Cliente("41001751", "Stéfano", "Tiezzi");
        Cliente cliente3 = new Cliente("42443404", "Giovanni", "Tiezzi");

        ClienteRepository clienteRepository = ClienteRepository.getInstance();

        clienteRepository.save(cliente1);
        clienteRepository.save(cliente2);
        clienteRepository.save(cliente3);

        System.out.println("CLIENTES:");
        clienteRepository.getAll().forEach(System.out::println);
        clienteRepository.delete("39613288");
        System.out.println("CLIENTES despues de borrar uno:");
        clienteRepository.getAll().forEach(System.out::println);

        System.out.println("Filtro cliente por documento 41001751:");
        System.out.println(clienteRepository.findOne("41001751").get());

        Item item1 = new Item("ABC123", "Puré de tomate", 10d);
        Item item2 = new Item("ABC122", "Papas fritas", 45d);
        Item item3 = new Item("ABC124", "Gaseosa", 100d);

        ItemRepository itemRepository = ItemRepository.getInstance();
        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);

        while(aplicacion.menuPrincipal()){}
    }
}
