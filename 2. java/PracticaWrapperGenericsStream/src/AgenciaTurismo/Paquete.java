package AgenciaTurismo;

public class Paquete {
    private boolean reservaHotel;
    private boolean comida;
    private boolean boletos;
    private boolean transporte;

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

    public boolean isBoletos() {
        return boletos;
    }

    public void setBoletos(boolean boletos) {
        this.boletos = boletos;
    }

    public boolean isTransporte() {
        return transporte;
    }

    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }

    public Paquete(boolean reservaHotel, boolean comida, boolean boletos, boolean transporte) {
        this.reservaHotel = reservaHotel;
        this.comida = comida;
        this.boletos = boletos;
        this.transporte = transporte;
    }

    public boolean esCompleto(){
        return this.boletos && this.comida && this.reservaHotel && this.transporte;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "reservaHotel=" + reservaHotel +
                ", comida=" + comida +
                ", boletos=" + boletos +
                ", transporte=" + transporte +
                '}';
    }
}
