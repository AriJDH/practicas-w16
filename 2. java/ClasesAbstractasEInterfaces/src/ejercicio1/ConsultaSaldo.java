package ejercicio1;

public class ConsultaSaldo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo realizada");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta de saldo NO realizada");

    }
}
