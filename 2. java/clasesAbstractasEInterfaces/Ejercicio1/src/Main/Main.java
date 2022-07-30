package Main;

import Clientes.Cliente;
import Clientes.Cobrador;
import Clientes.Ejecutivo;
import Clientes.Basic;
import java.util.Scanner;


/* TODO:
    Un banco tiene diferentes tipos de transacciones que puede llevar a cabo, entre ellas se encuentran: Depósito, Transferencia, Retiro de Efectivo, Consulta de Saldo, Pago de Servicios. Todas las transacciones tienen dos métodos en común, que son transaccionOk() y transaccionNoOk().
    A partir de esto existen diferentes tipos de clientes que pueden interactuar con el banco:
    Ejecutivos: Realizan Depósitos y Transferencias.
    Basic: Realizan consultas de saldo, pagos de servicios y retiro de efectivo.
    Cobradores: Realizan retiro de efectivo y consulta de saldos.

    TODO: Implementar el escenario según corresponda para permitir a los clientes mencionados con anterioridad, el acceso a los diferentes métodos según la operación que deseen realizar.
     Notas a tener en cuenta:
     No es necesario implementar cálculos o funciones matemáticas. Los métodos pueden ser implementaciones de mensajes mediante System.out.println. Por ejemplo, al hacer un depósito, que aparezca el mensaje “Realizándose depósito”.
     Basic, Cobrador y Ejecutivos pueden ser tratados como clases.
     Transacción puede ser tratada como una Interfaz. Tener en cuenta que existen diferentes tipos de transacciones que implementarán esta interfaz principal.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("---Bienvenido a Banco Urquiza---");

        boolean exit = false;

        while(!exit){
            System.out.println("Elija qué tipo de cliente es:");
            System.out.println("\t1) Basic\n\t2) Cobrador\n\t3) Ejecutivo\n\t4) Salir");

            Cliente usuario;
            Scanner input = new Scanner(System.in);
            int tipoCliente = input.nextInt();

            switch (tipoCliente){
                case 1:
                    usuario = new Basic();
                    menuBasic((Basic) usuario);
                    break;
                case 2:
                    usuario = new Cobrador();
                    menuCobrador((Cobrador) usuario);
                    break;
                case 3:
                    usuario = new Ejecutivo();
                    menuEjecutivo((Ejecutivo) usuario);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción Inválida.");
            }
        }


        System.out.println("Saliendo...");
        System.out.println("¡Hasta luego!");

    }

    private static void menuBasic(Basic cliente){
        boolean exit = false;

        while(!exit) {
            System.out.println("Elija qué tipo de transacción realizar:");
            int tipoOpcion = 0;

            System.out.println("\t1) Consulta de Saldo\n\t2) Retiro de Efectivo\n\t3) Pago de Servicios\n\t4) Salir");
            Scanner input = new Scanner(System.in);
            tipoOpcion = input.nextInt();

            switch (tipoOpcion) {
                case 1:
                    cliente.consulSaldo();
                    break;
                case 2:
                    cliente.hacerRetiro();
                    break;
                case 3:
                    cliente.hacerPago();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción Inválida.");
            }
        }

    }

    private static void menuCobrador(Cobrador cliente){
        boolean exit = false;

        while(!exit) {
            System.out.println("Elija qué tipo de transacción realizar:");
            int tipoOpcion = 0;

            System.out.println("\t1) Consulta de Saldo\n\t2) Retiro de Efectivo\n\t3) Salir");
            Scanner input = new Scanner(System.in);
            tipoOpcion = input.nextInt();

            switch (tipoOpcion) {
                case 1:
                    cliente.consulSaldo();
                    break;
                case 2:
                    cliente.hacerRetiro();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción Inválida.");
            }
        }
    }

    private static void menuEjecutivo(Ejecutivo cliente){
        boolean exit = false;

        while(!exit) {
            System.out.println("Elija qué tipo de transacción realizar:");
            int tipoOpcion = 0;

            System.out.println("\t1) Depósito\n\t2) Transferencia\n\t3) Salir");
            Scanner input = new Scanner(System.in);
            tipoOpcion = input.nextInt();

            switch (tipoOpcion) {
                case 1:
                    cliente.hacerDeposito();
                    break;
                case 2:
                    cliente.hacerTransferencia();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción Inválida.");
            }
        }
    }
}
