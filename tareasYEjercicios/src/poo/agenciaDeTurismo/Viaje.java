package poo.agenciaDeTurismo;

public class Viaje implements Reservable {

    private String origen;
    private String destino;

    private int cantidadBoletos;
    private static final double PRECIO = 10000;

    public Viaje(String origen, String destino, int cantidadBoletos) {
        this.origen = origen;
        this.destino = destino;
        this.cantidadBoletos = cantidadBoletos;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    public void setCantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }

    @Override
    public void reservar() {
        System.out.println("Viaje a " + this.destino + " reservado ");
    }

    @Override
    public String tipoReserva() {
        return "VIAJE" ;
    }

    @Override
    public double getPrecio() {
        return PRECIO * cantidadBoletos;
    }

    @Override
    public String toString() {
        return "\nViaje: " +
                "Origen: " + origen +
                ", Destino: " + destino +
                ", Cantidad boletos: " + cantidadBoletos;
    }
}
