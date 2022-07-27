package practico.ejercicio1;

public class PracticaExcepciones {

    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        try {
            if (a == 0){
                throw new IllegalAccessException("No se puede dividir por cero.");
            }
            int resultado = b/a;
        }catch (Exception ex){
            System.out.println("ERROR: "+ex.getMessage());
        }
        finally {
            System.out.println("Programa finalizado.");
        }
    }
}
