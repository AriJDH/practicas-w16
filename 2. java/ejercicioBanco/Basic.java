package ejercicioBanco;

public class Basic extends Cobrador implements IBasic {
    protected IPagoServicio pagoServicios;
    public Basic(
            ISaldo saldo,
            IRetiroEfectivo retiroEfectivo,
            IPagoServicio pagoServicio
    ) {
        super(saldo, retiroEfectivo);
        this.pagoServicios = pagoServicio;
    }
    public void pagarServicio() {
        try {
            this.pagoServicios.pagar();
            this.pagoServicios.transaccionOk();
        } catch (Exception e) {
            this.pagoServicios.transaccionNoOk();
        }
    }
}
