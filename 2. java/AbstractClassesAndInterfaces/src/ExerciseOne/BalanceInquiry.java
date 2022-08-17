package ExerciseOne;

public class BalanceInquiry implements TypesTransactions {
    @Override
    public void transaccionOk() {
        System.out.println("Realizando consulta de saldo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Algo salio mal consultando el saldo");
    }
}
