package ejercicioBanco;

public class Saldo implements ISaldo {
    @Override
    public void transaccionOk() {
        System.out.println("todo ok!");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No pudimos ver tu saldo en este momento");
    }

    @Override
    public void consultar() {
        System.out.println("Tu saldo es muy fin de mes");
    }
}
