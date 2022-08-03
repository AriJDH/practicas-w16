import Repository.ClienteImp;
import model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClienteImp cliImp = new ClienteImp();
        Cliente cliente1 = new Cliente("39828356", "Sabrina", "Silvero");
        Cliente cliente2 = new Cliente("39828456", "Sofia", "Tallera");
        Cliente cliente3 = new Cliente("39848356", "Camila", "DiIelsi");
        //List<Cliente> listaDeClientes = new ArrayList<>();
       /* listaDeClientes.add(cliente1);
        listaDeClientes.add(cliente2);
        listaDeClientes.add(cliente3);
        */
        cliImp.save(cliente1); //guardar un cliente

        cliImp.mostrarPantalla();

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni de la persona a eliminar: ");
        String dniABorrar = teclado.next();

        boolean bandera = false;
        for (Cliente c : listaDeClientes){
            if(c.getDni() == dniABorrar){
                listaDeClientes.remove(c);
                bandera = true;
                break;
            }
        }
        if (bandera == false){
            System.out.println("No se encontro el cliente a borrar");
        }else {
            System.out.println("Cliente borrado");
        }


    }
}
