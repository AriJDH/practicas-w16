package JavaEjercicioIntegradoP1PG.IntegradorP1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SuperElEconomicop1 {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente(123456789, "Daniel", "Vicente");
        Cliente cliente2 = new Cliente(123456789, "Maria", "Marques");
        Cliente cliente3 = new Cliente(4321, "Ariel", "Garcia");

        Map<Integer, Cliente> clienteMap = new HashMap();

        clienteMap.put(clienteMap.size() + 1, cliente1);
        clienteMap.put(clienteMap.size() + 1, cliente2);
        clienteMap.put(clienteMap.size() + 1, cliente3);

        System.out.println("\n>Presentar Clientes");
        clienteMap.forEach((k, v) -> System.out.println("ID: " + k + " " + v));

        System.out.println("\n>Eliminar un Cliente : " + clienteMap.get(2));
        clienteMap.remove(2);
        clienteMap.forEach((k, v) -> System.out.println("ID: " + k + " " + v));

        Scanner sc = new Scanner(System.in);
        System.out.print("\n>Ingrese DNI de CLIENTE: ");
        int keyClientSc = sc.nextInt();

        boolean bandera = false;

        for (Map.Entry<Integer, Cliente> c : clienteMap.entrySet()) {
            if (c.getValue().getDni() == keyClientSc) {
                System.out.println("Cliente : " + c.getValue());
                bandera = true;
                break;
            }
        }
        if (bandera == false) {
            System.out.println("Cliente no Encontrado");
        }
    }
}
