package Reservas;

public class Transporte implements Reserva{

    private Double costo;

    public Transporte(Double costo) {
        this.costo = costo;
    }

    @Override
    public Double obtCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return "Transporte{" +
                "costo=" + costo +
                '}';
    }
    public void aplicarDescuento(double porcentaje){
        costo = costo - (costo*(porcentaje/100));
    }
}
