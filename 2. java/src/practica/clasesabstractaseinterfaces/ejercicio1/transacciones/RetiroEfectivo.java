package practica.clasesabstractaseinterfaces.ejercicio1.transacciones;

public class RetiroEfectivo implements Transactable {

    protected double saldo;

    public RetiroEfectivo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void transaccionOK() {
        System.out.println("Operacion exitosa. Retire el dinero de la bandeja.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Ha ocurrido un error. El retiro no se ha podido realizar correctamente.");
    }

    public void retirarEfectivo() {
        System.out.println("Realizando retiro de efectivo");
    }
}
