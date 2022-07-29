package Ejercicio1;

public class Main {
    public static void main(String[] args) {

        Basic basico = new Basic("Andres Paez", "3333", "Basico");
        Ejecutivo ejecutivo = new Ejecutivo("Mateo Torres", "4444", "Ejecutivo");
        Cobrador cobrador = new Cobrador("Guille Julio", "5555", "Cobrador");

        System.out.println(basico.toString());
        basico.retiroEfectivo();
        basico.saldo();
        basico.pagoServicio();

        System.out.println(ejecutivo.toString());
        ejecutivo.deposito();
        ejecutivo.transferencia();

        System.out.println(cobrador.toString());
        cobrador.retiroEfectivo();
        cobrador.saldo();
    }
}
