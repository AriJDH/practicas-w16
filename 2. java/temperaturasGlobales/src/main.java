import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        String ciudades [] = new String[10];
        double temperaturas[][] = new double[10][2];
        double temperatura_minima, temperatura_maxima;
        String ciudad_temperatura_minima, ciudad_temperatura_maxima;

        Scanner teclado_ciudad = new Scanner(System.in);
        Scanner teclado_temperatura = new Scanner(System.in);

        for (int i=0; i<10;i++){
            System.out.println("Ingrese el nombre de la ciudad");
            ciudades[i]=teclado_ciudad.nextLine();

            for (int j =0;j<2;j++){
                if (j==0){
                    System.out.println("Ingrese la temperatura mínima para la ciudad " + ciudades[i]);
                    temperaturas[i][j]=teclado_temperatura.nextInt();
                }else{
                    System.out.println("Ingrese la temperatura máxima para la ciudad " + ciudades[i]);
                    temperaturas[i][j]=teclado_temperatura.nextInt();
                }
            }
        }

        temperatura_minima = temperaturas[0][0];
        temperatura_maxima = temperaturas[0][0];
        ciudad_temperatura_minima=ciudades[0];
        ciudad_temperatura_maxima=ciudades[0];

        for (int i=0;i<10;i++){
            for (int j=0;j<2;j++){
                if (temperatura_minima>temperaturas[i][j]){
                    temperatura_minima=temperaturas[i][j];
                    ciudad_temperatura_minima=ciudades[i];
                }
                if (temperatura_maxima<temperaturas[i][j]){
                    temperatura_maxima=temperaturas[i][j];
                    ciudad_temperatura_maxima=ciudades[i];
                }
            }
        }


        System.out.println("La ciudad que registró la temperatura más baja fue " + ciudad_temperatura_minima + " con una mínima de " + temperatura_minima);
        System.out.println("La ciudad que registró la temperatura más alta fue " + ciudad_temperatura_maxima + " con una maxima de " + temperatura_maxima);


    }
}
