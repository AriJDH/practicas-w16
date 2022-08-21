package JavaP2PG;

import java.util.LinkedList;
import java.util.List;

public class Ejercicio2 {

    // Este tipo de dato sera visto en la siguiente clase en vivo
    List<String> mensajeStrings = new LinkedList<>();

    int[] serviciosCli = {1, 1, 2, 2, 2, 1, 2}; //vector de 7 posiciones con tipos de servicios
    double totalFactura;
    double servicio1 = 1500;
    double servicio2 = servicio1 + 700;

    public void calcularMontoFactura() {
        //Tu codigo aqui
        for (int i = 0; i < serviciosCli.length; i++) {
            if (serviciosCli[i] == 1) {
                imprimirMensaje("El tipo de servicio es: " + serviciosCli[i]);
                totalFactura = servicio1;
                imprimirMensaje("El monto de la factura es de: " + totalFactura);
            } else {
                imprimirMensaje("El tipo de servicio es: " + serviciosCli[i]);
                totalFactura = servicio2;
                imprimirMensaje("El monto de la factura es de: " + totalFactura);
            }
        }
    }

    private void imprimirMensaje(String mensaje) {
        mensajeStrings.add(mensaje);
        System.out.println(mensaje);
    }

    public static void main(String[] args) {
        new Ejercicio2().calcularMontoFactura();
    }
}
