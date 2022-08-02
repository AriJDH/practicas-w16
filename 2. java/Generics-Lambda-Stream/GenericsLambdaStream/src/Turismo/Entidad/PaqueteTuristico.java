package Turismo.Entidad;

public class PaqueteTuristico {

    private boolean comida;
    private boolean boletosDeViajes;
    private boolean transporte;
    private boolean hotel;
    private double costo;

    public PaqueteTuristico(boolean comida, boolean boletosDeViajes, boolean transporte, boolean hotel,double costo) {
        this.comida = comida;
        this.boletosDeViajes = boletosDeViajes;
        this.transporte = transporte;
        this.hotel = hotel;
        this.costo = costo;
    }

    public boolean isComida() {
        return comida;
    }

    public void setComida(boolean comida) {
        this.comida = comida;
    }

    public boolean isBoletosDeViajes() {
        return boletosDeViajes;
    }

    public void setBoletosDeViajes(boolean boletosDeViajes) {
        this.boletosDeViajes = boletosDeViajes;
    }

    public boolean isTransporte() {
        return transporte;
    }

    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }

    public boolean isHotel() {
        return hotel;
    }

    public void setHotel(boolean hotel) {
        this.hotel = hotel;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
