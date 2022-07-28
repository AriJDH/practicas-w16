package Entity;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Basic basic = new Basic();
        Ejecutivo ejecutivo = new Ejecutivo();
        Cobrador cobrador = new Cobrador();
        int ej;
        do {
            menuPrincipal();
            Scanner opcion = new Scanner(System.in);
            ej = opcion.nextInt();
            switch (ej) {
                case 1:
                    int opcionBasic;
                    do{
                        menuBasic();
                        Scanner opcion2 = new Scanner(System.in);
                        opcionBasic = opcion2.nextInt();
                    }while(opcionBasic<=0 || opcionBasic>3);
                    if(opcionBasic == 1){
                        basic.consulta_Saldo();
                        basic.transaccionOk();
                    }else if(opcionBasic == 2){
                        basic.pago_servicio();
                        basic.transaccionNoOk();
                    }
                    else{
                        basic.retiro_Efectivo();
                        basic.transaccionOk();
                    }
                    break;
                case 2:
                    int opcionCobrador;
                    do{
                        menuCobrador();
                        Scanner opcion3 = new Scanner(System.in);
                        opcionCobrador = opcion3.nextInt();
                    }while(opcionCobrador<=0 || opcionCobrador>2);
                    if(opcionCobrador == 1){
                        cobrador.retiro_Efectivo();
                        cobrador.transaccionOk();
                    }else{
                        cobrador.consulta_Saldo();
                        cobrador.transaccionNoOk();
                    }
                    break;
                case 3:
                    int opcionEjecutivo;
                    do{
                        menuEjecutivo();
                        Scanner opcion4 = new Scanner(System.in);
                        opcionEjecutivo = opcion4.nextInt();
                    }while(opcionEjecutivo<=0 || opcionEjecutivo>2);
                    if(opcionEjecutivo == 1){
                        ejecutivo.deposito();
                        ejecutivo.transaccionOk();
                    }else{
                        ejecutivo.transferencia();
                        ejecutivo.transaccionNoOk();
                    }
                    break;
                default:
                    break;
            }
        }
        while (ej != 0);
    }
    public static void menuPrincipal(){
        System.out.println("************************************");
        System.out.println("*     Ingrese la opcion deseada    *");
        System.out.println("*     1-Ingresar como Basic        *");
        System.out.println("*     2-Ingresar como Cobrador     *");
        System.out.println("*     3-Ingresar como Ejecutivo    *");
        System.out.println("************************************");
    }
    public static void menuBasic(){
        System.out.println("************************************");
        System.out.println("*     Ingrese la opcion deseada    *");
        System.out.println("*     1-Consultar Saldo            *");
        System.out.println("*     2-Pago Servicio              *");
        System.out.println("*     3-Retiro Efectivo            *");
        System.out.println("************************************");
    }
    public static void menuEjecutivo(){
        System.out.println("************************************");
        System.out.println("*     Ingrese la opcion deseada    *");
        System.out.println("*     1-Realizar Deposito          *");
        System.out.println("*     2-Transferencias             *");
        System.out.println("************************************");
    }
    public static void menuCobrador(){
        System.out.println("************************************");
        System.out.println("*     Ingrese la opcion deseada    *");
        System.out.println("*     1-Retiro Efectivo            *");
        System.out.println("*     2-Consulta Saldo             *");
        System.out.println("************************************");
    }
}
