package agencia_turismo;

import agencia_turismo.repositorios.LocalizadorRepo;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

   public Double calcularTotal(Localizador localizador){

      Double precio= localizador.getReservas().stream().mapToDouble(value -> value.precio).sum();

      var listaLocalizadoresCliente = LocalizadorRepo.getLocalizadoresByCliente(localizador.getCliente().getDni());

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

   public boolean poseeTodasLasReservas(List<Reserva> reservas){
      return  reservas.stream().map(Reserva::getClass).collect(Collectors.toSet()).size() == 4;
   }

   public boolean poseeDosReservaHotelODosBoletosViaje(List<Reserva> reservas){
      boolean hayDosBoletosViaje = reservas.stream().filter(reserva -> reserva.getClass() == BoletoViaje.class).collect(Collectors.toList()).size() >= 2;
      boolean hayReservasHoteles = reservas.stream().filter(reserva -> reserva.getClass() == Hotel.class).collect(Collectors.toList()).size() >= 2;

      return hayDosBoletosViaje || hayReservasHoteles;
   }

   public int cantidadLocalizadoresVendidos(){
       return LocalizadorRepo.getAll().size();
   }

   public double cantidadTotalReservas(){
      return LocalizadorRepo.getAll().stream()
              .map(localizador -> localizador.getReservas().size())
              .mapToDouble(Integer::doubleValue).sum();
   }

   public void diccionarioTodasLasReservas(){

       System.out.println("--Diccionario de reservas---");
       System.out.println("<<Boletos de Viaje>>");
       Reserva.diccionarioReservaPorTipo(BoletoViaje.class.getSimpleName());
       System.out.println("");
       System.out.println("<<Reservas de Comida>>");
       Reserva.diccionarioReservaPorTipo(Comida.class.getSimpleName());
       System.out.println("");
       System.out.println("<<Reservas de Hotel>>");
       Reserva.diccionarioReservaPorTipo(Hotel.class.getSimpleName());
       System.out.println("");
       System.out.println("<<Reservas de Transporte>>");
       Reserva.diccionarioReservaPorTipo(Transporte.class.getSimpleName());
   }

   public double totalVentas(){
     return  LocalizadorRepo.getAll().stream()
             .mapToDouble(Localizador::getPrecio)
             .sum();
   }

    public double promedioDeVentas(){
        return LocalizadorRepo.getAll().stream()
                .mapToDouble(Localizador::getPrecio)
                .average().getAsDouble();
    }

    public static void main(String[] args) {

       Main main = new Main();

       Cliente cliente1 = new Cliente("123456", "Gabriela", "Mejia");
       Cliente cliente2 = new Cliente("09876", "Pepito", "Perez");
       Cliente cliente3 = new Cliente("35865", "Juan", "Perez");

        System.out.println("");
        System.out.println("----AGENCIA DE TURISMO----");

       List<Reserva> reservas = List.of(new BoletoViaje(2000.0), new Comida(1300.0), new Hotel(5000.0), new Transporte(7000.0) );
       Localizador localizadorCliente1 = new Localizador(cliente1, reservas);
       double total1 = main.calcularTotal(localizadorCliente1);
        System.out.println("El precio total del paquete con todos los descuentos es: " + total1);
        localizadorCliente1.setPrecio(total1);
       LocalizadorRepo.agregarLocalizador(localizadorCliente1);

        List<Reserva> reservasCliente2 = List.of( new Comida(1300.0), new Hotel(5000.0), new Transporte(8000.0) );
        Localizador localizadorCliente2 = new Localizador(cliente2, reservasCliente2);
        double total2 = main.calcularTotal(localizadorCliente2);
        System.out.println("El precio total del paquete sin descuentos es: " + total2);
        localizadorCliente2.setPrecio(total2);
        LocalizadorRepo.agregarLocalizador(localizadorCliente2);

        List<Reserva> reservasCliente3 = List.of( new BoletoViaje(1300.0), new BoletoViaje(5000.0), new Hotel(7000.0), new Hotel(5000.0) );
        Localizador localizadorCliente3 = new Localizador(cliente3, reservasCliente3);
        double total3 = main.calcularTotal(localizadorCliente3);
        localizadorCliente3.setPrecio(total3);
        LocalizadorRepo.agregarLocalizador(localizadorCliente3);
        System.out.println("El precio total con dos boletos y dos hoteles: " + total3);

        List<Reserva> reservascliente1_2 = List.of(new BoletoViaje(2000.0), new Comida(1300.0), new Hotel(5000.0), new Transporte(7000.0) );
        Localizador localizadorCliente1_2 = new Localizador(cliente1, reservascliente1_2);
        double total4 = main.calcularTotal(localizadorCliente1_2);
        System.out.println("El precio total con 3 localizadores: " + total4);
        localizadorCliente1_2.setPrecio(total4);
        LocalizadorRepo.agregarLocalizador(localizadorCliente1_2);

        List<Reserva> reservascliente1_3 = List.of(new BoletoViaje(2000.0), new Comida(1300.0), new Hotel(5000.0), new Transporte(7000.0) );
        Localizador localizadorCliente1_3 = new Localizador(cliente1, reservascliente1_3);
        double total5 = main.calcularTotal(localizadorCliente1_3);
        System.out.println("El precio total con 3 localizadores: " + total5);
        localizadorCliente1_3.setPrecio(total5);
        LocalizadorRepo.agregarLocalizador(localizadorCliente1_3);

        System.out.println("");
        System.out.println("Cantidad localizadores vendidos: "+ main.cantidadLocalizadoresVendidos() + " localizadores");

        System.out.println("");
        System.out.println("Cantidad de reservas vendidas: "+ main.cantidadTotalReservas() + " reservas");

        System.out.println("");
        main.diccionarioTodasLasReservas();

        System.out.println("");
        System.out.println("Total ventas: " + main.totalVentas());

        System.out.println("");
        System.out.println("Promedio ventas: " + main.promedioDeVentas());



    }

}
