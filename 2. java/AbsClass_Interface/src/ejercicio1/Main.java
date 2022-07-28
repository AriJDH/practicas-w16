package ejercicio1;

import ejercicio1.Clientes.Basic;
import ejercicio1.Clientes.Ejecutivo;
import ejercicio1.Clientes.Cobrador;

public class Main {

    public static void main(String[] args) {

        Ejecutivo ejecutivo = new Ejecutivo("1234567-8", "Ejecutivo BCI");
        Basic basic = new Basic("14567983-2", "Cliente Basic Santander");
        Cobrador cobrador = new Cobrador("12678098-K", "Cobrador Itaú");

        System.out.println("Primera operación del ejecutivo: " + ejecutivo.DepositoOK());
        System.out.println("Segunda operación del ejecutivo: " + ejecutivo.TransferenciaNoOk());
        System.out.println();
        System.out.println("Primera operación del cliente basic: " + basic.ConsultaSaldoOK());
        System.out.println("Segunda operación del cliente basic: " + basic.pagoServicioNoOk());
        System.out.println("Tercera operación del cliente basic: " + basic.RetiroEfectivoOK());
        System.out.println();
        System.out.println("Primera operación del cobrador: " + cobrador.ConsultaSaldoOK());
        System.out.println("Segunda operación del cobrador: " + cobrador.RetiroEfectivoNoOk());


    }
}
