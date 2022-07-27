public class Ejercicio1 {
    public static void main(String[] args) {
        String[] ciudades = {
                "Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo",
                "Lima", "Santiago de Chile", "Lisboa", "Tokio"
        };
        int[][] temperaturas = new int[10][2];
        
        temperaturas[0][0] = -2;
        temperaturas[0][1] = 33;
        temperaturas[1][0] = -3;
        temperaturas[1][1] = 32;
        temperaturas[2][0] = -8;
        temperaturas[2][1] = 27;
        temperaturas[3][0] = 4;
        temperaturas[3][1] = 37;
        temperaturas[4][0] = 6;
        temperaturas[4][1] = 42;
        temperaturas[5][0] = 5;
        temperaturas[5][1] = 43;
        temperaturas[6][0] = 0;
        temperaturas[6][1] = 39;
        temperaturas[7][0] = -7;
        temperaturas[7][1] = 26;
        temperaturas[8][0] = -1;
        temperaturas[8][1] = 31;
        temperaturas[9][0] = -10;
        temperaturas[9][1] = 35;

        int minIndex = 0, maxIndex = 0;

        for(int i = 1; i<ciudades.length; i++){
            if(temperaturas[i][0]<temperaturas[minIndex][0]) minIndex = i;
            if(temperaturas[i][1]>temperaturas[maxIndex][1]) maxIndex = i;
        }

        System.out.printf("La menor temperatura la tuvo %s, con %dºC.\n", ciudades[minIndex], temperaturas[minIndex][0]);
        System.out.printf("La mayor temperatura la tuvo %s, con %dºC.\n", ciudades[maxIndex], temperaturas[maxIndex][1]);
    }
}
