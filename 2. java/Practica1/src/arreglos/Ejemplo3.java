package arreglos;

public class Ejemplo3 {
    public static void main(String[] args) {
        int matriz [][] = new int[3][3];
        // i -> Filas j -> Columnas
        for (int i = 0; i< matriz.length; i++){
            for (int j = 0; j<matriz[0].length;j++){
                matriz[i][j] = (i*matriz.length) + (j+1);
                System.out.print(matriz[i][j] + " ") ;
            }
            System.out.println();
        }
    }
}
