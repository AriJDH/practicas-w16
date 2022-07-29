package practica_3.ejercicio1;

public interface RetiroDeEfectivo extends Transaccion {

    default void retiroDinero(){
        System.out.println("Retirando dinero..");
    }

}
