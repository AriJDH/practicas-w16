package ClasesAbstractasEInterfaces.Ejercicio1;

public class ConsultaSaldo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta de saldo No Ok");
    }
}
