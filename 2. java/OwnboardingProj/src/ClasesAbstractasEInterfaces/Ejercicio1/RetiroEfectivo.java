package ClasesAbstractasEInterfaces.Ejercicio1;

public class RetiroEfectivo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Returo de efectivo No Ok");
    }
}
