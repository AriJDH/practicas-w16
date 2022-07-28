package absandint.ejercicio1.Clientes;

import absandint.ejercicio1.Transacciones.ConsultaSaldo;
import absandint.ejercicio1.Transacciones.PagoServicios;
import absandint.ejercicio1.Transacciones.RetiroEfectivo;

public class Basic implements ConsultaSaldo, PagoServicios, RetiroEfectivo {
    @Override
    public void realizarConsulta() {
        System.out.println("Realizando consulta");
    }

    @Override
    public void realizarPago() {
        System.out.println("Realizando pago");
    }

    @Override
    public void realizarRetiro() {
        System.out.println("Realizando retiro");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transacción Realizada");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transacción no se pudo realizar");
    }
}
