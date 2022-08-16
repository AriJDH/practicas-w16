package JavaPOOP2PG;

import java.util.LinkedList;
import java.util.List;

public class MensajeException {
    List<String> mensajeStrings = new LinkedList<>();
    //Mensaje final
    String mensajeFinal = "Este es el último mensaje";

    int[] numeros = new int[5];

    public void asignarValor() {
        //Código que arroja excepción, escribi tu codigo aqui
        //numeros[5] = 10;
        try {
            numeros[5] = 10;
        } catch (IndexOutOfBoundsException exception) {
            imprimirMensaje(exception.getMessage());
        } finally {
            imprimirMensaje(mensajeFinal);
        }
    }

    private void imprimirMensaje(String mensaje) {
        mensajeStrings.add(mensaje);
        System.out.println(mensaje);
    }

    public static void main(String[] args) {
        new MensajeException().asignarValor();
    }

}
