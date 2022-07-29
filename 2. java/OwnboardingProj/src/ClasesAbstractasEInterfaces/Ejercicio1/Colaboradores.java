package ClasesAbstractasEInterfaces.Ejercicio1;

public class Colaboradores implements Cliente {
    @Override
    public void realizarTransaccion() {
        Transaccion t = new RetiroEfectivo();
        t.transaccionNoOk();
        t = new ConsultaSaldo();
        t.transaccionOk();
    }
}
