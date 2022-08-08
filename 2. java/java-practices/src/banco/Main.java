package banco;

import java.util.Scanner;

/*
 * Ejercicio > Modulo 5: Java > ClasesAbstractasEInterfaces-VIVO
 * ESTADO: Finalizado.
 * @GonzaloNahuelDiPierro
 * */
public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Cliente ejecutivo = new Ejecutivo();
        Cliente basic = new Basic();
        Cliente cobrador = new Cobrador();

        while(true){
            System.out.println("MENU PRINCIPAL");
            System.out.println("1. Ingresar como Ejecutivo.");
            System.out.println("2. Ingresar como Basic.");
            System.out.println("3. Ingresar como Cobrador.");
            System.out.println("[!] Presione cualquier otra tecla para salir.");
            String opcion = SCANNER.next();

            switch(opcion){
                case "1": menuEjecutivo((Ejecutivo)ejecutivo);
                    break;
                case "2": menuBasic((Basic)basic);
                    break;
                case "3": menuCobrador((Cobrador)cobrador);
                    break;
                default:
                    SCANNER.close();
                    System.exit(0);
                    break;
            }
        }
    }

    private static void menuEjecutivo(Ejecutivo ejecutivo){
        int idTransaccionSeleccionada;
        do{
            System.out.println("EJECUTIVO");
            System.out.println("- Indicar el tipo de transacción a realizar:");
            System.out.println("1. Depósito.");
            System.out.println("2. Transferencia.");
            idTransaccionSeleccionada = SCANNER.nextInt();

            if(idTransaccionSeleccionada != 1 && idTransaccionSeleccionada != 2){
                System.out.println("> ERROR: la transacción seleccionada no es válida.");
            }else{
                if(idTransaccionSeleccionada == 1)
                    ejecutivo.deposito();
                else
                    ejecutivo.transferencia();

                if(getRandom() == 1)
                    ejecutivo.transaccionOk();
                else
                    ejecutivo.transaccionNoOk();
            }
        }while(idTransaccionSeleccionada != 1 && idTransaccionSeleccionada != 2);
    }

    private static void menuBasic(Basic basic){
        int idTransaccionSeleccionada;
        do{
            System.out.println("BASIC");
            System.out.println("- Indicar el tipo de transacción a realizar:");
            System.out.println("1. Consulta de saldo.");
            System.out.println("2. Pago de servicios.");
            System.out.println("3. Retiro de efectivo.");
            idTransaccionSeleccionada = SCANNER.nextInt();

            if(idTransaccionSeleccionada != 1 && idTransaccionSeleccionada != 2 && idTransaccionSeleccionada != 3){
                System.out.println("> ERROR: la transacción seleccionada no es válida.");
            }else{
                switch (idTransaccionSeleccionada){
                    case 1: basic.consultaDeSaldo();
                        break;
                    case 2: basic.pagoDeServicios();
                        break;
                    case 3: basic.retiroDeEfectivo();
                        break;
                }

                if(getRandom() == 1)
                    basic.transaccionOk();
                else
                    basic.transaccionNoOk();
            }
        }while(idTransaccionSeleccionada != 1 && idTransaccionSeleccionada != 2 && idTransaccionSeleccionada != 3);
    }

    private static void menuCobrador(Cobrador cobrador){
        int idTransaccionSeleccionada;
        do{
            System.out.println("COBRADOR");
            System.out.println("- Indicar el tipo de transacción a realizar:");
            System.out.println("1. Retiro de efectivo.");
            System.out.println("2. Consulta de saldo.");
            idTransaccionSeleccionada = SCANNER.nextInt();

            if(idTransaccionSeleccionada != 1 && idTransaccionSeleccionada != 2){
                System.out.println("> ERROR: la transacción seleccionada no es válida.");
            }else{
                if(idTransaccionSeleccionada == 1)
                    cobrador.retiroDeEfectivo();
                else
                    cobrador.consultaDeSaldo();

                if(getRandom() == 1)
                    cobrador.transaccionOk();
                else
                    cobrador.transaccionNoOk();
            }
        }while(idTransaccionSeleccionada != 1 && idTransaccionSeleccionada != 2);
    }

    private static int getRandom(){
        return (int)(Math.random() * 2);
    }
}
