package ClasesAbstractasEInterfaces.Ejercicio1;

public class Ejecutivo implements Cliente{
    @Override
    public void realizarTransaccion() {
        Transaccion t = new Deposito();
        t.transaccionOk();
        t = new Transferencia();
        t.transaccionOk();
    }
}
