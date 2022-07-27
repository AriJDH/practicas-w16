package practices;

import java.util.*;

public class ExerciseJungle {

    // Circuito chico
    static Set<String> small_circuit = new HashSet<>();
    // Circuito medio
    static Set<String> middle_circuit = new HashSet<>();
    // Circuito avanzado
    static Set<String> advance_circuit = new HashSet<>();

    // Numero de inscripciones
    static int num_enrolled = 0;

    private static void InscriptionCircuit() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Opciones del sistema: ");
        System.out.println("1. Suscribir a alguien");
        System.out.println("2. Deseas eliminar una suscripcion");
        System.out.println("3. Mostrar los inscritos por circuitos");
        System.out.println("4. Salir del sistema");
        int option_more = sc.nextInt();

        if (option_more == 1) {
            System.out.println("Ingrese el DNI");
            String dni = sc.next();
            System.out.println("Ingrese el nombre");
            String name = sc.next();
            System.out.println("Ingrese el apellido");
            String last_name = sc.next();
            System.out.println("Ingrese la edad");
            int age = sc.nextInt();
            System.out.println("Ingrese el telefono");
            int phone = sc.nextInt();
            System.out.println("Ingrese el telefono de emergencia");
            int phone_emergency = sc.nextInt();
            System.out.println("Ingrese el grupo sanguineo");
            String group_sanguine = sc.next();
            System.out.println("Seleccione la opcion de suscripcion al circuito: ");
            System.out.println("1. Circuito chico");
            System.out.println("2. Circuito medio");
            System.out.println("3. Circuito avanzado");
            int option_sus = sc.nextInt();

            // numero de suscripcion
            num_enrolled++;

            // Calcular la inscripcion
            CalculateInscription(age, option_sus);


            System.out.println("Deseas inscribirte: ");
            System.out.println("1. Si");
            System.out.println("2. No");
            int option_sus_confirm = sc.nextInt();

            String user_save = "Num Suscripcion: " + num_enrolled + " | " + "DNI: " + dni + " | " + "Nombre: " + name + " | " + "Apellido: " + last_name
                    + " | " + "Edad: " + age + " | " + "Telefono: " + phone + " | " + "Telefono de emergencia: " + phone_emergency + " | " + "Grupo sanguineo: " + group_sanguine;

            if (option_sus_confirm == 1) {
                SaveInscription(user_save, option_sus);
                InscriptionCircuit();
            }
            else
                InscriptionCircuit();
        }

        if (option_more == 2) {
            System.out.println("De que circuito deseas eliminar la suscripcion: ");
            System.out.println("1. Circuito chico");
            System.out.println("2. Circuito Medio");
            System.out.println("3. Circuito Avanzado");
            int option_circuit_delete = sc.nextInt();
            System.out.println("3. Cual es el numero de la suscripcion: ");
            int number_suscription = sc.nextInt();

            DeleteUserSuscriptor(option_circuit_delete, number_suscription);
            InscriptionCircuit();
        }

        if (option_more == 3) {
            PrintListSuscriptors();
            InscriptionCircuit();
        }

        sc.close();
    }

    private static void CalculateInscription(int age, int option_sus) {
        int total_inscription = 0;

        if (option_sus == 1) {
            total_inscription = age <= 18 ? 1300 : 1500;
        } else if (option_sus == 2) {
            total_inscription = age <= 18 ? 2000 : 2300;
        } else if (option_sus == 3 && age <= 18) {
            System.out.println("No esta permitido para menores de 18 años");
        } else {
            total_inscription = 2800;
        }

        System.out.println("El costo de la inscripcion es de :" + total_inscription);
    }

    private static void SaveInscription(String user_save, int option_sus) {

        if (option_sus == 1) {
            small_circuit.add(user_save);
        } else if (option_sus == 2) {
            middle_circuit.add(user_save);
        } else {
            advance_circuit.add(user_save);
        }

        System.out.println(user_save);
    }

    public static void PrintListSuscriptors() {

        System.out.println("Lista Circuito Chico");
        for (String user : small_circuit) {
            System.out.println(user);
        }

        System.out.println("Lista Circuito Medio");
        for (String user : middle_circuit) {
            System.out.println(user);
        }

        System.out.println("Lista Circuito Avanzado");
        for (String user : advance_circuit) {
            System.out.println(user);
        }
    }

    public static void DeleteUserSuscriptor(int option_circuit_delete, int number_suscription) {

        if(option_circuit_delete == 1) {
            for (String user : small_circuit) {
                if (user.contains("Num Suscripcion: " + number_suscription)) {
                    small_circuit.remove(user);
                    System.out.println("Suscripcion eliminada: " + user);
                    break;
                }
            }
        }

        if(option_circuit_delete == 2) {
            for (String user : middle_circuit) {
                if (user.contains("Num Suscripcion: " + number_suscription)) {
                    middle_circuit.remove(user);
                    System.out.println("Suscripcion eliminada: " + user);
                    break;
                }
            }
        }

        if(option_circuit_delete == 3) {
            for (String user : advance_circuit) {
                if (user.contains("Num Suscripcion: " + number_suscription)) {
                    advance_circuit.remove(user);
                    System.out.println("Suscripcion eliminada: " + user);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        InscriptionCircuit();
    }


}
