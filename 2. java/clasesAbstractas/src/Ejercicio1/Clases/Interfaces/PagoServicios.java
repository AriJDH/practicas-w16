package Ejercicio1.Clases.Interfaces;

public interface PagoServicios extends Transacciones{
    @Override
    void transaccionOk(String tipoTransacc);

    @Override
    void transaccionNoOk(String tipoTransacc);

}
