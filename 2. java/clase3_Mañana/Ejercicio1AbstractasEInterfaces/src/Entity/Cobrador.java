package Entity;

import Interface.Efectivo;
import Interface.Saldo;

public class Cobrador extends Cliente implements Efectivo, Saldo {

    @Override
    public void retiro_Efectivo() {
        System.out.println("Retirando efectivo los cobradores");
    }

    @Override
    public void consulta_Saldo() {
        System.out.println("Consultando saldo los cobradores");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion Ok del colaborador");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion rechazada del colaborador");
    }
}
