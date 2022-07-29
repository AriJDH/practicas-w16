package introduccionJavaP1;

public class TemperaturaGlobal {
    public static void main(String[] args) {
        String paises[] = new String[10];

        paises[0]="Londres";
        paises[1]="Madrid";
        paises[2]="Nueva York";
        paises[3] = "Buenos Aires";
        paises[4] = "Asunción";
        paises[5] = "Sao Paulo";
        paises[6] = "Lima";
        paises[7] = "Santiago de Chile";
        paises[8] = "Lisboa";
        paises[9] = "Tokio";

        int temperaturas[][] = new int[2][10];

        temperaturas[0][0] = -2;
        temperaturas[0][1] = -3;
        temperaturas[0][2] = -8;
        temperaturas[0][3] = 4;
        temperaturas[0][4] = 6;
        temperaturas[0][5] = 5;
        temperaturas[0][6] = 0;
        temperaturas[0][7] = -7;
        temperaturas[0][8] = -1;
        temperaturas[0][9] = -10;

        temperaturas[1][0] = 33;
        temperaturas[1][1] = 32;
        temperaturas[1][2] = 27;
        temperaturas[1][3] = 37;
        temperaturas[1][4] = 42;
        temperaturas[1][5] = 43;
        temperaturas[1][6] = 39;
        temperaturas[1][7] = 26;
        temperaturas[1][8] = 31;
        temperaturas[1][9] = 35;

        int temperaturaMenor=temperaturas[0][0];
        int temperaturaMayor=temperaturas[1][0];
        String paisTemperaturaBaja="";
        String paisTemperaturaAlta="";

        for(int i=0;i<10;i++){
            for(int j=0;j<2;j++){
                if(j==0){
                    if(temperaturaMenor>temperaturas[0][i]){
                        temperaturaMenor=temperaturas[0][i];
                        paisTemperaturaBaja = paises[i];
                    }
                }else{
                    if(temperaturaMayor<temperaturas[1][i]){
                        temperaturaMayor=temperaturas[1][i];
                        paisTemperaturaAlta = paises[i];
                    }
                }
            }
        }

        System.out.println("La temperatura mas baja es: " + temperaturaMenor + " y esta en el pais: " + paisTemperaturaBaja);
        System.out.println("La temperatura mas alta es: " + temperaturaMayor + " y esta en el pais: " + paisTemperaturaAlta);


    }
}
