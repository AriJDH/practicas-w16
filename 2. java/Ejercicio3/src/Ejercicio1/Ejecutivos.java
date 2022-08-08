package Ejercicio1;

public class Ejecutivos implements Transferencia, Deposito{

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion rechazada");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion realizada");
    }
}
