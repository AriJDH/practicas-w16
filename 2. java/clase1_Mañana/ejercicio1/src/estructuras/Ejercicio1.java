package estructuras;


public class Ejercicio1 {
    public static void main(String [] args){
        int menor_Temperatura = 99;
        int mayor_Temperatura = 0;
        String ciudadMenor=null;
        String ciudadMayor= null;
        String ciudades[] = new String [10];
        city(ciudades);

        int temperaturas[][] = new int[10][10];
        temperature(temperaturas);

        for (int i = 0;i < ciudades.length;i++){
            if (menor_Temperatura > temperaturas[i][0]){
                ciudadMenor = ciudades[i];
                menor_Temperatura= temperaturas[i][0];
            }
        }
        for (int i = 0;i < ciudades.length;i++){
            if (mayor_Temperatura < temperaturas[i][1]){
                ciudadMayor = ciudades[i];
                mayor_Temperatura= temperaturas[i][1];
            }
        }

        System.out.println("La menor temperatura la tuvo "+ ciudadMenor + " con "+ menor_Temperatura + "°C");
        System.out.println("La mayor temperatura la tuvo "+ ciudadMayor + " con "+ mayor_Temperatura + "°C");
    }

    private static void temperature(int[][] temperaturas) {
        temperaturas[0][0]=-2;
        temperaturas[0][1]=33;
        temperaturas[1][0]=-3;
        temperaturas[1][1]=32;
        temperaturas[2][0]=-8;
        temperaturas[2][1]=27;
        temperaturas[3][0]=4;
        temperaturas[3][1]=37;
        temperaturas[4][0]=6;
        temperaturas[4][1]=42;
        temperaturas[5][0]=5;
        temperaturas[5][1]=43;
        temperaturas[6][0]=0;
        temperaturas[6][1]=39;
        temperaturas[7][0]=-7;
        temperaturas[7][1]=26;
        temperaturas[8][0]=-1;
        temperaturas[8][1]=31;
        temperaturas[9][0]=-10;
        temperaturas[9][1]=35;
    }

    private static void city(String[] ciudades) {
        ciudades[0]="Londres";
        ciudades[1]="Madrid";
        ciudades[2]="Nueva York";
        ciudades[3]="Buenos Aires";
        ciudades[4]="Asuncion";
        ciudades[5]="San Pablo";
        ciudades[6]="Lima";
        ciudades[7]="Santiago de chile";
        ciudades[8]="Lisboa";
        ciudades[9]="Tokio";
    }
}
