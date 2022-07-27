public class Ejercicio1 {
    public static void main(String[] args) {
        PracticaExcepciones ejemplo = new PracticaExcepciones(0,300);

        double cociente = ejemplo.hacerCociente();

        System.out.println("El cociente es: " + cociente);
    }
}
