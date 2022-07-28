package practica.ejercicio1;

public class Basic implements ConsultaSaldo, PagoServicios, RetiroEfectivo {

    double saldo = 50000;

    @Override
    public double getSaldo() {
        System.out.println("Su saldo es de $" + saldo);
        return saldo;
    }

    @Override
    public void pagarServicios() {
        System.out.println("Pagando servicios");
        transaccionOk();
    }

    @Override
    public void retirarEfectivo(double cantidad) {
        if (cantidad < saldo) {
            saldo -= cantidad;
            transaccionOk();
        } else
            transaccionNoOk();
    }

    @Override
    public void transaccionOk() {
        System.out.println("Se realizo su operacion con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Fallo su transaccion");
    }
}
