package com.bootcamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Practica2 {


        List<String> mensajeStrings = new LinkedList<>();
        static List<Map> medio = new ArrayList<>();
        int[] serviciosCli = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios
        double totalFactura;
        int precioFijo=1500;

        public void calcularMontoFactura() {
            //Tu codigo aqui
            for (int i =0;i<serviciosCli.length;i++) {
                if (serviciosCli[i]==1) {
                    totalFactura=precioFijo;
                    imprimirMensaje("El tipo de servicio es: " + serviciosCli[i]);
                    imprimirMensaje ("El monto de la factura es de: " + totalFactura);
                }
                else {
                    totalFactura=precioFijo+700;
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
            Practica2 main=new Practica2();
            main.calcularMontoFactura();
        }

    }
