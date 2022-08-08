package ejerciciosIntegradores.elEconomico;

import ejerciciosIntegradores.elEconomico.model.Cliente;
import ejerciciosIntegradores.elEconomico.repository.ClienteImp;
import ejerciciosIntegradores.elEconomico.repository.FacturaImp;
import ejerciciosIntegradores.elEconomico.repository.ItemImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ClienteImp cliImp = new ClienteImp();
        FacturaImp factImp = new FacturaImp();
        ItemImp itImp = new ItemImp();

        //creamos 3 clientes
        Cliente cli1 = new Cliente(12365458L, "Luisina", "de Paula");
        Cliente cli2 = new Cliente(65987456L, "Zlatan", "Ibrahimovic");
        Cliente cli3 = new Cliente(11254789L, "Avril", "Lavigne");

        cliImp.save(cli1); //guardar un cliente
        cliImp.mostrarPantalla(); //mostrando todos los clientes

        //búsqueda del cliente
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni a buscar");
        Long dniBuscado = teclado.nextLong();
        cliImp.buscar(dniBuscado);

        //borrado del cliente
        System.out.println("Ingrese el dni a buscar para eliminar");
        Long dniBorrado = teclado.nextLong();
        cliImp.eliminar(dniBorrado);





    }
}
