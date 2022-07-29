package banco.clases;

import banco.interfaces.Retiro;
import banco.interfaces.Saldo;

public class Cobrador implements Retiro, Saldo {
    @Override
    public void realizarRetiro() {
        System.out.println("Realizando retiro");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo");
    }

    @Override
    public void transaccionOk(String tipo) {
        System.out.println(tipo + " efectiva");
    }

    @Override
    public void transaccionNoOk(String tipo) {
        System.out.println(tipo + " no efectiva");
    }
}
