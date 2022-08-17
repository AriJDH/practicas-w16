package ExerciseOne;

public class ServicesPay implements TypesTransactions {
    @Override
    public void transaccionOk() {
        System.out.println("Pagando servicios");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Algo salio mal pagando servicios");
    }
}
