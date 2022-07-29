package practica_3.ejercicio1;

public interface Transferencia extends Transaccion{

    default void Transferencia(){
        System.out.println("Realizando la transferencia");
    }

}
