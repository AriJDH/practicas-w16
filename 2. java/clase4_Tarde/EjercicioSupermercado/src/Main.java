import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Integer,Cliente> baseDeDatos = new HashMap<>();
        Cliente cliente1 = new Cliente(1,"Cliente 1","Apellido 1");
        Cliente cliente2 = new Cliente(2,"Cliente 2","Apellido 2");
        Cliente cliente3 = new Cliente(3,"Cliente 3","Apellido 3");
        baseDeDatos.put(cliente1.getDni(),cliente1);
        baseDeDatos.put(cliente2.getDni(),cliente2);
        baseDeDatos.put(cliente3.getDni(),cliente3);
        System.out.println("Listando todos los clientes");
        baseDeDatos.forEach((x,y)-> System.out.println(y.toString()));
        System.out.println("Elimino Cliente 2");
        baseDeDatos.remove(cliente2.getDni());
        baseDeDatos.forEach((x,y)-> System.out.println(y.toString()));
        System.out.println("Ingrese el dni del Usuario a buscar");
        Scanner opt = new Scanner(System.in);
        int user = opt.nextInt();
        if (baseDeDatos.get(user)==null)
            System.out.println("El usuario no se encuentra en la base de datos");
        else
            System.out.println(baseDeDatos.get(user).toString());
    }
}
