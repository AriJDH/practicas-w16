package reservas.repository;

import reservas.Cliente;
import reservas.Localizador;
import reservas.TipoDeReservas;

import java.util.List;

public class LocalizadorRepository {
    public Localizador creaLocalizador(String nombre, String dni, List<TipoDeReservas> reservas, double monto){
        Cliente cli = new Cliente();
        Localizador localizadorCliente = new Localizador();
        double descuento;
       // if(cli.getDni().equals(dni)){

        if(reservas.size() == 4) {
            localizadorCliente = new Localizador(new Cliente(nombre, dni), reservas, monto);
            descuento = localizadorCliente.paqueteCompleto();
            System.out.println("El cliente:  " + nombre + " adquirió un paquete completo por: " + localizadorCliente.getTotalReserva() + " por lo que se descuenta un 10%. El total de su factura es de : " + descuento);
        } else  if(reservas.size() == 2) {
            localizadorCliente = new Localizador(new Cliente(nombre, dni), reservas, monto);
            descuento = localizadorCliente.reservasDosiguales();
            System.out.println("El cliente:  " + nombre + " adquirió un paquete de 2 reservas iguales por: " + localizadorCliente.getTotalReserva() + " por lo que se descuenta un 5%. El total de su factura es de : " + descuento);
        }
       /* }else{//busco el cliente
            System.out.println("falta buscar cliente");
            localizadorCliente= new Localizador(new Cliente(nombre,dni),reservas,monto);
        }*/


      return localizadorCliente;
    }

}
