package EjercicioIntegrador1;

import EjercicioIntegrador1.Model.Cliente;
import EjercicioIntegrador1.Model.Item;
import EjercicioIntegrador1.Repository.ClienteImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ClienteImp cliImp = new ClienteImp();
        //Creamos 3 clientes
        Cliente cli1 = new Cliente(1232324l, "Gabriel", "Morales");
        Cliente cli2 = new Cliente(1223274l, "Felipe", "Morales");
        Cliente cli3 = new Cliente(4567888l, "Charles", "Morales");
        //Agregamos clientes a una collection
        cliImp.save(cli1);
        cliImp.save(cli2);
        cliImp.save(cli3);

        //Mostrar clientes ingresados
        cliImp.mostrarPantalla();

        //Buscar Cliente en particular
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni de la persona a buscar");
        Long dniBuscado = teclado.nextLong();
        cliImp.buscar(dniBuscado);

        //Borrar cliente
        Scanner teclado1 = new Scanner(System.in);
        System.out.println("Ingrese el dni de la persona a eliminar");
        Long dniBorrado = teclado1.nextLong();
        cliImp.eliminar(dniBorrado);

        //Lista actualizada
        System.out.println("Lista actualizada de clientes");
        cliImp.traerTodos();





    }
}
