package agenciaDeTurismo;

import agenciaDeTurismo.repositorio.RepositorioDeLocalizadores;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Ejercicio > Modulo 5: Java > EjerciciosIntegradores-P1-VIVO
 * ESTADO: Finalizado (falta revisión, emprolijar y unos puntos faciles).
 * @GonzaloNahuelDiPierro
 * */
public class Main {
   public static void main(String[] args) {
      Cliente cliente1 = new Cliente("123456", "Gabriela", "Mejia");
      Cliente cliente2 = new Cliente("09876", "Pepito", "Perez");
      Cliente cliente3 = new Cliente("35865", "Juan", "Perez");

      List<Reserva> reservas = List.of(new BoletoViaje(2000.0), new Comida(1300.0), new Hotel(5000.0), new Transporte(7000.0) );
      Localizador localizadorCliente1 = new Localizador(cliente1, reservas );
      RepositorioDeLocalizadores.agregarLocalizador(localizadorCliente1);

      System.out.println("El precio total del paquete con todos los descuentos es: " + calcularTotal(localizadorCliente1));

      System.out.println("");
      List<Reserva> reservasCliente2 = List.of( new Comida(1300.0), new Hotel(5000.0), new Transporte(7000.0) );
      Localizador localizadorCliente2 = new Localizador(cliente2, reservasCliente2);
      RepositorioDeLocalizadores.agregarLocalizador(localizadorCliente2);

      System.out.println("El precio total del paquete sin descuentos es: " + calcularTotal(localizadorCliente2));

      System.out.println("");
      List<Reserva> reservasCliente3 = List.of( new BoletoViaje(1300.0), new BoletoViaje(5000.0), new Hotel(7000.0), new Hotel(5000.0) );
      Localizador localizadorCliente3 = new Localizador(cliente3, reservasCliente3);
      RepositorioDeLocalizadores.agregarLocalizador(localizadorCliente3);
      System.out.println("El precio total con dos boletos y dos hoteles: " + calcularTotal(localizadorCliente3));

      System.out.println("");
      List<Reserva> reservascliente1_2 = List.of(new BoletoViaje(2000.0), new Comida(1300.0), new Hotel(5000.0), new Transporte(7000.0) );
      Localizador localizadorCliente1_2 = new Localizador(cliente1, reservascliente1_2);
      RepositorioDeLocalizadores.agregarLocalizador(localizadorCliente1_2);

      List<Reserva> reservascliente1_3 = List.of(new BoletoViaje(2000.0), new Comida(1300.0), new Hotel(5000.0), new Transporte(7000.0) );
      Localizador localizadorCliente1_3 = new Localizador(cliente1, reservascliente1_3);
      System.out.println("El precio total con 3 localizadores: " + calcularTotal(localizadorCliente1_3));
      RepositorioDeLocalizadores.agregarLocalizador(localizadorCliente1_3);

      System.out.println("");
      System.out.println("Cantidad localizadores vendidos: "+ cantidadLocalizadoresVendidos() + " localizadores");

      System.out.println("");
      System.out.println("Cantidad de reservas vendidas: "+ cantidadTotalReservas() + " reservas");
    }

   private static Double calcularTotal(Localizador localizador){
      Double precio= localizador.getReservas().stream().mapToDouble(value -> value.precio).sum();

      var listaLocalizadoresCliente = RepositorioDeLocalizadores.getLocalizadoresByCliente(localizador.getCliente().getDni());

      Double descuentoTotal = 0.0;

      if(listaLocalizadoresCliente.size() >=2){
        descuentoTotal += 0.05;
      }
      if(poseeTodasLasReservas(localizador.getReservas())){
          descuentoTotal += 0.10;
      }
      if(poseeDosReservaHotelODosBoletosViaje(localizador.getReservas())){
          descuentoTotal += 0.05;
      }

      return precio * (1-descuentoTotal);

   }

   private static boolean poseeTodasLasReservas(List<Reserva> reservas){
      return  reservas.stream().map(Reserva::getClass).collect(Collectors.toSet()).size() == 4;
   }

   private static boolean poseeDosReservaHotelODosBoletosViaje(List<Reserva> reservas){
      boolean hayDosBoletosViaje = reservas.stream().filter(reserva -> reserva.getClass() == BoletoViaje.class).collect(Collectors.toList()).size() >= 2;
      boolean hayReservasHoteles = reservas.stream().filter(reserva -> reserva.getClass() == Hotel.class).collect(Collectors.toList()).size() >= 2;

      return hayDosBoletosViaje || hayReservasHoteles;
   }

   private static int cantidadLocalizadoresVendidos(){
       return RepositorioDeLocalizadores.getAll().size();
   }

   private static double cantidadTotalReservas(){
      return RepositorioDeLocalizadores.getAll().stream().map(localizador -> localizador.getReservas().size()).mapToDouble(Integer::doubleValue).sum();
   }
}
