package vectores_matrices;



public class EjercicioPracticoP1 {

    public static void main(String[] args) {
        //Declaracion e inicializacion de vector de ciudades y matriz de temperaturas

        String[] ciudades = new String[10];

        int[][] temperaturas = new int[10][2];

        // Carga manual de arreglos

        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asunción";
        ciudades[5] = "Sao Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

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

        //Metodo que recibiendo un vector de ciudades y una matriz de temperaturas imprime por consola ciudad que registra temperatura minima y dicha temperatur

            int tempMin = temperaturas[0][0];
            String ciudadTMin = "";

            for (int r=0; r<=9; r ++) { //recorro una a una las filas de la matriz de temperaturas
                for (int c=0; c<=1; c++){ //recorro las columnas de la matriz de temperatura
                    if (temperaturas [r][0] < tempMin) { //por cada iteracion controlo que si el siguiente es menor al asignado en tempMin. Si lo es reemplazo el valor de la variable por dicho valor;
                        tempMin = temperaturas [r][0]; //asigno a la variable tempMin el valor que se ecuentra en la matriz en el indice correspondiente
                        ciudadTMin = ciudades[r];
                    }
                }

            }
            System.out.println("La ciudad que registra la menor temperatura es: " + ciudadTMin + " con una temperatura de: " + tempMin);

        //Metodo que recibiendo un vector de ciudades y una matriz de temperaturas imprime por consola ciudad que registra temperatura maxima y dicha temperatura
            int tempMax = temperaturas[0][1];
            String ciudadTMax = "";
            //El proceso es el mismo que en tempMinima pero en este caso para la mayor temperatura registrada
            for (int r = 0; r <= 9; r++) {
                for (int c = 0; c <= 1; c++) {
                    if (temperaturas[r][c] > tempMax) {
                        tempMax = temperaturas[r][1];
                        ciudadTMax = ciudades[r];
                    }
                }
            }
            System.out.println("La ciudad que registra la mayor temperatura es: " + ciudadTMax + " con una temperatura de: " + tempMax);
        }
    }
