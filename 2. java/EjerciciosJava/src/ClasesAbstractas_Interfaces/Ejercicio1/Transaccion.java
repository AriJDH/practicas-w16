package ClasesAbstractas_Interfaces.Ejercicio1;

public interface Transaccion {
    default void transaccionOk(){
        System.out.println("Transaccion realizada con exito");
    }
    default void transaccionNoOk(){
        System.out.println("Error al realizar la transaccion");
    }
}
