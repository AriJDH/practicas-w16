package practica.ejercicio1;

public class Cobradores implements RetiroEfectivo,ConsultaSaldo{

    double saldo = 0;


    @Override
    public double getSaldo() {
        return saldo;
    }

    @Override
    public void retirarEfectivo(double cantidad) {
        System.out.println("Se realizo el retiro de + $" + cantidad);
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion realizada");

    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Fallo al realizar la transaccion");

    }
}
