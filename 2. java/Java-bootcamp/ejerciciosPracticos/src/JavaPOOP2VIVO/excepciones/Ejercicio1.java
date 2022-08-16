package JavaPOOP2VIVO.excepciones;

public class Ejercicio1 {

    public static void main(String[] args) {
        PracticaExcepciones excepciones = new PracticaExcepciones();

        try {
            excepciones.calculoCociente();
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
