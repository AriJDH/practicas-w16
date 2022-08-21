package JavaAbstractInterfaceVIVO.ejercicio1;

public interface ITransaccionEjecutivo {
    public void deposito();

    default void transferencia() {
        System.out.println("Transferencia Realizada");
    }
}
