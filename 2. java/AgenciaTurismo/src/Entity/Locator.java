package Entity;

import java.util.List;
import java.util.stream.Collectors;

public class Locator {
    private List<Booking> bookings;

    public Locator(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public double costBooking(){
        double benefit = 1;
        double total= bookings.stream()
                .mapToDouble(Booking::getCost)
                .sum();

        boolean hotel = bookings.stream()
                .filter(booking -> booking.getClass() == Hotel.class)
                .collect(Collectors.toList()).size() >= 1;

        boolean food = bookings.stream()
                .filter(booking -> booking.getClass() == Food.class)
                .collect(Collectors.toList()).size() >= 1;

        boolean transportation = bookings.stream()
                .filter(booking -> booking.getClass() == Transportation.class)
                .collect(Collectors.toList()).size() >= 1;


        boolean trip = bookings.stream()
                .filter(bookings->bookings.getClass() == Trip.class)
                .collect(Collectors.toList()).size() >= 1;

        boolean tripTwo = bookings.stream()
                .filter(bookings->bookings.getClass() == Trip.class)
                .collect(Collectors.toList()).size() >= 2;

        boolean hotelTwo = bookings.stream()
                .filter(bookings->bookings.getClass() == Hotel.class)
                .collect(Collectors.toList()).size() >= 2;

        if(hotel && food && transportation && trip )
            benefit = 0.90;

        if (tripTwo || hotelTwo)
            benefit = 0.95;

        return total * benefit;
    }
}
