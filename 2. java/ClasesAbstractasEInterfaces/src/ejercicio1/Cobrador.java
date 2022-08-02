package ejercicio1;

public class Cobrador extends Cliente{

    private RetiroEfectivo retiroEfectivo;
    private ConsultaSaldo consultaSaldo;

    public Cobrador(String nombre, String apellido, String dni, RetiroEfectivo retiroEfectivo, ConsultaSaldo consultaSaldo) {
        super(nombre, apellido, dni);
        this.retiroEfectivo=retiroEfectivo;
        this.consultaSaldo=consultaSaldo;
    }

    public Cobrador(String nombre, String apellido, String dni) {
        super(nombre,apellido,dni);
    }

    public RetiroEfectivo getRetiroEfectivo() {
        return retiroEfectivo;
    }

    public void setRetiroEfectivo(RetiroEfectivo retiroEfectivo) {
        this.retiroEfectivo = retiroEfectivo;
    }

    public ConsultaSaldo getConsultaSaldo() {
        return consultaSaldo;
    }

    public void setConsultaSaldo(ConsultaSaldo consultaSaldo) {
        this.consultaSaldo = consultaSaldo;
    }
}
