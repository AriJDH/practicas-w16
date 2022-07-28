package ejercicio1;

public class Cobrador implements RetiroEfectivo,ConsultaSaldo{

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion correcta");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion incorrecta");
    }

    @Override
    public void hacerConsultaSaldo() {
        System.out.println("Consultando saldo");
    }

    @Override
    public void hacerRetiroEfectivo() {
        System.out.println("Retirando efectivo");
    }
}
