package Ejercicio1;

public class ConsultaDeSaldo implements ITransaccionable {
    @Override
    public void transaccionOk() {
        System.out.println(" - Se realizo la Consulta de su Saldo. \n");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println(" - No se realizo la Consulta de su Saldo. \n");
    }
}
