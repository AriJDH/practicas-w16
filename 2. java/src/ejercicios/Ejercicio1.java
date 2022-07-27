package ejercicios;

public class Ejercicio1 {
    public static void main(String[] args) {
        String ciudades[] = {"londres", "madrid", "nueva york", "buenos aires", "asuncion","sao paolo", "lima","santiago de chile", "lisboa", "tokio"};
        int temperaturas[][] = {{-2,33},{-3,32},{-8,27},{4,37}};
        int mayor =0, menor =1000000;
        String ciudadMayor = "", ciudadMenor = "";

        for(int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                if(temperaturas[i][j] > mayor) {
                    mayor = temperaturas[i][j];
                    ciudadMayor = ciudades[i];
                }

                if (temperaturas[i][j] < menor) {
                    menor = temperaturas[i][j];
                    ciudadMenor = ciudades[i];
                }
            }
        }
        System.out.println("menor temperatura: "+menor + " " + ciudadMenor);
        System.out.println("mayor temperatura: "+mayor + " " + ciudadMayor);
    }
}
