package ejercicio1;

public class Basic extends Cliente{

    private ConsultaSaldo consultaSaldo;
    private RetiroEfectivo retiroEfectivo;

    private PagoServicio pagoServicio;

    public Basic(String nombre, String apellido, String dni, ConsultaSaldo consultaSaldo, RetiroEfectivo retiroEfectivo,PagoServicio pagoServicio) {
        super(nombre, apellido, dni);
        this.consultaSaldo = consultaSaldo;
        this.retiroEfectivo=retiroEfectivo;
        this.pagoServicio=pagoServicio;
    }

    public Basic(String nombre, String apellido, String dni) {
        super(nombre, apellido,dni);
    }

    public ConsultaSaldo getConsultaSaldo() {
        return consultaSaldo;
    }

    public void setConsultaSaldo(ConsultaSaldo consultaSaldo) {
        this.consultaSaldo = consultaSaldo;
    }

    public RetiroEfectivo getRetiroEfectivo() {
        return retiroEfectivo;
    }

    public void setRetiroEfectivo(RetiroEfectivo retiroEfectivo) {
        this.retiroEfectivo = retiroEfectivo;
    }

    public PagoServicio getPagoServicio() {
        return pagoServicio;
    }

    public void setPagoServicio(PagoServicio pagoServicio) {
        this.pagoServicio = pagoServicio;
    }
}
