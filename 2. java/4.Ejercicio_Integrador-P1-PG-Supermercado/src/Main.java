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

        List<Cliente> listClients = new ArrayList<>();
        listClients.add(cliente1);
        listClients.add(cliente2);
        listClients.add(cliente3);

        listClients.stream().forEach(System.out::println);//referencia de metodos

        listClients.remove(cliente1);
        System.out.println("\nSe elimino un cliente de la lista: \n");
        listClients.stream().forEach(System.out::println);

        Scanner input = new Scanner(System.in);
        System.out.println("\nIngrese  el Dni del cliente que desea observar: ");
        String dniScanned = input.nextLine();
        //clientFinder(dniScanned, listClients);
        Cliente clientFound = listClients.stream().filter(x -> x.getDni().contains(dniScanned)).findFirst().orElse(null);//puede ser un cliente o un nulo
//        List<Cliente> clientFound = listClients.stream().filter(x -> x.getDni().contains(dniScanned)).collect(Collectors.toList());//el collect me permite almacenar el filtrado en una nueva lista
        if(clientFound != null){
            System.out.println("*****Cliente encontrado: \n" + clientFound);
        } else {
            System.out.println("Cliente No Registrado!! ");
        }

        input.close();
    }

//    public static Cliente clientFinder(String dniScanned, List<Cliente> listClients){
//        listClients.stream().filter(x -> x.getDni() == dniScanned).forEach(System.out::println);
//    }
}

