package practicesException;

public class ExerciseException2 {
    static int a = 0;
    static int b = 300;

    public static void main(String[] args) {

        try {
            if(a == 0)
                throw new IllegalArgumentException("No se puede dividir por cero");

            System.out.println(b/a);

        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Mensaje finalizado");
        }
    }
}
