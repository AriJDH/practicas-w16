package banco;

public class Cobrador extends Cliente implements RetiroEfectivo, ConsultaSaldo{

    @Override
    public void consultarSaldo() {
        System.out.println("Saldo disponible: 43000");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Operación realizada con éxito: retirar efectivo");
    }

    @Override
    public void transaccionOK() {
        System.out.println("Transacción realizada correctamente");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("Transacción no realizada");
    }
}
