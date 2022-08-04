package abstractasInterfases.interfaces1;

public class Basic implements RetiroEfectivo, ConsultaSaldo{

    public void pagoDeServicio(){
        System.out.println("Servicio pagado");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("No tiene saldo");

    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Ha retirado $1");
    }

    @Override
    public void transaccionOk() {

    }

    @Override
    public void transaccionNoOk() {

    }
}
