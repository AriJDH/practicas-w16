package banco.clases;

import banco.interfaces.Deposito;
import banco.interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {
    @Override
    public void realizarDeposito() {
        System.out.println("Realizando deposito");
    }

    @Override
    public void transaccionOk(String tipo) {
        System.out.println(tipo + " efectiva");
    }

    @Override
    public void transaccionNoOk(String tipo) {
        System.out.println(tipo + " no efectiva");
    }

    @Override
    public void realizarTransferencias() {
        System.out.println("Realizando transferencia");
    }
}
