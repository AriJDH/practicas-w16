package Servicios;

public class ReservaBoletos extends Reserva {
    private String numVuelo;
    private String destino;

    public ReservaBoletos(String numReserva, int costo, String numVuelo, String destino) {
        super(numReserva, costo);
        this.numVuelo = numVuelo;
        this.destino = destino;
    }

    public String getNumVuelo() {
        return numVuelo;
    }

    public void setNumVuelo(String numVuelo) {
        this.numVuelo = numVuelo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public String mostrarDatos() {
        return "***** Reserva de Boletos *****" + "\n"
                + super.mostrarDatos() + "\n"
                + "Número de vuelo: " + this.getNumVuelo() + "\n"
                + "Destino: " + this.getDestino() + "\n";
    }
}
