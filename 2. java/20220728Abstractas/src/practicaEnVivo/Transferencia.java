package practicaEnVivo;

public class Transferencia implements Transaccion{

    public Transferencia(){}

    @Override
    public void transaccionOK() {
        System.out.println("Transferencia OK");
    }

    @Override
    public void transaccionNOOK() {
        System.out.println("Transferencia NO OK");
    }
}
