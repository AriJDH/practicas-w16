package vectoresYmatrices;

public class Ejemplo4 {

    public static void main(String[] args) {

        int matriz[][] = new int[3][3];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = (i * matriz.length) + (j + 1);
                System.out.println(matriz[i][j] + " ");
            }
            System.out.println("\n");
        }

    }
}
