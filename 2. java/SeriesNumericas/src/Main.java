import java.util.Scanner;

public class Main {
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        SerieDos serieDos = new SerieDos();
        SerieTres serieTres = new SerieTres();

        Integer opcionMenu = imprimirMenu();

        do {
            if (opcionMenu == 1) {
                Integer opcionSeriesDos = 0;
                do {
                    opcionSeriesDos = imprimirSeries();
                    if (opcionSeriesDos == 1) {
                        System.out.print("Ingrese el numero para iniciar la serie: ");
                        serieDos.iniciarSerie(leer.nextInt());
                    } else if (opcionSeriesDos == 2) {
                        serieDos.siguienteNumero();
                    } else if (opcionSeriesDos == 3) {
                        serieDos.reiniciarSerie();
                    }
                } while (opcionSeriesDos != 4);
            } else if (opcionMenu == 2) {
                Integer opcionSeriesTres = 0;
                do {
                    opcionSeriesTres = imprimirSeries();
                    if (opcionSeriesTres == 1) {
                        System.out.print("Ingrese el numero para iniciar la serie: ");
                        serieTres.iniciarSerie(leer.nextInt());
                    } else if (opcionSeriesTres == 2) {
                        serieTres.siguienteNumero();
                    } else if (opcionSeriesTres == 3) {
                        serieTres.reiniciarSerie();
                    }
                } while (opcionSeriesTres != 4);
            } else {
                System.out.println("Opción incorrecta.");

            }
        } while (opcionMenu != 3);
    }

    public static Integer imprimirMenu() {
        System.out.println("1. Serie dos");
        System.out.println("2. Serie tres");
        System.out.println("3. Salir");
        System.out.print("Ingrese la opcion deseada: ");
        return leer.nextInt();
    }

    public static Integer imprimirSeries() {
        System.out.println("1. Iniciar serie");
        System.out.println("2. Siguiente numero");
        System.out.println("3. Reiniciar serie");
        System.out.println("4. Salir");
        System.out.print("Ingrese la opcion deseada: ");
        return leer.nextInt();
    }
}
