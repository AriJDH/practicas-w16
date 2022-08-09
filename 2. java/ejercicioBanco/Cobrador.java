package ejercicioBanco;

public class Cobrador implements ICobrador {
    protected ISaldo saldo;
    protected IRetiroEfectivo retiroEfectivo;
    public Cobrador(
            ISaldo saldo,
            IRetiroEfectivo retiroEfectivo
    ) {
    this.saldo = saldo;
    this.retiroEfectivo = retiroEfectivo;
    }

    public void consultarSaldo() {
        try {
            this.saldo.consultar();
            this.saldo.transaccionOk();
        } catch (Exception e) {
            this.saldo.transaccionNoOk();
        }
    }
    public void retirarEfectivo() {
        try {
            this.retiroEfectivo.retirar();
            this.retiroEfectivo.transaccionOk();
        } catch (Exception e) {
            this.retiroEfectivo.transaccionNoOk();
        }
    }
}
