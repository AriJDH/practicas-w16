package Estructuras;
import java.util.LinkedList;
import java.util.List;

public class Facturas {

        // Este tipo de dato sera visto en la siguiente clase en vivo
        LinkedList<String> mensajeStrings = new LinkedList<String>();

        int[] serviciosCli = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios
        double totalFactura;

        public void calcularMontoFactura() {
            //Tu codigo aqui
            for (int i=0;i<serviciosCli.length;i++) {
                if (serviciosCli[i]==1) {

                    totalFactura = 1500;
                    imprimirMensaje("El tipo de servicio es: " + serviciosCli[i]);
                    imprimirMensaje ("El monto de la factura es de: " + totalFactura);
                }
                else {
                    totalFactura = 2200;
                    imprimirMensaje("El tipo de servicio es: " + serviciosCli[i]);
                    imprimirMensaje("El monto de la factura es de: " + totalFactura);
                }
            }
        }

        private void imprimirMensaje(String mensaje) {
            mensajeStrings.add(mensaje);
            System.out.println(mensaje);
        }

        public static void main(String[] args) {
            new Facturas().calcularMontoFactura();
        }

    }


