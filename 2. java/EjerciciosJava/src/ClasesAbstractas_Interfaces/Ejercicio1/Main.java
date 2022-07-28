package ClasesAbstractas_Interfaces.Ejercicio1;

public class Main {

    public static void main(String[] args) {

        Ejecutivo ejec = new Ejecutivo();

        ejec.transaccionOk();
        ejec.transaccionNoOk();
        ejec.realizarDeposito();
        ejec.realizarTransferencia();

        System.out.println("------------------------");

        Basic basic = new Basic();

        basic.transaccionOk();
        basic.transaccionNoOk();
        basic.consultarSaldo();
        basic.pagarServicio();
        basic.retirarEfectivo();

        System.out.println("------------------------");

        Cobrador cob = new Cobrador();

        cob.transaccionOk();
        cob.transaccionNoOk();
        cob.retirarEfectivo();
        cob.consultarSaldo();

    }

}
