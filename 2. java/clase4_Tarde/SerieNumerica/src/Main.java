import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Serie2 serie2 = new Serie2();
        Serie3 serie3 = new Serie3();
        int ej;
        do {
            menuPrincipal();

            Scanner opcion = new Scanner(System.in);
            ej = opcion.nextInt();
            switch (ej) {
                case 1:
                    int opcionSerie2;
                    do{
                        menuSeries();
                        Scanner opcion2 = new Scanner(System.in);
                        opcionSerie2 = opcion2.nextInt();
                    }while(opcionSerie2<=0 || opcionSerie2>3);
                    if (opcionSerie2==1){
                        System.out.println("Ingresa el numero");
                        Scanner opcion3 = new Scanner(System.in);
                        int numeroSerie2 = opcion3.nextInt();
                        serie2.iniciarSerie(numeroSerie2);
                    }
                    else if (opcionSerie2==2){
                        serie2.siguienteNumero();
                    }
                    else
                        serie2.reiniciarSerie();
                    break;
                case 2:
                    int opcionSerie3;
                    do{
                        menuSeries();
                        Scanner opcion4 = new Scanner(System.in);
                        opcionSerie3 = opcion4.nextInt();
                    }while(opcionSerie3<=0 || opcionSerie3>3);
                    if (opcionSerie3==1){
                        System.out.println("Ingresa el numero");
                        Scanner opcion5 = new Scanner(System.in);
                        int numeroSerie3 = opcion5.nextInt();
                        serie3.iniciarSerie(numeroSerie3);
                    }
                    else if (opcionSerie3==2){
                        serie3.siguienteNumero();
                    }
                    else
                        serie3.reiniciarSerie();
                    break;
                default:
                    break;
            }
        }
        while (ej != 0);
    }

    public static void menuPrincipal(){
        System.out.println("************************************");
        System.out.println("*     Ingrese la opcion deseada    *");
        System.out.println("*     1- Serie 2                   *");
        System.out.println("*     2- Serie 3                   *");
        System.out.println("************************************");
    }
    public static void menuSeries(){
        System.out.println("************************************");
        System.out.println("*     Ingrese la opcion deseada    *");
        System.out.println("*     1-Iniciar serie              *");
        System.out.println("*     2-Siguiente Numero           *");
        System.out.println("*     3-Reiniciar Numero           *");
        System.out.println("************************************");
    }

}
