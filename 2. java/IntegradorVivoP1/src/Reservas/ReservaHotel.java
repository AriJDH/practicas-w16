package Reservas;

public class ReservaHotel implements ReservaInter{

    @Override
    public void hacerReservaOk() {
        System.out.println("Reserva de Hotel Exitosa");
    }

    @Override
    public void hacerReservaNoOk() {
        System.out.println("Error Reservando Hotel!");
    }
}
