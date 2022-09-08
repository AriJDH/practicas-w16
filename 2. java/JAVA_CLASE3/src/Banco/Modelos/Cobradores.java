package Banco.Modelos;

import Banco.Interfaces.ConsultaSaldo;
import Banco.Interfaces.PagoServicios;
import Banco.Interfaces.RetiroEfectivo;

public class Cobradores implements ConsultaSaldo, RetiroEfectivo {

    @Override
    public void hacerConsulta() {
        System.out.println("Usuario cobrador consultando saldo");

    }

    @Override
    public void hacerRetiroEfectivo() {
        System.out.println("Usuario cobrador haciendo retiro de efectivo");

    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion exitosa.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion fallida.");
    }
}
