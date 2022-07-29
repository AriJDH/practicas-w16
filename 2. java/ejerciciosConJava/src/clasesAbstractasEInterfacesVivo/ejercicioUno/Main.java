package clasesAbstractasEInterfacesVivo.ejercicioUno;

public class Main {
    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo();
        Cobrador cobrador = new Cobrador();
        Basic basic = new Basic();

        System.out.println("-----Basic------");

        basic.consultasSaldo();
        basic.pagoServicio();
        basic.refiroDeEfectivo();
        basic.transaccionOk();
        basic.transaccionNoOk();

        System.out.println("-----Ejecutivo------");

        ejecutivo.hacerDeposito();
        ejecutivo.hacerTransaccion();
        ejecutivo.transaccionNoOk();
        ejecutivo.transaccionOk();

        System.out.println("-----Cobrador------");

        cobrador.consultasSaldo();
        cobrador.refiroDeEfectivo();
        cobrador.transaccionOk();
        cobrador.transaccionNoOk();

    }
}
