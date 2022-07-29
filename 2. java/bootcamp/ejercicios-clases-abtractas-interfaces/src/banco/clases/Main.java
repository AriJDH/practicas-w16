package banco.clases;

public class Main {

    public static void main(String[] args) {


        System.out.println("---Operaciones del ejecutivo---");

        Ejecutivo ejec = new Ejecutivo();
        ejec.realizarDeposito();
        ejec.realizarTransferencias();
        ejec.transaccionNoOk("Depósito");
        ejec.transaccionOk("Transferencia");

        System.out.println();
        System.out.println("---Operaciones del Basic---");

        Basic basic = new Basic();
        basic.consultarSaldo();
        basic.pagarServicios();
        basic.realizarRetiro();
        basic.transaccionNoOk("Consulta saldo");
        basic.transaccionOk("Pago servicios ");
        basic.transaccionOk("Retiro ");

        System.out.println();
        System.out.println("---Operaciones del Cobrador---");

        Cobrador cobrador = new Cobrador();
        cobrador.consultarSaldo();
        cobrador.realizarRetiro();
        cobrador.transaccionNoOk("Consula saldo");
        cobrador.transaccionOk("Retiro");
    }
}
