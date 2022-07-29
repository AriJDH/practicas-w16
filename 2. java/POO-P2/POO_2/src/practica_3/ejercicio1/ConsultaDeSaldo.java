package practica_3.ejercicio1;

public interface ConsultaDeSaldo extends Transaccion {

    default void ConsultaSaldo(){
        System.out.println("Consultado saldo..");
    }

}
