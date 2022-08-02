import Repositorios.Cliente;
import Repositorios.Localizador;
import Repositorios.RepoLocalizador;
import Servicios.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Cliente
        Cliente cliente1 = new Cliente("1234567-8", "Dwayne Johnson", "01234896");

        //Localizador que incluye un paquete completo de servicios
        List<Reserva> paqueteCompleto = new ArrayList<>(Arrays.asList(
                new ReservaBoletos("4051", 2000000, "070", "Islas Canarias"),
                new ReservaComida("04598", 300000, "Clásico"),
                new ReservaDeHotel("64645", 350000, "Hotel California", "1003", 5),
                new ReservaTransporte("47465", 200000, "Taxi Centella")
        ));

        //Localizador que incluye dos reservas de hotel y dos reservas de viajes
        List<Reserva> paquete2 = new ArrayList<>(Arrays.asList(
                new ReservaDeHotel("23457", 400000, "Hotel Las Cruces", "2041", 10),
                new ReservaDeHotel("76598", 500000, "Hotel Ella y Él", "564", 15),
                new ReservaBoletos("0934", 1200000, "072", "Santa Catarina"),
                new ReservaBoletos("7640", 3499999, "074", "Santiago de Chile")
        ));

        //Localizador que incluye sólo una reserva
        List<Reserva> reserva3 = new ArrayList<>(Arrays.asList(
                new ReservaTransporte("89450", 440000, "Uber Smash")
                ));

        //Creación de Localizador que almacena el paquete completo de reservas
        Localizador localizador1 = new Localizador(cliente1, paqueteCompleto);
        System.out.println("LOCALIZADOR 1");
        System.out.println(localizador1.mostrarDatos());

        //Creación de Localizador que almacena dos reservas de hotel y dos reservas de viaje
        Localizador localizador2 = new Localizador(cliente1, paquete2);
        System.out.println();
        System.out.println("LOCALIZADOR 2");
        System.out.println(localizador2.mostrarDatos());

        //Creación de Localizador que almacena sólo una reserva
        Localizador localizador3 = new Localizador(cliente1, reserva3);

        //ArrayList de localizadores para este cliente
        List<Localizador> arrayLocalizadores = new ArrayList<>(Arrays.asList(
                localizador1,
                localizador2,
                localizador3
        ));

        //Repositorio donde se almacenan los tres Localizadores del cliente
        RepoLocalizador repoLocalizador = new RepoLocalizador(arrayLocalizadores);

        //Cálculo del futuro descuento a aplicar en una próxima compra del cliente
        System.out.println("El descuento para una futura compra de este cliente es: "
                + repoLocalizador.calcularFuturoDescuento());
    }
}
