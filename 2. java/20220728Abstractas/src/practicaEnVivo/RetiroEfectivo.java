package practicaEnVivo;

public class RetiroEfectivo implements Transaccion{
    public RetiroEfectivo(){}

    @Override
    public void transaccionOK() {
        System.out.println("Retiro efectivo OK");
    }

    @Override
    public void transaccionNOOK() {
        System.out.println("Retiro efectivo NO OK");
    }
}
