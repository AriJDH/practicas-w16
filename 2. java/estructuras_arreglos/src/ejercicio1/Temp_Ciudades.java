package ejercicio1;

public class Temp_Ciudades {
    public static void main(String[] args) {

        //Se crea el arreglo de ciudades
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción",
                "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        //Se crea la matriz con las T° máximas y mínimas
        int[][] matrizTemperaturas = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        //Creamos dos listas auxiliares para almacenar las temperaturas mínimas y máximas
        int[] minimas = new int[10];
        int[] maximas = new int[10];

        System.out.println("");
        System.out.println("Vector Ciudades:");

        //Se imprime el arreglo de ciudades
        for (int x = 0; x < ciudades.length; x++) {
            if (x >= 0 && x < ciudades.length - 1) {
                System.out.print(ciudades[x] + ", ");
            } else {
                System.out.println(ciudades[x]);
            }
        }

        System.out.println("");
        System.out.println("Matriz Temperaturas:");

        //Se imprime la matriz
        for (int f = 0; f < matrizTemperaturas.length; f++) {
            for (int c = 0; c < matrizTemperaturas[f].length; c++) {
                if (matrizTemperaturas[f][c] >= 0) {
                    System.out.print(" " + matrizTemperaturas[f][c] + "  ");
                } else if (matrizTemperaturas[f][c] < -9) {
                    System.out.print(matrizTemperaturas[f][c] + " ");
                } else {
                    System.out.print(matrizTemperaturas[f][c] + "  ");
                }
                if (c == 1) {
                    System.out.println();
                }
            }
        }

        //Se recorre la matriz, asignando valores a las listas de temperaturas mínimas y máximas
        for (int j = 0; j < matrizTemperaturas.length; j++) {
            minimas[j] = matrizTemperaturas[j][0];
            maximas[j] = matrizTemperaturas[j][1];
        }

        /* Se recorre la lista de temperaturas mínimas, asignando a un par de
        variables la más pequeña de la lista, así como la ciudad en la que se registró */
        int valorMin = minimas[0];
        String ciudadMinima = "";
        for(int i = 0; i<minimas.length; i++){
            if(minimas[i] < valorMin){
                valorMin = minimas[i];
                ciudadMinima = ciudades[i];
            }
        }

        /* Se recorre la lista de temperaturas máximas, asignando a un par de
        variables la más alta de la lista, así como la ciudad en la que se registró */
        int valorMax = maximas[0];
        String ciudadMaxima = "";
        for(int l = 0; l< maximas.length; l++){
            if(maximas[l] > valorMax){
                valorMax = maximas[l];
                ciudadMaxima = ciudades[l];
            }
        }

        //Se imprime el resultado del ejercicio
        System.out.println();
        System.out.println("La temperatura más fría es de " + valorMin + " °C y se registró en la ciudad de " + ciudadMinima);
        System.out.println("La temperatura más alta es de " + valorMax + " °C y se registró en la ciudad de " + ciudadMaxima);
    }
}
