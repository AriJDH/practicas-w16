import Reservas.Hotel;
import Reservas.Comida;
import Reservas.Viajes;
import Reservas.Transporte;
import Reservas.Reserva;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Localizador> localizadores = new ArrayList<>();


        Cliente cli = new Cliente(1,"Pedro Picapiedra");
        Cliente cli1 = new Cliente(2,"Jessica Rodriguez");
        Cliente cli2 = new Cliente(3,"Luis Perez");
        Cliente cli3 = new Cliente(4,"Lucas Fernandez");

        ArrayList<Cliente> clientes = new ArrayList<Cliente>(List.of(cli,cli1,cli2,cli3));
        Clientes listaClientes = new Clientes(clientes);

        //Primer Localizador - Caso 2
        Reserva res = new Hotel(500.0);
        Reserva res1 = new Comida(300.0);
        Reserva res2 = new Transporte(100.0);
        Reserva res3 = new Viajes(50.0);
        ArrayList<Reserva> reservas = new ArrayList<>(List.of(res,res1,res2,res3));
        Localizador loc = new Localizador(cli1,reservas);
        localizadores.add(loc);

        //
        //Segundo localizador - Caso 3
        Reserva res4 = new Hotel(800.0);
        Reserva res5 = new Hotel(800.0);
        Reserva res6 = new Viajes(100.0);
        Reserva res7 = new Viajes(100.0);
        ArrayList<Reserva> reservas2 = new ArrayList<>(List.of(res4,res5,res6,res7));
        Localizador loc1 = new Localizador(cli1,reservas2);
        loc1.CalcularPrecio();
        localizadores.add(loc1);
        //
        //Segundo localizador - Caso 1
        Reserva res8 = new Hotel(500.0);
        Reserva res9 = new Comida(300.0);
        Reserva res10 = new Transporte(100.0);
        Reserva res11 = new Viajes(50.0);
        ArrayList<Reserva> reservas3 = new ArrayList<>(List.of(res8,res9,res10,res11));
        Localizador loc2 = new Localizador(cli1,reservas3);
        localizadores.add(loc2);
        //

    }
}
