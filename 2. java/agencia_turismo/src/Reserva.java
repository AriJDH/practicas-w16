public class Reserva {

    private boolean comida;
    private boolean hotel;
    private boolean viajes;
    private boolean transporte;

    private double monto;

    public Reserva(boolean comida, boolean hotel, boolean viajes, boolean transporte, double monto) {
        this.comida = comida;
        this.hotel = hotel;
        this.viajes = viajes;
        this.transporte = transporte;
        this.monto = monto;
    }

    public boolean paqueteCompleto()
    {
        return this.comida&&this.hotel&&this.transporte&&this.viajes;
    }

    public boolean isComida() {
        return comida;
    }

    public boolean isHotel() {
        return hotel;
    }

    public boolean isViajes() {
        return viajes;
    }

    public boolean isTransporte() {
        return transporte;
    }

    public double getMonto() {
        return monto;

    }

}
