package Ejercicio1;

public class RetiroEfectivo implements Transaccion{

    @Override
    public boolean transaccionOk() {
        System.out.println("Realizando deposito.");
        System.out.println("Deposito realizado correctamente.");
        return true;
    }

    @Override
    public boolean transaccionNoOk() {
        System.out.println("Realizando deposito.");
        System.out.println("Deposito no realizado.");
        return false;
    }
}
