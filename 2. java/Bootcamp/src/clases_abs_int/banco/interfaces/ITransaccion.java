package clases_abs_int.banco.interfaces;

public interface ITransaccion {

    default void transaccionOk(){
        System.out.println("Transacción OK");
    };

    default void transaccionNoOk(){
        System.out.println("Transacción NO OK");
    };
}
