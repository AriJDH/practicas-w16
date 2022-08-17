package ExerciseOne;

public class Transfer implements TypesTransactions {
    @Override
    public void transaccionOk() {
        System.out.println("Realizando transferencia");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Algo salio mal realizando transferencia");
    }
}
