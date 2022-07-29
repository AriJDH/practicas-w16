package agenciaDeTurismo;

import agenciaDeTurismo.dominio.Cliente;
import agenciaDeTurismo.dominio.Comida;
import agenciaDeTurismo.dominio.Hotel;
import agenciaDeTurismo.dominio.Localizador;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("Javi","Gomez");
        Localizador localizador1 = new Localizador(cliente);
        localizador1.agregarReserva(new Comida(250));
        localizador1.agregarReserva(new Hotel(3));


    }
}
