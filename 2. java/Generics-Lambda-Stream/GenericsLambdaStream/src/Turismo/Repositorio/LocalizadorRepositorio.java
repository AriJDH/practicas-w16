package Turismo.Repositorio;

import Turismo.Entidad.Cliente;
import Turismo.Entidad.Localizador;
import Turismo.Entidad.PaqueteTuristico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LocalizadorRepositorio {

    private static int contadorLocalizador = 0;
    public static List<Localizador> listaLocalizadores ;

    public LocalizadorRepositorio() {
    }


    public static Localizador registrarDato(Scanner teclado) {

        ++contadorLocalizador;
        int idCliente;
        List<Integer> idsPaqueteTuristico = new ArrayList<>();
        System.out.println("Registrar una reserva");

        System.out.println("Digita el id del cliente");
        System.out.println("Digita el id del cliente");
        idCliente = teclado.nextInt();

        System.out.println("Digita el id del paquete turistico");
        int salir = 1;

        while (salir != 0){
            int id = teclado.nextInt();
            idsPaqueteTuristico.add(Integer.valueOf(id));

            System.out.println("Deseas inscribirte a otro paquete turistico?");
            System.out.println("1) Si.");
            System.out.println("0) No.");
            System.out.print("Respuesta :" );
            salir = teclado.nextInt();
        }


        Localizador localizador = new Localizador(contadorLocalizador,idCliente,idsPaqueteTuristico);
        listaLocalizadores.add(localizador);
        return localizador;
    }


    public void addToRepositorio() {

    }


    public List<Localizador> listRepositorio() {
        return null;
    }

    public boolean validarExistencia() {
        return false;
    }

    public boolean validarExistencia(int id) {
        return false;
    }
}
