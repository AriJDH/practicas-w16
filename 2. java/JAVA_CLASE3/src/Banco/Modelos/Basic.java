package Banco.Modelos;

import Banco.Interfaces.ConsultaSaldo;
import Banco.Interfaces.PagoServicios;
import Banco.Interfaces.RetiroEfectivo;

public class Basic implements ConsultaSaldo, PagoServicios, RetiroEfectivo {
    @Override
    public void hacerConsulta() {
        System.out.println("Usuario basic consultando saldo");

    }

    @Override
    public void hacerPagoServicios() {
        System.out.println("Usuario basic haciendo pago de servicio");

    }

    @Override
    public void hacerRetiroEfectivo() {
        System.out.println("Usuario basic haciendo retiro de efectivo");

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
