package Ejercicio1;

public class ConsultaSaldo implements ITransaccion{
    @Override
    public void transaccionOK() {
        System.out.println("Consulta realizado con exito.");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("Error al consultar");
    }

    public void ejecutar(double saldo){
        System.out.println("Saldo actual: $" + saldo);
        transaccionOK();
    }
}
