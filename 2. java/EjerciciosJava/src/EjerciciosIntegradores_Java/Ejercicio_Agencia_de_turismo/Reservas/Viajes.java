package EjerciciosIntegradores_Java.Ejercicio_Agencia_de_turismo.Reservas;

public class Viajes implements Reserva{

    private Double costo;

    public Viajes(Double costo) {
        this.costo = costo;
    }

    @Override
    public Double obtCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return "Viajes{" +
                "costo=" + costo +
                '}';
    }
    public void aplicarDescuento(double porcentaje){
        costo = costo - (costo*(porcentaje/100));
    }
}
