public class EjercicoPractico {


    public static void main (String[] args){
        String [] vectorCiudades = new String[]{"Londres" ,"Madrid","Nueva York","Buenos Aires","Asunción","São Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int [][] temperaturas = new int[][]{{-2, -3, -8, 4, 6, 5, 0, -7, -1, -10}, {33, 32, 27, 37, 42, 43, 39, 26, 31, 35}};
        String ciudadMayorTemperatura="";
        String ciudadMenorTemperatura="";
        int mayorTemperatura = temperaturas[0][0];
        int menorTemperatura = temperaturas[0][0];
        //System.out.println(temperaturas[][]);
        for (int i=0 ; i<2; i++){
            for (int j=0; j< 10;j++){
                if(temperaturas[i][j]<menorTemperatura){
                    menorTemperatura = temperaturas[i][j];
                    ciudadMenorTemperatura = vectorCiudades[j];
                }
                if (temperaturas[i][j]>mayorTemperatura){
                    mayorTemperatura= temperaturas[i][j];
                    ciudadMayorTemperatura = vectorCiudades[j];
                }
            }
        }

        System.out.println("La menor temperatura la tuvo "+ ciudadMenorTemperatura+", con "+ menorTemperatura+" º C.");
        System.out.println("La mayor temperatura la tuvo "+ ciudadMayorTemperatura+", con "+ mayorTemperatura+" º C.");

    }



}




