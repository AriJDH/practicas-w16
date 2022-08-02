package supermercadoElEconomico;

import supermercadoElEconomico.domain.Cliente;
import supermercadoElEconomico.domain.Factura;
import supermercadoElEconomico.domain.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("232023", "Pedro", "Vazquez");
        Cliente cliente2 = new Cliente("455326", "Ricardito", "Mocked");
        Cliente cliente3 = new Cliente("234324", "Sofia", "Perez");
        List <Factura> facturas = new ArrayList<>():
        List<Cliente> clientes = new ArrayList<>();

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.forEach(cliente -> System.out.println(cliente));

        clientes.remove(cliente1);
        clientes.forEach(cliente -> System.out.println(cliente));

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Ingrese el dni de un cliente");
//        String dniBuscado = scanner.nextLine();
//
//        Optional<Cliente> posibleMatch = buscarCliente(dniBuscado,clientes)
//
//        if (posibleMatch.isPresent())
//            System.out.println(posibleMatch.get());
//        else
//            System.out.println("Cliente no encontrado");

        List<Item> items = new ArrayList<>();
        items.add(new Item(22,"Queso",1,200));
        items.add(new Item(2542,"fideos",3,50));

        Factura factura1 = new Factura(cliente1,items,350);

        if(buscarCliente(factura1.getCliente()).isPresent()) {
            facturas.add(factura1);
            System.out.println("Factura agregada");
        }else
            System.out.println("No existe el cliente");


    }

    public static Optional<Cliente> buscarCliente(String dni, List<Cliente> clientes ) {
        return clientes
                .stream()
                .filter(elem -> elem.getDni().equalsIgnoreCase(dniBuscado))
                .findAny();
    }
}
