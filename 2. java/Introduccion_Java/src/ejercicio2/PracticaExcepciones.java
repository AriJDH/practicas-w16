package ejercicio2;

public class PracticaExcepciones {

    public static void main(String[] args) {

        int a = 0;
        int b = 300;

        try {
            int resultado = b / a;

            //Sentencia multicatch
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("No se puede dividir por cero");
        } finally {
            System.out.println("Programa Finalizado");
        }
    }
}
