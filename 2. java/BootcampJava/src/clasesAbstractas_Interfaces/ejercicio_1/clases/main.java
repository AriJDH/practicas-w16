package clasesAbstractas_Interfaces.ejercicio_1.clases;

public class main {
    public static void main(String[] args){

        Cobrador cobrador = new Cobrador();
        Ejecutivo ejecutivo = new Ejecutivo();
        Basic basic = new Basic();

        cobrador.consultarSaldo();
        cobrador.retirarEfectivo(15000d);

        ejecutivo.realizarDeposito();
        ejecutivo.realizarTransferencia(5000d);

        basic.consultarSaldo();
        basic.pagarServicio("Agua");
        basic.retirarEfectivo(10000d);

    }
}
