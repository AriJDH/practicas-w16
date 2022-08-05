package main;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<Integer, ArrayList<String>> small = new HashMap<>();
    public static Map<Integer, ArrayList<String>> medium = new HashMap<>();
    public static Map<Integer, ArrayList<String>> advance = new HashMap<>();

    public static int nSmall = 1;

    public static int nMedium = 1;

    public static int nAdvance = 1;


    public static void main(String[] args) {
        inscribirParticipante("Circuito Chico", "123", "Juliana", "Ortega", "17", "316335", "317400", "A+");
        inscribirParticipante("Circuito Chico", "1234", "Juliana", "Ortega", "27", "316335", "317400", "A+");

        mostrarDatosParticipantesPorCategoria(small, "Circuito Chico");

        desinscribirParticipante(small,"Circuito Chico","123");
    }

    public static void inscribirParticipante(String categoria, String dni, String nombre, String apellido, String edad, String cel, String numeroEmergencia, String grupoSanguineo) {
        double monto;
        ArrayList<String> datosParticipante = new ArrayList<>(Arrays.asList(dni, nombre, apellido, edad, cel, numeroEmergencia, grupoSanguineo));
        System.out.println("\n*********************");
        System.out.println("Iniciando inscripcion de participante ...\n");
        monto = calcularMonto(categoria, Integer.parseInt(edad));

        if (validarExisteInscripcionParticipante(small, dni) && validarExisteInscripcionParticipante(medium, dni) && validarExisteInscripcionParticipante(advance, dni)) {
            switch (categoria) {
                case "Circuito Chico":
                    if (!small.isEmpty()) nSmall++;
                    small.put(nSmall, datosParticipante);
                    break;
                case "Circuito Medio":
                    if (!medium.isEmpty()) nMedium++;
                    medium.put(nMedium, datosParticipante);
                    break;
                case "Circuito Avanzado":
                    if (!advance.isEmpty()) nAdvance++;
                    advance.put(nAdvance, datosParticipante);
                    break;
            }
            System.out.println("****** Se ha realizado la inscripcion del Participante, el la categoria: " + categoria + " con los siguientes datos: *******");
            datosInscripcion(datosParticipante, monto);
        } else {
            System.out.println("El participante ya se encuentra inscrito en alguna categoria");
        }

    }

    public static void mostrarDatosParticipantesPorCategoria(Map<Integer, ArrayList<String>> map, String categoria) {
        double monto;
        System.out.println("\n####################");
        System.out.println("INFORMACION DE LOS PARTICIPANTES DE LA CATEGORIA: " + categoria);
        if(!map.isEmpty()){
            for (Integer clave : map.keySet()) {
                ArrayList<String> datos = map.get(clave);
                System.out.println("Numero de inscripcion: " + clave);
                monto = calcularMonto(categoria, Integer.parseInt(datos.get(3)));
                datosInscripcion(datos, monto);
                System.out.println("--------------------");
            }
        }else{
            System.out.println("La categoria "+categoria+" no tiene participantes inscritos");
        }
    }

    public static void desinscribirParticipante(Map<Integer, ArrayList<String>> map, String categoria, String dni){
        System.out.println("\nDesinscribiendo a un participante de la categoria "+categoria+" ....");

        for (Integer clave:map.keySet()) {
            ArrayList<String> datos = map.get(clave);
            if(datos.get(0).equals(dni)){
                map.remove(clave);
                System.out.println("Se ha ELIMINADO el participante con el nombre "+datos.get(1)+", el dni "+dni+" y el numero de inscripcion "+clave);
                break;
            }

        }
    }

    public static void datosInscripcion(ArrayList<String> datos, Double monto) {

        System.out.println("DNI: " + datos.get(0));
        System.out.println("Nombre: " + datos.get(1));
        System.out.println("Apellido: " + datos.get(2));
        System.out.println("Edad: " + datos.get(3));
        System.out.println("Celular: " + datos.get(4));
        System.out.println("Numero de emergencia: " + datos.get(5));
        System.out.println("Grupo Sanguineo: " + datos.get(6));
        System.out.println("Monto de la inscripcion: " + monto);
    }

    public static boolean validarExisteInscripcionParticipante(Map<Integer, ArrayList<String>> map, String dni) {

        for (Integer clave : map.keySet()) {
            ArrayList<String> datos = map.get(clave);
            if (datos.get(0).equals(dni)) {
                return false;
            }
        }
        return true;
    }

    public static double calcularMonto(String categoria, int edad) {

        switch (categoria) {
            case "Circuito Chico":
                if (edad < 18) return 1300;
                else return 1500;
            case "Circuito Medio":
                if (edad < 18) return 2000;
                else return 2300;
            case "Circuito Avanzado":
                return 2800;
        }
        return 0d;
    }

}
