package EjerciciosIntegradores_Java.Ejercicio_Agencia_de_turismo.Reservas;

public interface Reserva {
    public abstract Double obtCosto();
    public void aplicarDescuento(double descuento);
}
