package practicesException;

import java.util.LinkedList;
import java.util.List;

//* Permitir la ejecución del código y capturar la excepción lanzada
//* Imprimir por consola el mensaje de error de la misma al realizar la captura
//* Imprimir por consola el texto de la variable mensajeFinal, de modo tal que se muestre siempre (es decir, se lance o no una excepción)
public class ExerciseException1 {
    List<String> mensajeStrings = new LinkedList<>();
    //Mensaje final
    String mensajeFinal = "Este es el último mensaje";
    int[] numeros = new int[5];

    public void asignarValor() {
        try {
            numeros[5] = 10;
        } catch (IndexOutOfBoundsException e) {
            imprimirMensaje(e.getMessage());
        } finally {
            imprimirMensaje(mensajeFinal);
        }
    }

    private void imprimirMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void main(String[] args) {
        ExerciseException1 exerciseException1 = new ExerciseException1();

        exerciseException1.asignarValor();
    }
}
