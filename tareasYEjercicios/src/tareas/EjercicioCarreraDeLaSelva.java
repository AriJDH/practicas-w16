package tareas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EjercicioCarreraDeLaSelva {

    private static final Scanner sc = new Scanner(System.in);
    int debeAbonar;
    String dni;
    String nombreApellido;
    String edad;
    String celular;
    String numEmerg;
    String grupoSang;
    Integer contadorInscriptos = 0;
    String categoria;
    HashMap<String, String> datosInscripcionPersona = new HashMap<>();
    HashMap<Integer, HashMap<String, String>> personasInscriptas = new HashMap<>();
    String opcion;
    String inscripcion;
    ArrayList<Integer> circuitoChicoIncriptos = new ArrayList<>();
    ArrayList<Integer> circuitoMedioIncriptos = new ArrayList<>();
    ArrayList<Integer> circuitoAvanzadoIncriptos = new ArrayList<>();

    public static void main(String[] args) {

        EjercicioCarreraDeLaSelva ej = new EjercicioCarreraDeLaSelva();
        ej.menu();
    }

    public void menu() {

        System.out.println("Bienvenido a Carrera de la selva! ");
        do {
            System.out.println("Ingrese I (inscripciones), D para desinscribir, M para mostrar inscriptos o S para salir");
            opcion = sc.nextLine().toUpperCase();
            ejecutarOpcionSeleccionada();
        } while (!opcion.equals("S"));

        System.out.println("Gracias ");
    }

    public void ejecutarOpcionSeleccionada() {
        switch (opcion) {
            case "I":
                solicitarDatosInscripcion();
                datosInscripcionPersona = new HashMap<>();
                break;
            case "D":
                solicitarDatosParaDesinscribir();
                break;
            case "M":
                mostrarInscriptos();
                break;
            case "S":
                break;
            default:
                System.out.println("Opcion ingresada invalida");
        }
    }

    public void solicitarDatosInscripcion() {

        solicitarCategoria();

        System.out.println("Ingrese dni: ");
        dni = sc.nextLine();
        System.out.println("Ingrese nombre y apellido: ");
        nombreApellido = sc.nextLine();
        System.out.println("Ingrese edad: ");
        edad = sc.nextLine();
        System.out.println("Ingrese celular: ");
        celular = sc.nextLine();
        System.out.println("Ingrese numero de emergencia: ");
        numEmerg = sc.nextLine();
        System.out.println("Ingrese grupo sanguineo: ");
        grupoSang = sc.nextLine();

        inscribirACategoria();
    }

    public void inscribirACategoria() {
        switch (categoria) {
            case "CHICO":
                incripcionEnCircuitoChico();
                break;
            case "MEDIO":
                incripcionEnCircuitoMedio();
                break;
            case "AVANZADO":
                incripcionEnCircuitoAvanzado();
                break;
            default:
                System.out.println("Los datos ingresados fueron incorrectos");
                break;
        }
    }

    public void incripcionEnCircuitoChico() {
        if (Integer.parseInt(edad) < 18) {
            debeAbonar = 1300;
        } else {
            debeAbonar = 1500;
        }
        contadorInscriptos++;
        System.out.println("Abona $" + debeAbonar);
        guardarPersona();
        circuitoChicoIncriptos.add(contadorInscriptos);
    }

    public void incripcionEnCircuitoMedio() {
        if (Integer.parseInt(edad) < 18) {
            debeAbonar = 2000;
        } else {
            debeAbonar = 2300;
        }
        contadorInscriptos++;
        guardarPersona();
        circuitoMedioIncriptos.add(contadorInscriptos);
    }

    public void incripcionEnCircuitoAvanzado() {
        if (Integer.parseInt(edad) < 18) {
            System.out.println("No se permite inscripciones a menores de 18 años.");
        } else {
            debeAbonar = 2800;
            contadorInscriptos++;
            guardarPersona();
            circuitoAvanzadoIncriptos.add(contadorInscriptos);
        }
    }

    public void solicitarCategoria() {
        do {
            System.out.println("Ingrese categoria del circuito - [Chico, Medio o Avanzado]: ");
            categoria = sc.nextLine().toUpperCase();
        } while (!categoria.equals("CHICO") && !categoria.equals("MEDIO") && !categoria.equals("AVANZADO"));
    }

    public void solicitarDatosParaDesinscribir() {
        solicitarCategoria();
        do {
            System.out.println("Ingrese numero de inscripcion: ");
            inscripcion = sc.nextLine();
        } while (inscripcion.isEmpty());
        desinscribir(Integer.parseInt(inscripcion));
    }

    public void desinscribir(Integer idInscripcion) {

        switch (categoria) {
            case "CHICO":
                circuitoChicoIncriptos.remove(idInscripcion);
                break;
            case "MEDIO":
                circuitoMedioIncriptos.remove(idInscripcion);
                break;
            case "AVANZADO":
                circuitoAvanzadoIncriptos.remove(idInscripcion);
                break;
            default:
                System.out.println("Circuito incorrecto ");
                break;
        }

    }

    public void guardarPersona() {
        datosInscripcionPersona.put("id", contadorInscriptos.toString());
        datosInscripcionPersona.put("nombreApellido", nombreApellido);
        datosInscripcionPersona.put("dni", dni);
        datosInscripcionPersona.put("edad", edad);
        datosInscripcionPersona.put("celular", celular);
        datosInscripcionPersona.put("numEmerg", numEmerg);
        datosInscripcionPersona.put("grupoSang", grupoSang);
        personasInscriptas.put(contadorInscriptos, datosInscripcionPersona);
    }

    public void mostrarInscriptos() {
        System.out.println("Inscriptos al circuito chico: ");
        mostrarPersonas(circuitoChicoIncriptos);
        System.out.println("Inscriptos al circuito medio: ");
        mostrarPersonas(circuitoMedioIncriptos);
        System.out.println("Inscriptos al circuito avanzado: ");
        mostrarPersonas(circuitoAvanzadoIncriptos);
    }

    public void mostrarPersonas(ArrayList<Integer> numerosDeIncripcion) {
        for (Integer id : numerosDeIncripcion) {
            System.out.println(personasInscriptas.get(id));
        }
    }
}
