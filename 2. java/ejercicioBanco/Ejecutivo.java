package ejercicioBanco;

public class Ejecutivo implements IEjecutivo {
    protected IDeposito deposito;
    protected ITransferencia transferencia;
    public Ejecutivo(IDeposito servicioDepositos, ITransferencia servicioTransferencia) {
        this.deposito = servicioDepositos;
        this.transferencia = servicioTransferencia;
    }
    public void depositar() {
        try {
            this.deposito.depositarEfectivo();
            this.deposito.transaccionOk();
        } catch (Exception e) {
            this.deposito.transaccionNoOk();
        }
    }
    public void transferir() {
        try {
            this.transferencia.enviarDinero();
            this.transferencia.transaccionOk();
        } catch (Exception e) {
            this.transferencia.transaccionNoOk();
        }
    }
}
