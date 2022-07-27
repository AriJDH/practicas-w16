package excepciones;

public class PracticaExceptiones {
    private static int a = 0;
    private static int b = 300;

    public static void main(String[] args) {
        try {
            int cociente = b/a;
        }
        catch(RuntimeException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        finally {
            System.out.println("Programa finalizado");
        }
    }
}
