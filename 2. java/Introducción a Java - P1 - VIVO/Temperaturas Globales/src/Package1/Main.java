package Package1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String ciudades[] = new String[10];
        double temperaturas[][] = new double[10][2];
        double tMin;
        double tMax;
        String cMin;
        String cMax;


        Scanner entrada = new Scanner(System.in);
        Scanner entrada2 = new Scanner(System.in);


        for (int f = 0; f <= 9; f++) {
            System.out.print(f +". Ingresa ciudad: ");
            ciudades[f] = entrada.nextLine();

            for (int c = 0; c <= 1; c++) {
                if (c == 0) {
                    System.out.print("Digita la temperatura minima de " + ciudades[f]+": ");
                    temperaturas[f][c] = entrada2.nextInt();
                } else {
                    System.out.print("Digita la temperatura máxima de " + ciudades[f]+ ": ");
                    temperaturas[f][c] = entrada2.nextInt();
                }
            }

        }

        tMin = temperaturas[0][0];
        cMin = ciudades[0];
        tMax = temperaturas[0][0];
        cMax = ciudades[0];

        for (int f = 0; f <= 9; f++) {
            for (int c = 0; c <= 1; c++) {

                if (temperaturas[f][c]<tMin){
                    tMin=temperaturas[f][c];
                    cMin=ciudades[f];
                }
                if (temperaturas[f][c]>tMax){
                    tMax=temperaturas[f][c];
                    cMax=ciudades[f];
                }

            }

        }
        System.out.println("Ciudad con la temperatura más baja: " + cMin + " Temperatura: " + tMin);
        System.out.println("Ciudad con la temperatura más alta: " + cMax + " Temperatura: " + tMax);
    }
}
