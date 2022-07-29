package ClasesAbstractasEInterfaces.Ejercicio1;

import jdk.swing.interop.SwingInterOpUtils;

public class Deposito implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Deposito OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Deposito No Ok");
    }
}
