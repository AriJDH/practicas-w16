package vectoresYmatrices;

public class Ejemplo3 {
    public static void main(String[] args) {
        int table [][] = new int[3][3]; //declaracion e inicialización de matriz de 3f y 3c

        table[0][0]= 1;
        table[0][1]= 2;
        table[0][2]= 3;
        table[1][0]= 4;
        table[1][1]= 5;
        table[1][2]= 6;
        table[2][0]= 7;
        table[2][1]= 8;
        table[2][2]= 9;

        //un for para filas y otro para columnas
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.println("Fila: " + i + " Columna: " + j);
                System.out.println("Elemento de la matriz: " + table[i][j]);

            }

        }

    }
}
