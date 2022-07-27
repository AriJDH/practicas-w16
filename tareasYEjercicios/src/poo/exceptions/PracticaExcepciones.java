package poo.exceptions;

public class PracticaExcepciones {

    private static int a = 0;
    private static int b = 300;

    public static void main(String[] args) {

        try {
            if (a == 0)
                throw new IllegalArgumentException("No se puede dividir por cero");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
