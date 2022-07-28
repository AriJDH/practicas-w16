package Ejercicio1;

public class Main {

    public static void main(String[] args) {

        Basico basico = new Basico(1000);
        Cobrador cobrador = new Cobrador(2000);
        Ejecutivo ejecutivo = new Ejecutivo(3000);

        System.out.println("Pruebas cliente basico:");
        basico.pagar(100);
        basico.consultar();
        basico.retirar(500);
        basico.consultar();
        basico.retirar(500);
        basico.consultar();

        System.out.println("----------------------------------");
        System.out.println("Pruebas cliente cobrador:");
        cobrador.retirar(500);
        cobrador.consultar();
        cobrador.retirar(2000);
        cobrador.consultar();

        System.out.println("----------------------------------");
        System.out.println("Pruebas cliente ejecutivo:");
        ejecutivo.depositar(100);
        ejecutivo.transferir(100);
        ejecutivo.transferir(4000);
    }
}
