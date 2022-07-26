package practica.temperatura;

public class Temperatura {

    public static void main(String[] args) {
        String[] ciudades = new String[10];
        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asuncion";
        ciudades[5] = "Sao Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";
        int[][] temperaturas = new int[10][2];
        temperaturas[0][0] = -2;
        temperaturas[0][1] = 33;
        temperaturas[1][0] = -3;
        temperaturas[1][1] = 32;
        temperaturas[2][0] = -8;
        temperaturas[2][1] = -27;
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

        // decidi utilizar vectores (para mayor y menor temperatura) para guardar en la primer posicion el indice que corresponde a la ciudad,
        // y en la segunda posicion el valor de la temperatura
        int[] menorTemp = new int[2];
        int[] mayorTemp = new int[2];
        menorTemp[1] = temperaturas[0][0];
        mayorTemp[1] = temperaturas[0][1];
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i][0] < menorTemp[1]) {
                menorTemp[0] = i;
                menorTemp[1] = temperaturas[i][0];
            }
            if (temperaturas[i][1] > mayorTemp[1]) {
                mayorTemp[0] = i;
                mayorTemp[1] = temperaturas[i][1];
            }
        }
        System.out.println("Mayor temperatura: " + mayorTemp[1] + " en: " + ciudades[mayorTemp[0]]);
        System.out.println("Menor temperatura: " + menorTemp[1] + " en: " + ciudades[menorTemp[0]]);
    }
}
