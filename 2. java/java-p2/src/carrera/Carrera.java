package carrera;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Carrera {

    private final Map<String,String> circuitoChico = new HashMap<>();
    private final Map<String,String> circuitoMedio = new HashMap<>();
    private final Map<String,String> circuitoAvanzado = new HashMap<>();
    private final Map<String,Integer> categoriaMap = new HashMap<>();
    private final Map<String,Integer> costoMap = new HashMap<>();

    private int numeroInscripcion = 1;

    private Scanner scanner;

    private void agregarParticipante(String dni, int categoria, String nombre, String apellido, int edad,
                                     int celular, int numEmergencia, String grupoSang) {
        if (edad < 18 && categoria == 3) {
            System.out.println("Un menor de edad no puede inscribirse en el circuito avanzado");
            return;
        }
        else if (categoriaMap.containsKey(dni)) {
            System.out.println("El participante ya está registrado en un circuito");
            return;
        }
        Map<String,String> inscripcion = categoria == 1 ? circuitoChico : (categoria == 2 ? circuitoMedio : circuitoAvanzado);
        String datos = String.format("{Número de participante: %d, DNI: %s, Nombre: %s, apellido: %s, Edad: %d, " +
                "Celular: %d, Número de emergencia: %d, Grupo sanguíneo: %s}", numeroInscripcion++, dni, nombre,
                apellido, edad, celular, numEmergencia, grupoSang);
        int costo;
        if (categoria == 1)
            costo = edad < 18 ? 1300 : 1500;
        else if (categoria == 2)
            costo = edad < 18 ? 2000 : 2300;
        else
            costo = 2800;
        inscripcion.put(dni, datos);
        categoriaMap.put(dni, categoria);
        costoMap.put(dni, costo);
        System.out.println("Participante inscrito con éxito");
    }

    private void mostrarParticipantesCategoria(Scanner in) {
        int categoria = elegirCategoria(in);
        if (categoria == 4) return;
        Map<String,String> participantes = categoria == 1 ? circuitoChico : (categoria == 2 ? circuitoMedio : circuitoAvanzado);
        System.out.println(participantes.values());
    }

    private void eliminarParticipante(Scanner in) {
        System.out.print("Ingrese el DNI del participante: \n>>");
        String dni = in.nextLine();
        if (!categoriaMap.containsKey(dni)) {
            System.out.println("La persona ingresada no está registrada en ninguna categoría");
            return;
        }
        int categoria = categoriaMap.get(dni);
        Map<String,String> participantes = categoria == 1 ? circuitoChico : (categoria == 2 ? circuitoMedio : circuitoAvanzado);
        participantes.remove(dni);
        categoriaMap.remove(dni);
        costoMap.remove(dni);
        System.out.println("Participante desinscrito correctamente");
    }

    private void calcularCostoParticipante(Scanner in) {
        System.out.print("Ingrese el DNI del participante: \n>>");
        String dni = in.nextLine();
        if (!costoMap.containsKey(dni)) {
            System.out.println("La persona ingresada no está registrada en ninguna categoría");
            return;
        }
        System.out.println("El costo de inscripción es de " + costoMap.get(dni));
    }

    private void leerDatosInscripcion(Scanner in) {
        int categoria = elegirCategoria(in);
        if (categoria == 4) return;
        System.out.println("---------------------------------------------------------");
        System.out.println("Ingrese los datos del participante");
        System.out.print("DNI: \n>>");
        String dni = in.nextLine();
        System.out.print("Nombre: \n>>");
        String nombre = in.nextLine();
        System.out.print("Apellido: \n>>");
        String apellido = in.nextLine();
        System.out.print("Edad: \n>>");
        int edad = in.nextInt();
        System.out.print("Celular: \n>>");
        int celular = in.nextInt();
        System.out.print("Número de emergencia: \n>>");
        int numEmerg = in.nextInt();
        System.out.print("Grupo sanguíneo: \n>>");
        String grupoSang = in.next();
        in.nextLine();
        agregarParticipante(dni, categoria, nombre, apellido, edad, celular, numEmerg, grupoSang);
    }

    private static int elegirCategoria(Scanner in) {
        while (true) {
            System.out.println("---------------------------------------------------------");
            System.out.println("Elige una categoría:");
            System.out.println("1. Circuito chico");
            System.out.println("2. Circuito medio");
            System.out.println("3. Circuito avanzado");
            System.out.println("4. Cancelar");
            System.out.print(">>");
            String entrada = in.nextLine();
            switch (entrada) {
                case "1": return 1;
                case "2": return 2;
                case "3": return 3;
                case "4": return 4;
                default:
                    System.out.println("Categoría no reconocida"); break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Carrera carrera = new Carrera();
        outerLoop:
        while(true) {
            System.out.println("---------------------------------------------------------");
            System.out.println("Bienvenido, elige una acción");
            System.out.println("1. Iscribir Participante");
            System.out.println("2. Consultar participantes");
            System.out.println("3. Desinscribir participante");
            System.out.println("4. Consultar precio de inscripción");
            System.out.println("5. Salir");
            System.out.print(">>");
            String entrada = in.nextLine();
            switch (entrada) {
                case "1": carrera.leerDatosInscripcion(in); break;
                case "2": carrera.mostrarParticipantesCategoria(in); break;
                case "3": carrera.eliminarParticipante(in); break;
                case "4": carrera.calcularCostoParticipante(in); break;
                case "5": break outerLoop;
                default:
                    System.out.println("Opción no reconocida"); break;
            }
        }
        System.out.println("¡Hasta la próxima!");
        in.close();
    }

}
