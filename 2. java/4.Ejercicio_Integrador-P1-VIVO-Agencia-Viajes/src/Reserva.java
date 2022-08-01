public class Reserva {
    private Comida comida;
    private Hotel hotel;
    private BoletosViajes boletoViaje;
    private Transporte transporte;
    private double monto;

    public Reserva() {
    }

    public Reserva(Hotel hotel) {
        this.hotel = hotel;
    }

    public Reserva(Hotel hotel, BoletosViajes boletoViaje) {
        this.hotel = hotel;
        this.boletoViaje = boletoViaje;
    }

    public Reserva(Comida comida, Hotel hotel, BoletosViajes boletoViaje, Transporte transporte) {
        this.comida = comida;
        this.hotel = hotel;
        this.boletoViaje = boletoViaje;
        this.transporte = transporte;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public BoletosViajes getBoletoViaje() {
        return boletoViaje;
    }

    public void setBoletoViaje(BoletosViajes boletoViaje) {
        this.boletoViaje = boletoViaje;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

//    public boolean paqueteCompleto(){
//        return this.comida &&
//                this.hotel &&
//                this.transporte &&
//                this.boletoViaje;
//    }

    @Override
    public String toString() {
        return "** reserva: \n" +
                "comida= " + comida + "\n" +
                "hotel= " + hotel + "\n" +
                "transporte= " + transporte + "\n" +
                "viaje= " + boletoViaje + "\n" +
                "monto= " + monto + "\n";
    }

    public void costoTotalReservaCalculadora() {
        double total = 0;
        if(comida != null) {
            total = total + comida.getCosto();
        }

        if (hotel != null){
            total = total + hotel.getCosto();
        }

        if (boletoViaje != null){
            total = total + boletoViaje.getCosto();
        }

        if (transporte != null){
            total = total + transporte.getCosto();
        }

        this.monto = total;
    }
}

