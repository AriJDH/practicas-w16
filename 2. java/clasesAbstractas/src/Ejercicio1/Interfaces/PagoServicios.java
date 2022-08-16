package Ejercicio1.Interfaces;

public interface PagoServicios extends Transacciones{
    @Override
    void transaccionOk(String tipoTransacc);

    @Override
    void transaccionNoOk(String tipoTransacc);

}
