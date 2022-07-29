package practica_3.ejercicio1;

public interface PagoDeServicios extends Transaccion{

    default void PagoServicio(){
        System.out.println("Pagando servicios...");
    }

}
