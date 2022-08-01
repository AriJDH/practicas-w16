import java.util.ArrayList;

import clases.BoletoDeViaje;
import clases.Cliente;
import clases.Comida;
import clases.Hotel;
import clases.Localizador;
import clases.Repositorio;
import clases.Reservas;
import clases.Transporte;

public class AgenciaDeTurismo {

   public static void main(String[] args) {

      // Crear un nuevo repositorio
      Repositorio repositorio = new Repositorio();

      // Crear cliente nuevo
      Cliente alejandroRojas = new Cliente("Alejandro", "Rojas", 32250615);

      // Crear un paquete completo de reservas
      Hotel hotelEpic = new Hotel(100.0, "Hotel Epic");
      BoletoDeViaje boletoAvion = new BoletoDeViaje(50.0, "Boleto Avion Aerolineas Argentinas");
      Comida comidaEnRestaurant = new Comida(10.0, "Milanesa con papas fritas");
      Transporte taxi = new Transporte(5.0, "Taxi a criterio");

      // Crear un ArrayList para guardar las reservas
      ArrayList<Reservas> reservasAlejandroRojas = new ArrayList<>();

      // Agregar las reservas al ArrayList
      reservasAlejandroRojas.add(hotelEpic);
      reservasAlejandroRojas.add(boletoAvion);
      reservasAlejandroRojas.add(comidaEnRestaurant);
      reservasAlejandroRojas.add(taxi);

      // Crear un nuevo localizador con las reservas y el cliente
      Localizador localizadorAlejandroRojas = new Localizador(reservasAlejandroRojas, alejandroRojas);

      // Guardar el localizador en el repositorio
      repositorio.guardarLocalizador(localizadorAlejandroRojas);

      // Crear un localizador con dos hoteles y dos boletos
      Hotel hotelHowardJhonson = new Hotel(100.0, "Hotel Howard Jhonson");
      Hotel hotelSheraton = new Hotel(100.0, "Hotel Sheraton");
      BoletoDeViaje boletoAvion1 = new BoletoDeViaje(50.0, "Boleto Avion Aerolineas Argentinas");
      BoletoDeViaje boletoAvion2 = new BoletoDeViaje(50.0, "Boleto Avion Aerolineas Argentinas");

      // Crear un ArrayList para guardar reservas
      ArrayList<Reservas> reservasAlejandroRojas2 = new ArrayList<>();

      // Agregar las reservas al ArrayList
      reservasAlejandroRojas2.add(hotelHowardJhonson);
      reservasAlejandroRojas2.add(hotelSheraton);
      reservasAlejandroRojas2.add(boletoAvion1);
      reservasAlejandroRojas2.add(boletoAvion2);

      // Crear un nuevo localizador con las reservas y el cliente
      Localizador localizadorAlejandroRojas2 = new Localizador(reservasAlejandroRojas2, alejandroRojas);

      // Guardar el localizador en el repositorio
      repositorio.guardarLocalizador(localizadorAlejandroRojas2);

      // Crear un localizador con dos hoteles y dos boletos
      Hotel hotelElCondor = new Hotel(200.0, "Hotel El Condor");

      // Crear un ArrayList para guardar reservas
      ArrayList<Reservas> reservasAlejandroRojas3 = new ArrayList<>();

      // Agregar las reservas al ArrayList
      reservasAlejandroRojas3.add(hotelElCondor);

      // Crear un nuevo localizador con las reservas y el cliente
      Localizador localizadorAlejandroRojas3 = new Localizador(reservasAlejandroRojas3, alejandroRojas);

      // Guardar el localizador en el repositorio
      repositorio.guardarLocalizador(localizadorAlejandroRojas3);

   }
}
