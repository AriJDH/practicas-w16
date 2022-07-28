package practicaEnVivo;

public class ConsultaSaldo implements Transaccion{

    public ConsultaSaldo(){}

    @Override
    public void transaccionOK() {
        System.out.println("Consulta Saldo OK");
    }

    @Override
    public void transaccionNOOK() {
        System.out.println("Consulta Saldo NO OK");
    }
}
