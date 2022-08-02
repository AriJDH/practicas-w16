package ejercicio1;

import java.util.concurrent.TransferQueue;

public class Ejecutivo extends Cliente{


    private Deposito deposito;
    private Transferencia transferencia;

    public Ejecutivo(String nombre, String apellido, String dni,  Deposito deposito, Transferencia transferencia) {
        super(nombre, apellido, dni);
        this.deposito = deposito;
        this.transferencia = transferencia;
    }

    public Ejecutivo( String nombre, String apellido, String dni) {
        super(nombre, apellido, dni);
    }


    public Deposito getDeposito() {
        return deposito;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }

    public Transferencia getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(Transferencia transferencia) {
        this.transferencia = transferencia;
    }
}
