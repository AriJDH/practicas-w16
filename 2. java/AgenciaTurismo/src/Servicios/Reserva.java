package Servicios;

public abstract class Reserva {
    String numReserva;
    int costo;

    public Reserva(String numReserva, int costo) {
        this.numReserva = numReserva;
        this.costo = costo;
    }

    public String getNumReserva() {
        return numReserva;
    }

    public void setNumReserva(String numReserva) {
        this.numReserva = numReserva;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String mostrarDatos(){
        return "Número de Reserva: " + this.getNumReserva() + "\n"
                + "Costo: " + this.getCosto();
    }
}
