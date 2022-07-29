package practica.poo.p2.vivo;

public class PracticaExcepciones {

    private int a = 0;
    private int b = 300;

    public static void main(String[] args) {
        int a = 0;
        int b = 300;
        int resultado;
        try {
            if (a == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            resultado = b / a;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
