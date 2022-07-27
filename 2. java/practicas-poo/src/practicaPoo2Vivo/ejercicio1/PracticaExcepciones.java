package practicaPoo2Vivo.ejercicio1;

public class PracticaExcepciones {

    public static void main(String[] args) {
        int a = 0;
        int b = 300;
        int result;

        try {
            result = b/a;
        } catch (ArithmeticException exception) {
            throw new IllegalArgumentException("No se puede dividir por cero.");
        } finally {
            System.out.println("Programa finalizado.");
        }
    }

}
