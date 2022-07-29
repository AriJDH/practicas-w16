package agenciaDeTurismo;

import agenciaDeTurismo.dominio.*;
import agenciaDeTurismo.repositorios.RepoLocalizador;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("Javi","Gomez");
        RepoLocalizador repo = new RepoLocalizador();

        Localizador localizadorFullDescuentos = new Localizador(cliente);
        localizadorFullDescuentos.agregarReserva(new Comida("foodtruck",10));
        localizadorFullDescuentos.agregarReserva(new Hotel("Holayday inn", 10));
        localizadorFullDescuentos.agregarReserva(new BoletosDeViaje("Aerolineas", 10));
        localizadorFullDescuentos.agregarReserva(new BoletosDeTransporte("Taxis", 10));

        repo.agregarLocalizador(localizadorFullDescuentos);

        Localizador localizadorDescuento2 = new Localizador(cliente);
        localizadorDescuento2.agregarReserva(new BoletosDeViaje("Aerolineas", 10));
        localizadorDescuento2.agregarReserva(new BoletosDeViaje("Aerolineas", 10));
        localizadorFullDescuentos.agregarReserva(new BoletosDeViaje("Aerolineas", 10));
        localizadorFullDescuentos.agregarReserva(new BoletosDeViaje("Aerolineas", 10));


        repo.agregarLocalizador(localizadorDescuento2);

        Localizador localizadorSimple = new Localizador(cliente);
        localizadorSimple.agregarReserva(new Hotel("Aerolineas", 100));



        repo.agregarLocalizador(localizadorSimple);
    }
}
