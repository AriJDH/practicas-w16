package practica_2.Selva;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Carrera carrera = new Carrera();
        Scanner teclado = new Scanner(System.in);
        int exitNumber = 1;

        while (exitNumber != 0){

            mostrarMenu();
            exitNumber = teclado.nextInt();

            if(exitNumber != 0){
                switch (exitNumber){
                    case 1: {
                        System.out.println("\n\n\n\n");
                        System.out.println("Seleccionaste inscribir a un nuevo participante");
                        mostrarMenuCircuito();
                        int tipoCircuito = teclado.nextInt();
                        System.out.println("Vamos a inscribir a un participante");
                        carrera.inscribirParticipante(teclado,tipoCircuito);
                        System.out.println("\n\n\n\n");
                        break;
                    }
                    case 2: {
                        System.out.println("\n\n\n\n");
                        System.out.println("Seleccionaste mostrar todos los participantes");
                        carrera.mostrarParticipantes();
                        System.out.println("\n\n\n\n");
                        break;
                    }
                    case 3: {
                        if(carrera.cantidadParticipante()>0){
                            System.out.println("\n\n\n\n");
                            System.out.println("Seleccionaste desinscribir a un participante");
                            mostrarMenuCircuito();
                            int tipoCircuito = teclado.nextInt();
                            System.out.println("digita el id del participante");
                            int id = teclado.nextInt();
                            carrera.desinscribirParticipante(tipoCircuito,id);
                            System.out.println("\n\n\n\n");
                        }else{
                            System.out.println("No hay participantes inscritos");
                            System.out.println("\n\n\n\n");
                        }
                        break;
                    }
                    default:{
                        break;
                    }
                }
                System.out.println("Deseas seguir? ");
                System.out.println("1) Si.");
                System.out.println("0) No.");
                System.out.print("Selección: ");
                exitNumber = teclado.nextInt();
            }
            else{
                ASCIIArtService.printConsole("Bye bye");
            }
        }


    }

    public static void mostrarMenu(){
        System.out.println("==================================");
        System.out.println("====           MENU           ====");
        System.out.println("==================================");
        System.out.println();
        System.out.println("Digita la opción de lo que quieres hacer");
        System.out.println("1) Inscribir nuevo participante");
        System.out.println("2) Mostrar todos los inscritos");
        System.out.println("3) Desinscribir a un participante");
        System.out.println("0) salir. ");
        System.out.print("Selección: ");
    }

    public static void mostrarMenuCircuito(){
        System.out.println("digita en que tipo de circuito esta inscrito");
        System.out.println("1) Circuito chico");
        System.out.println("2) Circuito medio");
        System.out.println("3) Circuito avanzado");
        System.out.print("Tipo de circuito: ");
    }

    public static void bucleProgram(Scanner teclado, Carrera carrera){

    }

}

