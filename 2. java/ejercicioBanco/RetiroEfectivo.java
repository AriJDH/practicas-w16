package ejercicioBanco;

public class RetiroEfectivo  implements IRetiroEfectivo {
    @Override
    public void transaccionOk() {
        System.out.println("Retiro Ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo retirar tu efectivo");
    }
    public void retirar() {
        System.out.println("Retirando efectivo");
    }
}
