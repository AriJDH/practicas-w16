package practica.ejerciciosintegradores;

public class PaqueteTuristico {

    protected boolean reservaHotel;
    protected boolean comida;
    protected boolean boletosViaje;
    protected boolean transporte;

    public PaqueteTuristico(boolean reservaHotel, boolean comida, boolean boletosViaje, boolean transporte) {
        this.reservaHotel = reservaHotel;
        this.comida = comida;
        this.boletosViaje = boletosViaje;
        this.transporte = transporte;
    }

    public boolean isReservaHotel() {
        return reservaHotel;
    }

    public void setReservaHotel(boolean reservaHotel) {
        this.reservaHotel = reservaHotel;
    }

    public boolean isComida() {
        return comida;
    }

    public void setComida(boolean comida) {
        this.comida = comida;
    }

    public boolean isBoletosViaje() {
        return boletosViaje;
    }

    public void setBoletosViaje(boolean boletosViaje) {
        this.boletosViaje = boletosViaje;
    }

    public boolean isTransporte() {
        return transporte;
    }

    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }

    public boolean esPaqueteCompleto() {
        return this.isReservaHotel()
                && this.isComida()
                && this.isBoletosViaje()
                && this.isTransporte();
    }

    @Override
    public String toString() {
        return "PaqueteTuristico{" +
                "reservaHotel=" + reservaHotel +
                ", comida=" + comida +
                ", boletosViaje=" + boletosViaje +
                ", transporte=" + transporte +
                '}';
    }
}
