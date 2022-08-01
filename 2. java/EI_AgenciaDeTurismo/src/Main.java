import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Repositorio repositorio = new Repositorio();
        Cliente cliente = new Cliente("Jorge", "Montevideo", 189388);

        Reserva hotel = new Hotel(100d);
        Reserva comida = new Comida(300d);
        Reserva viaje = new BoletoViaje(100d);
        Reserva transporte = new Transporte(1200d);

        List<Reserva> reservas = new ArrayList<>();
        reservas.add(hotel);
        reservas.add(comida);
        reservas.add(viaje);
        reservas.add(transporte);

        Localizador localizador = new Localizador(reservas, cliente);

        repositorio.guardarLocalizador(localizador);
        System.out.println("Parte1: " + repositorio.obtenerLocalizadores());

        reservas = new ArrayList<>();
        reservas.add(hotel);
        reservas.add(hotel);
        reservas.add(viaje);
        reservas.add(viaje);
        Localizador localizador2 = new Localizador(reservas, cliente);

        repositorio.guardarLocalizador(localizador2);
        System.out.println("Parte2: " + repositorio.obtenerLocalizadores());

        reservas = new ArrayList<>();
        reservas.add(transporte);
        Localizador localizador3 = new Localizador(reservas, cliente);

        repositorio.guardarLocalizador(localizador3);
        System.out.println("Parte3: " + repositorio.obtenerLocalizadores());

    }
}
