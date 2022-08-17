package ExerciseOne;

public class Deposit implements TypesTransactions {
    @Override
    public void transaccionOk() {
        System.out.println("Realizando deposito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Algo salio mal realizando deposito");

    }
}
