package ejercicio1;

public class Main {
    public static void main(String[] args) {
        Basic basic = new Basic();
        Cobrador cobrador = new Cobrador();
        Ejecutivo ejecutivo = new Ejecutivo();

        basic.consultarPago();
        cobrador.consultarPago();
        ejecutivo.HacerDeposito();

    }
}
