import java.util.Scanner;

public class TemperaturasGlobales {

    public static void main(String[] args) {

        String ciudades[] = new String[10];
        int temps[][] = new int[10][2];
        int menorTemp=0, mayorTemp=0;
        String menorCiudad="", mayorCiudad="";
        Scanner scan = new Scanner(System.in);

        for(int i = 0; i < ciudades.length; i++){
            System.out.println("Ingrese nombre de ciudad: ");
            ciudades[i] = scan.nextLine();
        }

        for(int i = 0; i < temps.length; i++){
            System.out.println("---------------------------");
            System.out.println("Temperaturas de " + ciudades[i]);
            for(int j = 0; j < temps[0].length; j++){
                System.out.println("Ingrese temperatura: ");
                temps[i][j] = scan.nextInt();
                if((i == 0 && j == 0) || (j == 0 && temps[i][j] < menorTemp)){
                    menorCiudad = ciudades[i];
                    menorTemp = temps[i][j];
                } else if((i == 0 && j == 1) || (j == 1 && temps[i][j] > mayorTemp)){
                    mayorCiudad = ciudades[i];
                    mayorTemp = temps[i][j];
                }
            }
        }

        scan.close();

        System.out.println("La mayor temperatura la tuvo " + mayorCiudad + ", con " + mayorTemp + " ºC.");
        System.out.println("La menor temperatura la tuvo " + menorCiudad + ", con " + menorTemp + " ºC.");

    }

}
