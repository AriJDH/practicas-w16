package ClasesAbstractasEInterfaces.Ejercicio1;

public class Transferencia implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transferencia No Ok");
    }
}
