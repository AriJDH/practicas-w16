//Una empresa de servicios de seguridad tiene 7 clientes que todos los meses abonan la cuota de dos posibles tipos de servicio:
//
// Servicio 1: Seguridad con cámaras - Precio Fijo de $1500 al mes
// Servicio 2: Seguridad con cámaras + patrullaje - Precio de $1500 + $700 por el servicio de patrullaje
//
//Dependiendo del tipo de servicio, se desea poder calcular el monto final de la factura para cada uno de los clientes.
// Tener en cuenta, que existe un vector en donde se almacena el tipo de servicio que cada cliente adquirió.

package EstructurasDeControlYArreglos;
import java.util.LinkedList;
import java.util.List;

public class ClaseCalcularMontoFactura {
    // Este tipo de dato será visto en la siguiente clase en vivo
    List<String> mensajeStrings = new LinkedList<>();

    int[] serviciosCli = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios
    double totalFactura;
    int servicio1 =1500;
    int servicio2 =1500;

    public void calcularMontoFactura() {
        //Tu código aquí

//        for () {
//            if () {
//                imprimirMensaje("El tipo de servicio es: " + serviciosCli[i]);
//                imprimirMensaje ("El monto de la factura es de: " + totalFactura);
//            }
//            else {
//                imprimirMensaje("El tipo de servicio es: " + serviciosCli[i]);
//                imprimirMensaje("El monto de la factura es de: " + totalFactura);
//            }
//        }
    }

    private void imprimirMensaje(String mensaje) {
        mensajeStrings.add(mensaje);
        System.out.println(mensaje);
    }

    public static void main(String[] args) {
        new ClaseCalcularMontoFactura().calcularMontoFactura();
    }

}