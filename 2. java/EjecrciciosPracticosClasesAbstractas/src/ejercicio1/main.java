package ejercicio1;

public class main {
    public static void main(String[] args) {
        Basic basic = new Basic();
        Cobrador cobrador = new Cobrador();
        Ejecutivo ejecutivo = new Ejecutivo();

        ejecutivo.hacerDeposito();
        ejecutivo.hacerTransferencia();
        basic.hacerConsultaSaldo();
        basic.hacerPagoServicio();
        basic.hacerRetiroEfectivo();
        cobrador.hacerRetiroEfectivo();
        cobrador.hacerConsultaSaldo();
    }
}
