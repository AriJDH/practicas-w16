package Ejercicios1;

public class Main {
    public static void main(String[] args) {
    /*
    Un banco tiene diferentes tipos de transacciones que puede llevar a cabo, entre ellas se encuentran: Depósito, Transferencia, Retiro de Efectivo, Consulta de Saldo, Pago de Servicios. Todas las transacciones tienen dos métodos en común, que son transaccionOk() y transaccionNoOk().
A partir de esto existen diferentes tipos de clientes que pueden interactuar con el banco:

Ejecutivos: Realizan Depósitos y Transferencias.
Basic: Realizan consultas de saldo, pagos de servicios y retiro de efectivo.
Cobradores: Realizan retiro de efectivo y consulta de saldos.

Implementar el escenario según corresponda para permitir a los clientes mencionados con anterioridad, el acceso a los diferentes métodos según la operación que deseen realizar.

Notas a tener en cuenta:
Basic, Cobrador y Ejecutivos pueden ser tratados como clases.
Transacción puede ser tratada como una Interfaz. Tener en cuenta que existen diferentes tipos de transacciones que implementarán esta interfaz principal.
     */
        Basic basic = new Basic();
        Ejecutivo ejecutivo = new Ejecutivo();
        Cobrador cobrador = new Cobrador();

        System.out.println("Basic");
        basic.retirarEfectivo(100);
        basic.consultarSaldo();
        basic.pagarServicios(100);

        System.out.println("Ejecutivo");
        ejecutivo.depositar(100);
        ejecutivo.trasferencia(100);

        System.out.println("Cobrador");
        cobrador.retirarEfectivo(100);
        cobrador.consultarSaldo();



    }
}
