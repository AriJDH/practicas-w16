package Ejercicio1;

public class RetiroDeEfectivo implements ITransaccionable {
    @Override
    public void transaccionOk() {
        System.out.println(" - Se realizo su Retiro de Efectivo. \n");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println(" - No se realizo su Retiro de Efectivo. \n");
    }
}
