package Ejercicio1.Clases.Interfaces;

public interface Transacciones {

    public abstract void transaccionOk(String tipoTransacc);
    public abstract void transaccionNoOk(String tipoTransacc);
}
