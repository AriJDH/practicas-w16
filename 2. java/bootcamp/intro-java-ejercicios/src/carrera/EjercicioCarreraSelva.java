package carrera;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EjercicioCarreraSelva {

    Map<Integer, String> participantesCircuitoChico = new HashMap<>();
    Map<Integer, String> participantesCircuitoMedio = new HashMap<>();
    Map<Integer, String> participantesCircuitoAvanzado = new HashMap<>();

    public void inscribirParticipante(){

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese el id del participante: ");
        String id = entrada.nextLine();

        System.out.println("Ingrese número DNI: ");
        String dni = entrada.nextLine();

        System.out.println("Ingrese nombre: ");
        String nombre = entrada.nextLine();

        System.out.println("Ingrese apellido: ");
        String apellido = entrada.nextLine();

        System.out.println("Ingrese edad: ");
        String edad = entrada.nextLine();

        System.out.println("Ingrese celular: ");
        String celular = entrada.nextLine();

        System.out.println("Ingrese número de emergencia: ");
        String numeroEmergencia = entrada.nextLine();

        System.out.println("Ingrese grupo sanguineo: ");
        String grupoSanguineo = entrada.nextLine();

        System.out.println("Seleccione categoría: \n 1.Circuito chico \n 2.Circuito medio \n 3.Circuito Avanzado");
        String categoria = entrada.nextLine();

        String infoParticipante = "DNI: " + dni + "\n" + "Nombre: " + nombre + "\n" + "Apellido: " + apellido + "\n" + "Edad: " + edad + "\n" + "Celular: " + celular + "\n" + "Número emergencia: " + numeroEmergencia + "\n" + "Grupo Sanguineo: " + grupoSanguineo;

        String abono = "0";

        if(categoria.equals("1")){
            if(Integer.valueOf(edad) < 18){
                abono = "\n Abono: $1300";
            }else {
                abono = "\n Abono: $1500";
            }
            participantesCircuitoChico.put(Integer.valueOf(id), infoParticipante + abono);
        } else if (categoria.equals("2")) {
            if(Integer.valueOf(edad) < 18){
                abono = "\n Abono: $2000";
            }else {
                abono = "\n Abono: $2300";
            }
            participantesCircuitoMedio.put(Integer.valueOf(id), infoParticipante + abono);
        } else if (categoria.equals("3") && Integer.valueOf(edad) > 18) {
            abono = "\n Abono: $2800";
            participantesCircuitoAvanzado.put(Integer.valueOf(id), infoParticipante + abono);
        }


    }

    public String mostrarParticipanteCategoriaChico(){
        return Arrays.asList(participantesCircuitoChico).toString();
    }

    public String mostrarParticipanteCategoriaMedio(){
        return Arrays.asList(participantesCircuitoMedio).toString();
    }

    public String mostrarParticipanteCategoriaAvanzado(){
        return Arrays.asList(participantesCircuitoAvanzado).toString();
    }

    public void removerParticipanteCategoriaChico(String id){
        participantesCircuitoChico.remove(Integer.valueOf(id));
    }

    public void removerParticipanteCategoriaMedio(String id){
        participantesCircuitoMedio.remove(Integer.valueOf(id));
    }

    public void removerParticipanteCategoriaAvanzado(String id){
        participantesCircuitoAvanzado.remove(Integer.valueOf(id));
    }

    public static void main(String[] args) {

        EjercicioCarreraSelva ejer2 = new EjercicioCarreraSelva();

        Scanner entrada = new Scanner(System.in);
        boolean salir = false;
        int opcion = 0;



        while (!salir){
            System.out.println(" SELECCIONE UNA OPCIÓN: \n 1. Ingrese información participante \n 2. Mostrar participantes de categoria chico \n 3. Mostrar participantes de categoria Media \n 4. Mostrar participantes de categoria Avanzada \n 5. Eliminar participante de categoria chico \n 6. Eliminar participante de categoria medio \n 7. Eliminar participante de categoria Avanzada \n 8. Salir ");
            opcion = entrada.nextInt();

            switch (opcion){
                case 1:
                    ejer2.inscribirParticipante();
                    break;
                case 2:
                    System.out.println("Participantes categoria chico: ");
                    System.out.println(ejer2.mostrarParticipanteCategoriaChico());
                    break;
                case 3:
                    System.out.println("Participantes categoria medio: ");
                    System.out.println(ejer2.mostrarParticipanteCategoriaMedio());
                    break;
                case 4:
                    System.out.println("Participantes categoria avanzando: ");
                    System.out.println(ejer2.mostrarParticipanteCategoriaAvanzado());
                    break;
                case 5:
                    System.out.println("Ingrese el id del participante que desea eliminar de la categoria chico: ");
                    String id = entrada.next();
                    ejer2.removerParticipanteCategoriaChico(id);
                    System.out.println("Participante eliminado");
                    break;
                case 6:
                    System.out.println("Ingrese el id del participante que desea eliminar de la categoria medio: ");
                    String id2 = entrada.next();
                    ejer2.removerParticipanteCategoriaMedio(id2);
                    System.out.println("Participante eliminado");
                    break;
                case 7:
                    System.out.println("Ingrese el id del participante que desea eliminar de la categoria avanzado: ");
                    String id3 = entrada.next();
                    ejer2.removerParticipanteCategoriaAvanzado(id3);
                    System.out.println("Participante eliminado");
                    break;
                case 8:
                    salir=true;
                    break;
                default:
                    System.out.println("Opción no permitida");


            }
        }

        }

}
