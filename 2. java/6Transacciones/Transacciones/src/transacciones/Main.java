package transacciones;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nTransferencias Bancarias");

        System.out.println("\nCliente Basic");
        Basic basic = new Basic();
        System.out.println("\nProceso de Consulta Basic");
        basic.procesoDeConsulta();
        System.out.println("\nProceso Pago de Servicios Basic");
        basic.procesoPagoDeServicios();
        System.out.println("\nProceso de Retiro Basic");
        basic.procesoRetiroDeEfectivo();

        System.out.println();
        System.out.println("\nCliente Ejecutivo");
        Ejecutivos ejecutivo = new Ejecutivos();
        System.out.println("\nEjecutivo de proceso Deposito");
        ejecutivo.procesoDeDeposito();
        System.out.println("\nEjecutivo de transferencia");
        ejecutivo.procesoDeTransferencia();

        System.out.println();
        System.out.println("\nCliente Cobradores");
        Cobradores cobradores = new Cobradores();
        System.out.println("\nProceso de Consulta Cobradores");
        cobradores.procesoDeConsulta();
        System.out.println("\nProceso de Retiro Cobradores");
        cobradores.procesoRetiroDeEfectivo();


    }
}
