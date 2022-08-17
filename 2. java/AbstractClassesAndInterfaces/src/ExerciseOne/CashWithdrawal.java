package ExerciseOne;

public class CashWithdrawal implements TypesTransactions {
    @Override
    public void transaccionOk() {
        System.out.println("Realizando retiro en efectivo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("algo salio mal realizando retiro en efectivo");
    }
}
