package practicaEnVivo;

public class Ejecutivos {

    Deposito dep;
    Transferencia tran;

    public Ejecutivos(){
        dep = new Deposito();
        tran = new Transferencia();
    }

    public void hacerDeposito(){
        dep.transaccionOK();
    }

    public void hacerTransferencia(){
        tran.transaccionOK();
    }

}
