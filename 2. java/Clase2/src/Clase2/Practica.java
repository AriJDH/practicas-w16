package Clase2;

import java.util.*;

public class Practica {

    public static List<Map<String, String>> small = new ArrayList<Map<String, String>>();
    public static List<Map<String, String>> medium = new ArrayList<Map<String, String>>();
    public static List<Map<String, String>> advanced = new ArrayList<Map<String, String>>();


    public static void AddParticipant() {
        Map<String, String> participant = new HashMap<String, String>();

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Seleccione una carrera");
        System.out.println("1 carrera corta");
        System.out.println("2 carrera media");
        System.out.println("3 carrera avanzada");
        int selectedRace = keyboard.nextInt();
        participant.put("Numero Inscripcion", "1");
        participant.put("Nombre", "Pedro");
        participant.put("Apellido", "Picapiedra");
        participant.put("Dni", "111");
        participant.put("Edad", "18");
        participant.put("NumeroEmergencia", "18888");
        participant.put("GrupoSanguineo", "A+");

        switch (selectedRace) {
            case 1:
                small.add(participant);
                break;
            case 2:
                medium.add(participant);
                break;
            case 3:
                advanced.add(participant);
                break;
            default:
                System.out.println("Carrera incorrecta.");
        }
    }
    public static void ListParticipants() {
        int numList = 0;
        Scanner keyboard = new Scanner(System.in);

        do{
            System.out.println("Presione un numero para listar unos participantes: ");
            System.out.println("1 listar participantes de carrera corta");
            System.out.println("2 listar participantes de carrera media");
            System.out.println("3 listar participantes de carrera avanzada");
            System.out.println("0 para salir");

            numList = keyboard.nextInt();

            switch (numList) {
                case 1:
                    System.out.println(small);
                    break;
                case 2:
                    System.out.println(medium);
                    break;
                case 3:
                    System.out.println(advanced);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Carrera incorrecta.");
            }
        }while(numList != 0);
    }

    public static void main(String[] args) {
        int num = 0;

        Scanner keyboard = new Scanner(System.in);

        do{
            System.out.println("Presione un numero para realizar una acción: ");
            System.out.println("1 para agregar un participante: ");
            System.out.println("2 para listar participantes: ");
            System.out.println("0 para salir");

            num = keyboard.nextInt();
            switch (num) {
                case 1:
                    AddParticipant();
                    break;
                case 2:
                    ListParticipants();
                    break;
                case 0:

                    break;
                default:
                    System.out.println("Carrera incorrecta.");
            }
        }while(num != 0);

        keyboard.close();

    }
}
