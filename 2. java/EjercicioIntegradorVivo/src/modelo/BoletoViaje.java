package modelo;

public class BoletoViaje implements Reserva{
    private String ciudadOrigen;
    private String ciudadDestino;
    private int cantidadBoletos;
    private final double precio;

    public BoletoViaje(String ciudadOrigen, String ciudadDestino, int cantidadBoletos, double precio) {
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.cantidadBoletos = cantidadBoletos;
        this.precio = precio;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    public void setCantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "BoletoViaje{" +
                "ciudadOrigen='" + ciudadOrigen + '\'' +
                ", ciudadDestino='" + ciudadDestino + '\'' +
                ", cantidadBoletos=" + cantidadBoletos +
                ", precio=" + precio +
                '}';
    }

    @Override
    public double darPrecio() {
        return this.cantidadBoletos*this.precio;
    }

    @Override
    public String tipo() {
        return "boleto";
    }
}
