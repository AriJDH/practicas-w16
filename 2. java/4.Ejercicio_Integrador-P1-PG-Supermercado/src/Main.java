import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("123", "Carla", "Polo");
        Cliente cliente2 = new Cliente("456", "Gera", "Duran");
        Cliente cliente3 = new Cliente("789", "Samuel", "Zapata");
        Cliente cliente4 = new Cliente("645", "Fabiola", "Ferreira");

        List<Cliente> listOfClients = new ArrayList<>();
        listOfClients.add(cliente1);
        listOfClients.add(cliente2);
        listOfClients.add(cliente3);
        listOfClients.add(cliente4);

        listOfClients.stream().forEach(System.out::println);//referencia de metodos

        listOfClients.remove(cliente1);
        System.out.println("\nSe elimino un cliente de la lista: \n");
        listOfClients.stream().forEach(System.out::println);

        Scanner input = new Scanner(System.in);
        System.out.println("\nIngrese  el Dni del cliente que desea observar: ");
        String dniScanned = input.nextLine();

        Cliente clientFound = listOfClients.stream().filter(x -> x.getDni().contains(dniScanned)).findFirst().orElse(null);

        if(clientFound != null){
            System.out.println("*****Cliente encontrado: \n" + clientFound);
        } else {
            System.out.println("Cliente No Registrado!! ");
        }

        Item arroz = new Item("001", "arroz", 2, 1.000);
        Item platano = new Item("002", "platano", 4, 600);
        Item harina = new Item("003", "harina", 3, 2.200);
        Item aceite = new Item("004", "aceite", 1, 1.800);

        List<Item> listOfItems = new ArrayList<>();
        listOfItems.add(arroz);
        listOfItems.add(platano);
        listOfItems.add(harina);
        listOfItems.add(aceite);

        double totalCostCalculate = totalCostCalculate(listOfItems);
        System.out.println("***********COSTO TOTAL: \n" + totalCostCalculate);

        Cliente clienteX = new Cliente("2222", "Fabio", "Ferreira");
        Factura factura001 = new Factura(83638282, clienteX, listOfItems, totalCostCalculate);
        List<Factura> listOfFactura = new ArrayList<>();

        Cliente existingClient = listOfClients.stream().filter(x -> x.getDni().contains(factura001.getClient().getDni())).findFirst().orElse(null);

        if(existingClient != null){
            System.out.println("Factura Agreagada a la lista: \n");
            listOfFactura.add(factura001);
        } else {
            System.out.println(factura001.getClient() + " ¡¡Este es un nuevo Cliente y sera agregado a la lista de clientes!!  \n");
            listOfClients.add(factura001.getClient());
        }
        listOfFactura.stream().forEach(System.out::println);
        input.close();
    }

    public static double totalCostCalculate(List<Item> listOfItems) {
        double resultado = 0;
        for (Item x : listOfItems){
            resultado = resultado + (x.getUnitCost() * x.getAmount());
        }
        return resultado;
    }

}

