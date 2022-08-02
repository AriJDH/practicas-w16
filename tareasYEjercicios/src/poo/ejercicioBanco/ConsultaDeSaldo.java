package poo.ejercicioBanco;

public class ConsultaDeSaldo implements Transaccionable {
    @Override
    public void transaccionOk() {
        System.out.println("Su saldo es $99999");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realizar consulta");
    }
}
