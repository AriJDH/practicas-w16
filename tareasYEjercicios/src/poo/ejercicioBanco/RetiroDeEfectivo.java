package poo.ejercicioBanco;

public class RetiroDeEfectivo implements Transaccionable {
    @Override
    public void transaccionOk() {
        System.out.println("Se retiro efectivo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se retiro efectivo");
    }
}
