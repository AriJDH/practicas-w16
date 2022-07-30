package Transacciones;

public interface Transaccion {
    static void transaccionOk(String tipo){
        System.out.println("La transacción " + tipo + " se realizó exitosamente.");
        System.out.println("Volviendo al Menú Principal...");
    }
    static void transaccionNoOk(String tipo){
        System.out.println("Lo sentimos, en este momento no se puede realizar: " + tipo);
        System.out.println("Volviendo al Menú Principal...");
    }
}
