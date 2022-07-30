package Ejercicio1.Clases;

import Ejercicio1.Interfaces.ConsultaDeSaldo;
import Ejercicio1.Interfaces.PagoDeServicios;
import Ejercicio1.Interfaces.RetiroDeEfectivo;
import Ejercicio1.Interfaces.Transacciones;

public class Basic implements Transacciones, ConsultaDeSaldo, PagoDeServicios, RetiroDeEfectivo {

    @Override
    public void consultaSaldo() {
        System.out.println("Cliente tipo basic esta consultando el saldo");
    }

    @Override
    public void pagoServicios() {
        System.out.println("Cliente tipo basic esta haciendo pago de servicios");
    }

    @Override
    public void retiroEfectivo() {
        System.out.println("Cliente tipo basic esya retirando efectivo");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Cliente tipo colaborador Su transaccion esta OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Cliente tipo colaborador Su transaccion esta NO OK");
    }
    
}
