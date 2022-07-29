package ClasesAbstractasEInterfaces.Ejercicio1;

public class Basic implements Cliente{
    @Override
    public void realizarTransaccion() {
        Transaccion t = new PagoServicio();
        t.transaccionOk();
        t = new RetiroEfectivo();
        t.transaccionOk();
        t = new ConsultaSaldo();
        t.transaccionOk();
    }
}
