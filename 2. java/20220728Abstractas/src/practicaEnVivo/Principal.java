package practicaEnVivo;

public class Principal {

    public static void main(String[] args) {
        System.out.println("Ejecitivo e\n-------------");
        Ejecutivos e = new Ejecutivos();
        e.hacerDeposito();
        e.hacerTransferencia();
        System.out.println("-------------");
        System.out.println("Basic b\n-------------");
        Basic b = new Basic();
        b.consultarSaldo();
        b.pagarServicio();
        b.retirarEfectivo();
        System.out.println("-------------");
        System.out.println("Cobrador c\n-------------");
        Cobradores c = new Cobradores();
        c.consultarSaldo();
        c.retirarEfectivo();

    }
}
