package absandint.ejercicio1.Clientes;

import absandint.ejercicio1.Transacciones.ConsultaSaldo;
import absandint.ejercicio1.Transacciones.RetiroEfectivo;

public class Cobradores implements RetiroEfectivo, ConsultaSaldo {
    @Override
    public void realizarConsulta() {
        System.out.println("Realizando consulta");
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
