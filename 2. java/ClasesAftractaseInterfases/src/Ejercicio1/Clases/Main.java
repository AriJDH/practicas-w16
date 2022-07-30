package Ejercicio1.Clases;

public class Main {
    public static void main(String[] args) {
        Basic basic = new Basic();
        Cobradores cobradores = new Cobradores();
        Ejecutivos ejecutivos = new Ejecutivos();
        System.out.println("---------------------------------------------------------------");
        System.out.println("Transacciones de cliente basic");
        System.out.println("---------------------------------------------------------------");
        basic.consultaSaldo();
        basic.transaccionOk();
        basic.retiroEfectivo();
        basic.transaccionNoOk();
        basic.pagoServicios();
        basic.transaccionOk();
        System.out.println("---------------------------------------------------------------");
        System.out.println("Transacciones de cliente Cobrador");
        System.out.println("---------------------------------------------------------------");
        cobradores.consultaSaldo();
        cobradores.transaccionNoOk();
        cobradores.retiroEfectivo();
        cobradores.transaccionOk();
        System.out.println("---------------------------------------------------------------");
        System.out.println("Transacciones de cliente Ejecutivo");
        System.out.println("---------------------------------------------------------------");
        ejecutivos.realizarDeposito();
        ejecutivos.transaccionNoOk();
        ejecutivos.transaccionOk();
    }
}
