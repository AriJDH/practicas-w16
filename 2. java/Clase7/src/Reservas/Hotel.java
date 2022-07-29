package Reservas;

public class Hotel implements Reserva{
    private Double costo;

    public Hotel(Double costo) {
        this.costo = costo;
    }

    @Override
    public Double obtCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "costo=" + costo +
                '}';
    }

    public String tipoReserva(){
        return "Hotel";
    }

    public void aplicarDescuento(double porcentaje){
        costo = costo - (costo*(porcentaje/100));
    }

}
