package carreraDeLaSelva;

import java.util.*;

/*
 * Ejercicio > Modulo 5: Java > IntroduccionAJava-P2-VIVO
 * ESTADO: Finalizado.
 * @GonzaloNahuelDiPierro
 * */
public class Main {
    private static List<Map<String,String>> participantSmallCircuitList = new ArrayList();
    private static List<Map<String,String>> participantMediumCircuitList = new ArrayList();
    private static List<Map<String,String>> participantAdvancedCircuitList = new ArrayList();
    private static final int ID_SMALL_CIRCUIT = 1;
    private static final int ID_MEDIUM_CIRCUIT = 2;
    private static final int ID_ADVANCED_CIRCUIT = 3;

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args){
        while(true){
            System.out.println("MENU PRINCIPAL");
            System.out.println("1. Inscribir nuevo participante.");
            System.out.println("2. Mostrar inscriptos.");
            System.out.println("3. Desinscribir participante.");
            System.out.println("[!] Presione cualquier otra tecla para salir.");
            String option = SCANNER.next();

            switch(option){
                case "1": menuRegisterNewParticipant();
                    break;
                case "2": menuShowParticipantList();
                    break;
                case "3": menuUnsuscribeParticipant();
                    break;
                default:
                    SCANNER.close();
                    System.exit(0);
                    break;
            }
        }
    }

    private static void menuRegisterNewParticipant(){
        System.out.println("INSCRIBIR NUEVO PARTICIPANTE");

        Map<String,String> participantDataMap = new HashMap();
        participantDataMap.put("ACTIVE", "YES");

        System.out.println("- DNI:");
        participantDataMap.put("DNI", SCANNER.next());

        System.out.println("- Nombre:");
        participantDataMap.put("NAME", SCANNER.next());

        System.out.println("- Apellido:");
        participantDataMap.put("LASTNAME", SCANNER.next());

        System.out.println("- Edad:");
        int ageInput = SCANNER.nextInt();
        participantDataMap.put("AGE", String.valueOf(ageInput));

        System.out.println("- Celular:");
        participantDataMap.put("MOBILE_PHONE", SCANNER.next());

        System.out.println("- Número de emergencia:");
        participantDataMap.put("EMERGENCY_NUMBER", SCANNER.next());

        System.out.println("- Grupo sanguíneo:");
        participantDataMap.put("BLOOD_TYPE", SCANNER.next());

        int idCircuitSelected;
        do{
            System.out.println("- Circuito en el que participará:");
            System.out.println("1. Circuito chico: Menores de 18 años $1300. Mayores de 18 años $1500.");
            System.out.println("2. Circuito medio: Menores de 18 años $2000. Mayores de 18 años $2300.");
            System.out.println("3. Circuito avanzado: No se permiten inscripciones a menores de 18 años. Mayores de 18 años $2800.");
            idCircuitSelected = SCANNER.nextInt();

            if(existParticipant(participantDataMap.get("DNI"))){
                System.out.println("> ERROR: el participante ya está inscripto en uno de los circuitos.");
            }else if(idCircuitSelected == ID_ADVANCED_CIRCUIT && ageInput < 18){
                System.out.println("> ERROR: en el circuito avanzado no pueden participar menores de edad.");
            }else{
                boolean successfulInscription = false;
                switch (idCircuitSelected){
                    case ID_SMALL_CIRCUIT:
                        participantDataMap.put("AMOUNT_TO_PAY", String.valueOf(calculateAmount(ID_SMALL_CIRCUIT, ageInput)));
                        participantDataMap.put("INSCRIPTION_NUMBER", String.valueOf(participantSmallCircuitList.size() + 1));
                        successfulInscription = participantSmallCircuitList.add(participantDataMap);
                        break;
                    case ID_MEDIUM_CIRCUIT:
                        participantDataMap.put("AMOUNT_TO_PAY", String.valueOf(calculateAmount(ID_MEDIUM_CIRCUIT, ageInput)));
                        participantDataMap.put("INSCRIPTION_NUMBER", String.valueOf(participantMediumCircuitList.size() + 1));
                        successfulInscription = participantMediumCircuitList.add(participantDataMap);
                        break;
                    case ID_ADVANCED_CIRCUIT:
                        participantDataMap.put("AMOUNT_TO_PAY", String.valueOf(calculateAmount(ID_ADVANCED_CIRCUIT, ageInput)));
                        participantDataMap.put("INSCRIPTION_NUMBER", String.valueOf(participantAdvancedCircuitList.size() + 1));
                        successfulInscription = participantAdvancedCircuitList.add(participantDataMap);
                        break;
                    default:
                        System.out.println("> ERROR: el circuito seleccionado no es válido.");
                        break;
                }

                if(successfulInscription){
                    System.out.println("> ¡El participante fue inscripto correctamente! Nª de inscripción: " + participantDataMap.get("INSCRIPTION_NUMBER") +
                                       ". Monto a pagar: $" + participantDataMap.get("AMOUNT_TO_PAY") + ".");
                }else{
                    System.out.println("> ERROR: la inscripción no pudo realizarse correctamente. Vuelva a intentarlo.");
                }
            }
        }while(idCircuitSelected != ID_SMALL_CIRCUIT && idCircuitSelected != ID_MEDIUM_CIRCUIT && idCircuitSelected != ID_ADVANCED_CIRCUIT ||
              (idCircuitSelected == ID_ADVANCED_CIRCUIT && ageInput < 18));
    }

    private static boolean existParticipant(String dni){
        boolean existParticipant = false;

        // Lista de participantes del Circuito Chico
        for(Map<String,String> participantMap: participantSmallCircuitList){
            if(participantMap.get("DNI").equals(dni) && participantMap.get("ACTIVE").equals("YES"))
                existParticipant = true;
            break;
        }

        // Lista de participantes del Circuito Medio
        for(Map<String,String> participantMap: participantMediumCircuitList){
            if(participantMap.get("DNI").equals(dni) && participantMap.get("ACTIVE").equals("YES"))
                existParticipant = true;
            break;
        }

        // Lista de participantes del Circuito Avanzado
        for(Map<String,String> participantMap: participantAdvancedCircuitList){
            if(participantMap.get("DNI").equals(dni) && participantMap.get("ACTIVE").equals("YES"))
                existParticipant = true;
            break;
        }

        return existParticipant;
    }

    private static double calculateAmount(int idCircuit, int age){
        double amount = 0.0;
        switch (idCircuit){
            case ID_SMALL_CIRCUIT:
                amount = (age < 18) ? 1300.0 : 1500.0;
                break;
            case ID_MEDIUM_CIRCUIT:
                amount = (age < 18) ? 2000.0 : 2300.0;
                break;
            case ID_ADVANCED_CIRCUIT:
                amount = 2800.0;
                break;
        }

        return amount;
    }

    private static void menuShowParticipantList(){
        System.out.println("MOSTRAR INSCRIPTOS");

        int idCircuitSelected = 0;
        do{
            System.out.println("- Ingresar el circuito del cual desea obtener la lista de participantes:");
            System.out.println("1. Circuito chico.");
            System.out.println("2. Circuito medio.");
            System.out.println("3. Circuito avanzado.");
            idCircuitSelected = SCANNER.nextInt();

            switch (idCircuitSelected){
                case ID_SMALL_CIRCUIT: printParticipantList(participantSmallCircuitList);
                    break;
                case ID_MEDIUM_CIRCUIT: printParticipantList(participantMediumCircuitList);
                    break;
                case ID_ADVANCED_CIRCUIT: printParticipantList(participantAdvancedCircuitList);
                    break;
                default:
                    System.out.println("> ERROR: el circuito seleccionado no es válido.");
                    break;
            }
        }while(idCircuitSelected != ID_SMALL_CIRCUIT && idCircuitSelected != ID_MEDIUM_CIRCUIT && idCircuitSelected != ID_ADVANCED_CIRCUIT);
    }

    private static void printParticipantList(List<Map<String,String>> participantList){
        if(participantList.size() == 0 || allParticipantsAreInactive(participantList)){
            System.out.println("[!] Todavía no hay participantes inscriptos de manera activa en este circuito.");
        }else{
            System.out.println("LISTA DE PARTICIPANTES");
            for(Map<String,String> participantDataMap: participantList){
                if(participantDataMap.get("ACTIVE").equals("YES")){
                    System.out.print("Inscripción Nº: " + participantDataMap.get("INSCRIPTION_NUMBER"));
                    System.out.print(" | DNI: " + participantDataMap.get("DNI"));
                    System.out.print(", " + participantDataMap.get("NAME"));
                    System.out.print(" " + participantDataMap.get("LASTNAME"));
                    System.out.print(", " + participantDataMap.get("AGE") + " años");
                    System.out.print(", Celular: " + participantDataMap.get("MOBILE_PHONE"));
                    System.out.print(", Emergencias: " + participantDataMap.get("EMERGENCY_NUMBER"));
                    System.out.print(", Grupo sangíneo: " + participantDataMap.get("BLOOD_TYPE"));
                    System.out.println(" | Monto a pagar: $" + participantDataMap.get("AMOUNT_TO_PAY"));
                }
            }
        }
    }

    private static boolean allParticipantsAreInactive(List<Map<String,String>> participantList){
        boolean allParticipantsAreInactive = true;
        for(Map<String,String> participantMap: participantList){
            if(participantMap.get("ACTIVE").equals("YES"))
                allParticipantsAreInactive = false;
        }

        return allParticipantsAreInactive;
    }

    private static void menuUnsuscribeParticipant(){
        System.out.println("DESINSCRIBIR PARTICIPANTE");

        int idCircuitSelected;
        do{
            System.out.println("- Ingresar el circuito del cual quiere desinscribir al participante:");
            System.out.println("1. Circuito chico.");
            System.out.println("2. Circuito medio.");
            System.out.println("3. Circuito avanzado.");
            idCircuitSelected = SCANNER.nextInt();

            switch (idCircuitSelected){
                case ID_SMALL_CIRCUIT: unsuscribeParticipant(participantSmallCircuitList);
                    break;
                case ID_MEDIUM_CIRCUIT: unsuscribeParticipant(participantMediumCircuitList);
                    break;
                case ID_ADVANCED_CIRCUIT: unsuscribeParticipant(participantAdvancedCircuitList);
                    break;
                default:
                    System.out.println("> ERROR: el circuito seleccionado no es válido.");
                    break;
            }
        }while(idCircuitSelected != ID_SMALL_CIRCUIT && idCircuitSelected != ID_MEDIUM_CIRCUIT && idCircuitSelected != ID_ADVANCED_CIRCUIT);
    }

    private static void unsuscribeParticipant(List<Map<String,String>> participantList){
        System.out.println("- Ingresar el Nª de Inscripción del participante a desinscribir:");
        int inscriptionNumber = SCANNER.nextInt();

        if(inscriptionNumber <= 0 || inscriptionNumber > participantList.size()){
            System.out.println("[!] El Nª de Inscripción ingresado no existe en la lista de participantes de este circuito.");
        }else{
            Map<String,String> participantDataMap = participantList.get(inscriptionNumber - 1);
            participantDataMap.put("ACTIVE", "NO");

            System.out.println("> ¡El participante con Nª de Inscripción " + participantDataMap.get("INSCRIPTION_NUMBER") + " fue dado de baja correctamente!");
        }
    }
}
