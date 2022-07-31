package juego;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        List<String> participantes = new ArrayList<String>();
        List<String> distancias = new ArrayList<String>();

        NaveSimple nave1 = new NaveSimple("Indestructible", 3, 8);
        NaveSimple nave2 = new NaveSimple("Inmortal", 3, 8);
        NaveSimple nave3 = new NaveSimple("Evasor", 3, 8);
        NaveSimple nave4 = new NaveSimple("Noctambulo", 3, 8);
        NaveSimple nave5 = new NaveSimple("Invencible", 3, 8);
        NaveSimple nave6 = new NaveSimple("Vengador", 3, 8);

        List<NaveSimple> naves1 = Arrays.asList(new NaveSimple[]{nave1, nave2, nave3});
        flota_naves flota1 = new flota_naves(naves1);

        List<NaveSimple> naves2 = Arrays.asList(new NaveSimple[]{nave4, nave5, nave6});
        flota_naves flota2 = new flota_naves(naves2);


        System.out.println("Bienvenido al juego ASTEROID");
        System.out.println("Ingrese el número de participantes");

        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        int coordenadas[][] = new int[num][2];
        double min = 100000;

        for (int i=0; i<num; i++){
            double sum_distancia = 0;
            System.out.println("Ingrese el nombre del participante: "+(i+1));
            participantes.add(input.nextLine());
            System.out.println("Ingrese las coordenadas de tu blanco: "+(i+1));
            System.out.println("Ingrese la coordenada en x: ");
            int x = input.nextInt();
            System.out.println("Ingrese la coordenada en y: ");
            int y = input.nextInt();
            coordenadas[i][0] = x;
            coordenadas[i][1] = y;
            sum_distancia = nave1.calcularDistancia(x,y) + nave2.calcularDistancia(x,y) + nave3.calcularDistancia(x,y) + nave4.calcularDistancia(x,y) + nave5.calcularDistancia(x,y) + nave6.calcularDistancia(x,y) + flota1.calcularDistancia(x,y) + flota2.calcularDistancia(x,y);

        }



    }

}
