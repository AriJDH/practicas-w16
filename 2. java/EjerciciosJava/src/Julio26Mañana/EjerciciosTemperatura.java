package Julio26Mañana;

public class EjerciciosTemperatura {
    public static String ciudades[] = new String[10];
    public static int temperatura[][] = new int[10][2];

    public  static void initialize(){
        //ciudad
        ciudades[0]= "Londres";
        ciudades[1]= "Madrid";
        ciudades[2]= "Nueva York";
        ciudades[3]= "Buenos Aires";
        ciudades[4]= "Asunción";
        ciudades[5]= "São Paulo";
        ciudades[6]= "Lima";
        ciudades[7]= "Santiago de Chile";
        ciudades[8]= "Lisboa";
        ciudades[9]= "Tokio";
        //minima
        temperatura[0][0] = -2;
        temperatura[1][0] = -3;
        temperatura[2][0] = -8;
        temperatura[3][0] = 4;
        temperatura[4][0] = 6;
        temperatura[5][0] = 5;
        temperatura[6][0] = 0;
        temperatura[7][0] = -7;
        temperatura[8][0] = -1;
        temperatura[9][0] = -10;
        //maxima
        temperatura[0][1] = 33;
        temperatura[1][1] = 32;
        temperatura[2][1] = 27;
        temperatura[3][1] = 37;
        temperatura[4][1] = 42;
        temperatura[5][1] = 43;
        temperatura[6][1] = 39;
        temperatura[7][1] = 26;
        temperatura[8][1] = 31;
        temperatura[9][1] = 35;
    }

    public static void main(String[] args) {
        initialize();

        int menor =temperatura[0][0];
        int mayor =temperatura[0][1];
        String ciudadMenor =ciudades[0];
        String ciudadMayor =ciudades[0];
        for (int i =1;i<temperatura.length;i++){
            if(temperatura[i][0]< menor ){
                menor = temperatura[i][0];
                ciudadMenor = ciudades[i];
            }
            if ( temperatura[i][1]>mayor){
                mayor = temperatura[i][1];
                ciudadMayor = ciudades[i];
            }
        }
        System.out.println("La ciudad con la menor temperatura fue "+ciudadMenor+" con una tenperatura de "+menor);
        System.out.println("La ciudad con la mayor temperatura fue "+ciudadMayor+" con una temperatura de "+mayor);
    }
}
