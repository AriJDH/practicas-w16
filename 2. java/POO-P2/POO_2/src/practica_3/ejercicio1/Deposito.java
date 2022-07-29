package practica_3.ejercicio1;

public interface Deposito extends Transaccion {

    default void depositarDinero(){
        System.out.println("Depositando dinero.");
    }

}
