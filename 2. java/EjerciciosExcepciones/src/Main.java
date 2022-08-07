import java.util.LinkedList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        asignarValor();
    }
    static List<String> mensajeStrings = new LinkedList<>();
    //Mensaje final
    int numero = 0;
    static String mensajeFinal = "Este es el último mensaje";

    static int[] numeros = new int[5];
    public static void asignarValor() {
        try{
            numeros[5] = 10;
        }catch(ArrayIndexOutOfBoundsException exception){
            System.out.println("error" + exception.getMessage());
        }finally{
           imprimirMensaje(mensajeFinal);
        }
    }
    private static void imprimirMensaje(String mensaje) {
        mensajeStrings.add(mensaje);
        System.out.println(mensaje);
    }


}
