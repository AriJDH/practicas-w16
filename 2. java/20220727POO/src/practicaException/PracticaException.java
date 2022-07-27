package practicaException;

public class PracticaException {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;
        int resultado;
        try {
            resultado = b/a;
        } catch (ArithmeticException e){
            System.out.println("Se ha producido un error");
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
