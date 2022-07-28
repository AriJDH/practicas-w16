package Excepciones_POO;

public class PracticaExcepciones {

    public static void main(String[] args) {

        int a = 0, b = 30, res;

        try {
            if(a == 0){
                throw new IllegalArgumentException("No se puede dividir por cero");
            } else {
                res = b/a;
            }
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Programa finalizado.");
        }

    }

}
