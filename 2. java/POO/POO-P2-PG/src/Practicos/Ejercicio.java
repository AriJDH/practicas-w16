/* package Practicos;

import java.util.LinkedList;
import java.util.List;
    public class Ejercicio {
        List<String> mensajeStrings = new LinkedList<>();
        //Mensaje final
        String mensajeFinal = "Este es el último mensaje";

        int[] numeros = new int[5];

        public void asignarValor() {
            try{
                numeros[5] = 10;
            }
            catch (IndexOutOfBoundsException e){
                imprimirMensaje(e.getMessage());
            }
            finally {
                imprimirMensaje(mensajeFinal);
            }

        }

        private void imprimirMensaje(String mensaje) {
            mensajeStrings.add(mensaje);
            System.out.println(mensaje);
        }

    } */
