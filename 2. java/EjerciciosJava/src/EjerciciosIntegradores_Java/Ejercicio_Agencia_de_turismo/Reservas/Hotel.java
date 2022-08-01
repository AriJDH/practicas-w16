package EjerciciosIntegradores_Java.Ejercicio_Agencia_de_turismo.Reservas;

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

    public void aplicarDescuento(double porcentaje){
        costo = costo - (costo*(porcentaje/100));
    }

}
