package JavaAbstractInterfaceVIVO.ejercicio1;

public class Ejecutivos extends Cliente implements ITransaccionEjecutivo {

    public void realizarDeposito() {

    }

    @Override
    public void transaccionOK() {
        System.out.println("Transaccion Exitosa !!");
    }

    @Override
    public void transaccionNoOK() {

    }

    @Override
    public void deposito() {
        System.out.println("Realizándose Deposito");
        transaccionOK();
    }

    @Override
    public void transferencia() {
        ITransaccionEjecutivo.super.transferencia();
        transaccionOK();
    }
}
