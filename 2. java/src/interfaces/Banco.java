package interfaces;

import interfaces.models.Basic;
import interfaces.models.Cobradores;
import interfaces.models.Ejecutivo;
import interfaces.servicios.*;

import java.util.Scanner;

public class Banco {

    public static void main(String[]args){
        Basic basic = new Basic("Rodrigo",19,"19022356-2");
        Cobradores cobrador = new Cobradores("gilberto",48,"19022356-2","Copec");
        Ejecutivo ejecutivo = new Ejecutivo("Javiera",27,"1696968532-2");
        //instanciamos los tipos de transacciones
        Deposito deposito = new Deposito();
        Transferencia transferencia = new Transferencia();
        ConsultaDeSaldo consultaDeSaldo = new ConsultaDeSaldo();
        PagoDeServicio pagoDeServicio = new PagoDeServicio();
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();

        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido a banco Estado");
        System.out.println("Ingrese su tipo de cliente");
        System.out.println("1.-Ejecutivo");
        System.out.println("2.-Basic");
        System.out.println("3.-Cobrador");
        int op = sc.nextInt();







        int op2=0;
        switch(op){
            case 1:
                System.out.println(ejecutivo.getNombre()+" que operacion desea realizar?");
                System.out.println("1.-Deposito");
                System.out.println("2.-Transferencia");
                op2=sc.nextInt();

                if(op2==1){

                    deposito.transaccionOk();
                }else{
                    transferencia.transaccionNoOk();
                }


                break;
            case 2:
                System.out.println(basic.getNombre()+" que operacion desea realizar?");
                System.out.println("1.-Retiro en efectivo");
                System.out.println("2.-Consulta de saldo");
                System.out.println("3.-Pago de servicio");
                op2=sc.nextInt();

                if(op2==1){
                    retiroEfectivo.transaccionNoOk();
                }else if(op2 == 2){
                    consultaDeSaldo.transaccionOk();
                }else{
                    pagoDeServicio.transaccionNoOk();
                }

                break;
            case 3:
                System.out.println(cobrador.getNombre()+" que operacion desea realizar?");

                System.out.println("1.-Retiro en efectivo");
                System.out.println("2.-Consulta de saldo");
                op2=sc.nextInt();

                if(op2==1){
                    retiroEfectivo.transaccionNoOk();
                }else{
                    consultaDeSaldo.transaccionOk();
                }

                break;

        }


    }
}
