import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EjercicioPractico {
    HashMap<Integer, ArrayList<String>> participantes = new HashMap<>();

    private static void categorías(){

        System.out.println("Bienvenid@ a Carrera de la Selva, indicanos tu EDAD");
        Scanner dataEntry = new Scanner(System.in);
        Scanner circuito = new Scanner(System.in);

        int edad = dataEntry.nextInt();

        if(edad<18){
            System.out.println("Seleccioná tu circuito favorito:\n" +
                    "1)Circuito chico: 2 km por selva y arroyos.\n" +
                    "2)Circuito medio: 5 km por selva, arroyos y barro.\n" +
                    "IMPORTANTE SI TENES MENOS DE 18 AÑOS NO PODES ACCEDER AL CIRCUITO AVANZADO");
        }
        else{
            System.out.println("Seleccioná tu circuito favorito:\n " +
                    "1)Circuito chico: 2 km por selva y arroyos.\n" +
                    "2)Circuito medio: 5 km por selva, arroyos y barro.\n" +
                    "3)Circuito Avanzado: 10 km por selva, arroyos, barro y escalada en piedra.\n" +
                    "IMPORTANTE SI TENES MENOS DE 18 AÑOS NO PODES ACCEDER AL CIRCUITO AVANZADO");

        }
    int circuitoIngresado = circuito.nextInt();

        switch (circuitoIngresado){
            case 1:

        }

    }

    private void inscripcion() {
        ArrayList<String> nuevoParticipante = new ArrayList<>();
        String nombre, apellido, grupoSanguineo;
        int dni,celular,numEmergencia;
        int numInscripcion = 1;
        Scanner ingresoDeDatos = new Scanner(System.in);

        System.out.println("Introduzca nombre");
        nombre = ingresoDeDatos.nextLine();
        nuevoParticipante.add(0,nombre);

        System.out.println("Introduzca apellido");
        apellido = ingresoDeDatos.nextLine();
        nuevoParticipante.add(1,apellido);

        System.out.println("Introduzca grupoSanguineo");
        grupoSanguineo = ingresoDeDatos.nextLine();
        nuevoParticipante.add(2,grupoSanguineo);

        System.out.println("Introduzca DNI");
        dni = ingresoDeDatos.nextInt();
        nuevoParticipante.add(3, String.valueOf(dni));

        System.out.println("Introduzca nro de celular");
        celular = ingresoDeDatos.nextInt();
        nuevoParticipante.add(4, String.valueOf(celular));

        System.out.println("Introduzca Telefono de Emergencia");
        numEmergencia = ingresoDeDatos.nextInt();
        nuevoParticipante.add(4, String.valueOf(numEmergencia));

        participantes.put(numInscripcion, nuevoParticipante);
        System.out.println("El número de inscripto es: " + numInscripcion);

        numInscripcion++;

    }




















    public static void main(String[] args) {
        System.out.println("Programa Carrera de la Selva");
        categorías();
    }


}
