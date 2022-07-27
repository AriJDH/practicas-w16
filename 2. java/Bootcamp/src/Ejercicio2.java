import java.io.IOException;
import java.util.*;

public class Ejercicio2 {
    public static List<HashMap<String, String>> chico = new ArrayList<HashMap<String, String>>();
    public static List<HashMap<String, String>> medio = new ArrayList<HashMap<String, String>>();
    public static List<HashMap<String, String>> avanzado = new ArrayList<HashMap<String, String>>();
    public static Scanner input = new Scanner(System.in);
    public final static String[] CAMPOS = {"DNI", "NOMBRE", "APELLIDO", "EDAD", "CELULAR", "Nro EMERGENCIA", "Gpo SANGUINEO"};

    public final static String mostrarMenu() {
        limpiarConsola();
        System.out.println("------------------MENU------------------");
        System.out.println("Seleccione una opción del menú:");
        System.out.println("1. Inscribir corredor circuito chico.");
        System.out.println("2. Inscribir corredor circuito medio.");
        System.out.println("3. Inscribir corredor circuito avanzado.");
        System.out.println("4. Listar participantes.");
        System.out.println("Cualquier otra cosa para salir.");
        return input.nextLine().trim();
    }

    public final static HashMap<String, String> llenarDatos(String circuito) {
        limpiarConsola();
        System.out.printf("Inscripción nuevo participante al circuito %s.\n", circuito);
        HashMap<String, String> participante = new HashMap<String, String>();
        for (String key : CAMPOS) {
            System.out.printf("Ingrese el %s del participante: ", key);
            participante.put(key, input.nextLine());
        }
        return participante;
    }
    private static HashMap<String, String> calcularID(HashMap<String, String> participante, List<HashMap<String, String>> participantes) {
        int id;
        if (participantes.size() == 0) id = 1;
        else id = Integer.parseInt(participantes.stream()
                .max(Comparator.comparing(p -> Integer.valueOf(p.get("ID") + 1)))
                .get().get("ID")) + 1;
        participante.put("ID", String.valueOf(id));
        return participante;
    }
    public final static void inscribirChico() {
        HashMap<String, String> participante = calcularID(llenarDatos("CHICO"), chico);
        chico.add(participante);
        System.out.println("Participante añadido con éxito.");
        int edad = Integer.valueOf(participante.get("EDAD"));
        double costo = edad < 18 ? 1300 : 1500 ;
        System.out.printf("Costo de la inscripción: $%.2f.\n", costo);
        System.out.println("Ingrese cualquier caracter para continuar.");
        input.nextLine();
    }

    public final static void inscribirMedio() {
        HashMap<String, String> participante = calcularID(llenarDatos("MEDIO"), medio);
        medio.add(participante);
        System.out.println("Participante añadido con éxito.");
        int edad = Integer.valueOf(participante.get("EDAD"));
        double costo = edad < 18 ? 2000 : 2300 ;
        System.out.printf("Costo de la inscripción: $%.2f.\n", costo);
        System.out.println("Ingrese cualquier caracter para continuar.");
        input.nextLine();
    }

    public final static void inscribirAvanzado() {
        HashMap<String, String> participante = calcularID(llenarDatos("AVANZADO"), avanzado);
        int edad = Integer.valueOf(participante.get("EDAD"));
        if (edad < 18) {
            System.out.println("Error... Solo se puden inscribir participantes de mayores de 18 años.");
            return;
        }
        avanzado.add(participante);
        System.out.println("Participante añadido con éxito.");
        System.out.printf("Costo de la inscripción: $%.2f.\n", 2800);
        System.out.println("Ingrese cualquier caracter para continuar.");
        input.nextLine();
    }

    public final static void listarInscriptos(String circuito) {
        List<HashMap<String, String>> participantes;
        if (circuito.equals("CHICO")) participantes = chico;
        else if (circuito.equals("MEDIO")) participantes = medio;
        else if (circuito.equals("AVANZADO")) participantes = avanzado;
        else return;

        while (true) {
            limpiarConsola();
            System.out.printf("Listado de participantes para la comentencia %s:\n", circuito);
            for (int i = 0; i < participantes.size(); i++) {
                System.out.printf("Participante %s: %s.\n", i + 1, participantes.get(i));
            }
            if (participantes.size() == 0) {
                System.out.println("No hay participantes para este circuito.");
                System.out.println("Cualquier otra cosa para volver atrás.");
                input.nextLine();
                return;
            }
            System.out.println("Seleccione una opción del menú:");
            System.out.println("1. Eliminar corredor.");
            System.out.println("Cualquier otra cosa para volver atrás.");
            if (input.nextLine().trim().equals("1")) {
                System.out.printf("Seleccione el corredor para eliminar [1 - %s]:\n", participantes.size());
                int entrada = input.nextInt();
                input.nextLine();
                if (entrada >= 1 && entrada <= participantes.size()) participantes.remove(entrada - 1);
            }else break;
        }
    }

    public final static void menuListarInscriptos() {
        limpiarConsola();
        System.out.println("Listado inscriptos.");
        System.out.println("Seleccione una opción del menú:");
        System.out.println("1. Listar corredores circuito chico.");
        System.out.println("2. Listar corredores circuito medio.");
        System.out.println("3. Listar corredores circuito avanzado.");
        System.out.println("Cualquier otra cosa para volver atrás.");
        String entrada = input.nextLine().trim();
        if (entrada.equals("1")) listarInscriptos("CHICO");
        else if (entrada.equals("2")) listarInscriptos("MEDIO");
        else if (entrada.equals("3")) listarInscriptos("AVANZADO");
    }

    public final static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        while (true) {
            String entrada = mostrarMenu();
            if (entrada.equals("1")) inscribirChico();
            else if (entrada.equals("2")) inscribirMedio();
            else if (entrada.equals("3")) inscribirAvanzado();
            else if (entrada.equals("4")) menuListarInscriptos();
            else break;
        }
        input.close();
        limpiarConsola();
    }
}