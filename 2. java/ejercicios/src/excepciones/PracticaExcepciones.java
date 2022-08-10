package excepciones;

public class PracticaExcepciones {

    private int a;
    private int b;

    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public double calcularCociente() {
        try {
            return b / a;
        } catch (ArithmeticException e) {
            System.out.println("Error : se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }
        return 0;
    }

    public double calcularCociente2() {
        try {
            if (a == 0) {
                throw new IllegalArgumentException();
            }
            return b / a;
        } catch (IllegalArgumentException e) {
            System.out.println("Error : no se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
        return 0;
    }

    public static void main(String[] args) {
        PracticaExcepciones p = new PracticaExcepciones(0, 300);
        p.calcularCociente();
        p.calcularCociente2();
    }
}
