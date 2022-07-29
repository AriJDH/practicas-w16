package practica.temperatura;

public class Temperatura {

    public static void main(String[] args) {
        String[] test = {"Test", "d"};
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperaturas = {{-2, 33}, {-3, 32}, {-8, -27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

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
