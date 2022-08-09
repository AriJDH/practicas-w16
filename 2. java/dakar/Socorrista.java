package dakar;

public class Socorrista <T extends Vehiculo> implements ISocorrista<T> {
    @Override
    public void socorrer(T vehiculo) {
        System.out.println("Socorriendo el vehiculo");
    }

}
