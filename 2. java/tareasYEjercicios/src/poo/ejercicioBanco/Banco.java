package poo.ejercicioBanco;

public class Banco {
    public static void main(String[] args) {

        ClienteBasic basic = new ClienteBasic("Perez Juan", "345776999", "900877665844444");
        ClienteCobrador cobrador = new ClienteCobrador("Martinez Maria", "34222156", "8874645357393030");
        ClienteEjecutivo ejecutivo = new ClienteEjecutivo("Milu Castro", "90877678", "8777765444330222");

        System.out.println("Operaciones cliente ejecutivo " + ejecutivo.getNombre() + " DNI: " + ejecutivo.getDni());
        ejecutivo.depositar();
        ejecutivo.transferir();

        System.out.println("Operaciones cliente basic " + basic.getNombre() + " DNI: " + basic.getDni());
        basic.consultarSaldo();
        basic.pagarServicios();
        basic.retirarEfvo();

        System.out.println("Operaciones cliente cobrador " + cobrador.getNombre() + " DNI: " + cobrador.getDni());
        cobrador.retirarEfvo();
        cobrador.consultarSaldo();
    }
}
