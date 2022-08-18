package Entity;

import Repository.RepositoryClient;
import Repository.RepositoryLocator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RepositoryClient repositoryClient = new RepositoryClient();
        RepositoryLocator repositoryLocator = new RepositoryLocator();

        Client client = new Client("Anggy", "Arguello", "1073525066");
        Client client1 = new Client("Arvey", "Murcia", "1073527896");

        repositoryClient.addClientes(client);
        repositoryClient.addClientes(client1);

        //10%

        List<Booking> booking10 = new ArrayList<>();

        Food bookingFood = new Food(100.0);
        Hotel BookingHotel = new Hotel(100.0);
        Transportation BookingTransportation = new Transportation(100.0);
        Trip BookingTrips = new Trip(100.0);
        booking10.add(bookingFood);
        booking10.add(BookingHotel);
        booking10.add(BookingTransportation);
        booking10.add(BookingTrips);
        Locator locator = new Locator(booking10);
        double total = repositoryLocator.customerHistory(client.getDni()) * locator.costBooking();
        System.out.println("El costo total es: " + total);
        repositoryLocator.addLocator(client.getDni(), locator, total);

        //5%

        List<Booking> booking5 = new ArrayList<>();
        Hotel bookingHotel5_1 = new Hotel(300.0);
        Hotel bookingHotel5_2 = new Hotel(300.0);
        booking5.add(bookingHotel5_1);
        booking5.add(bookingHotel5_2);
        Locator locator5 = new Locator(booking5);
        double total5 = repositoryLocator.customerHistory(client.getDni()) * locator5.costBooking();
        System.out.println("Costo Total es: " + total5);
        repositoryLocator.addLocator(client.getDni(), locator5, total5);

        //2 reservas

        List<Booking> booking2 = new ArrayList<>();
        Food bookingComida2_1 = new Food(100.0);
        Trip bookingTrip2_1 = new Trip(100.0);
        booking2.add(bookingComida2_1);
        booking2.add(bookingTrip2_1);
        Locator locator2 = new Locator(booking2);
        double totsl2 = repositoryLocator.customerHistory(client.getDni()) * locator2.costBooking();
        System.out.println("El costo total es: " + totsl2);
        repositoryLocator.addLocator(client.getDni(), locator2, totsl2);

        //Optional
        Locator locator4 = new Locator(booking2);
        double total4 = repositoryLocator.customerHistory(client1.getDni()) * locator2.costBooking();
        System.out.println("El costo total es: " + total4);
        repositoryLocator.addLocator(client1.getDni(), locator4, total4);

        System.out.println("Cantidad de Localizadores vendidos: "+ repositoryLocator.amountLocators());
        System.out.println("Cantidad de Reservas vendidas: "+ repositoryLocator.amountBokings());
        System.out.println("Total de ventas: "+ repositoryLocator.getTotal());
        System.out.println("Promedio de ventas: "+ repositoryLocator.getTotal()/repositoryLocator.amountBokings());
    }
}
