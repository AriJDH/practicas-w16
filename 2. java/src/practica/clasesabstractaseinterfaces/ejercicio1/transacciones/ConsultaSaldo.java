package practica.clasesabstractaseinterfaces.ejercicio1.transacciones;

public class ConsultaSaldo implements Transactable {

    protected double saldo;

    public ConsultaSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void transaccionOK() {
        System.out.println("Su saldo es: ");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Ha ocurrido un error. Intente nuevamente.");
    }

    public void consultarSaldo() {
        System.out.println("Realizando consulta de saldo");
    }
}
