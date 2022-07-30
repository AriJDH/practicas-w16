package Ejercicio1.Clases;

import Ejercicio1.Interfaces.ConsultaDeSaldo;
import Ejercicio1.Interfaces.RetiroDeEfectivo;
import Ejercicio1.Interfaces.Transacciones;

public class Cobradores implements Transacciones, RetiroDeEfectivo, ConsultaDeSaldo {

    @Override
    public void consultaSaldo() {
        System.out.println("Cliente tipo colaborador esta consultando Saldo");

    }

    @Override
    public void retiroEfectivo() {
        System.out.println("Cliente tipo colaborador esta retirando efectivo");
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
