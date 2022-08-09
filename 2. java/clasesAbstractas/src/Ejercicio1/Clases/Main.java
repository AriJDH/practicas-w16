package Ejercicio1.Clases;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Cobradores cobrador1 = new Cobradores();
        cobrador1.consultarSaldo();
        cobrador1.retirarEfectivo(200000);
        cobrador1.consultarSaldo();
        System.out.println("-------------------");

        Basic basic1= new Basic();
        basic1.consultarSaldo();
        basic1.pagoDeServicios("Agua", 100.5);
        basic1.consultarSaldo();
        basic1.retirarEfectivo(500);
        basic1.consultarSaldo();



    }
}
