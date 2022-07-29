package practica.clasesabstractaseinterfaces.ejercicio1.transacciones;

public class Transferencia implements Transactable {

    protected String cuentaDestino;
    protected double montoTransferencia;

    public Transferencia(String cuentaDestino, double montoTransferencia) {
        this.cuentaDestino = cuentaDestino;
        this.montoTransferencia = montoTransferencia;
    }

    @Override
    public void transaccionOK() {
        System.out.println("Transferencia realizada con exito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al realizar transferencia.");
    }

    public void transferir() {
        System.out.println("Realizando transferencia");
    }
}
