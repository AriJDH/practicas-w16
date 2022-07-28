package practicaEnVivo;

public class Deposito implements Transaccion{

    public Deposito(){}

    @Override
    public void transaccionOK() {
        System.out.println("Deposito OK");
    }

    @Override
    public void transaccionNOOK() {
        System.out.println("Deposito NO OK");
    }


}
