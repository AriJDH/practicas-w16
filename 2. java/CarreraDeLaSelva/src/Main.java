import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    //Definición de atributos estáticos válidos para toda la clase
    static List<HashMap> circuitoChico = new ArrayList<>();
    static List<HashMap> circuitoMedio = new ArrayList<>();
    static List<HashMap> circuitoAvanzado = new ArrayList<>();
    static int numeroParticipante = 0;

    //Función que muestra el menú principal del sistema y recibe la opción entregada por el usuario
    public static void iniciarPrograma(boolean programaIniciado){
        Scanner entrada = new Scanner(System.in);
        if (!programaIniciado){
            System.out.println("+++++ Bienvenido al sistema de inscripción de Carrera de la Selva +++++" + "\n"
                    + "Escoja una de las siguientes opciones: " + "\n"
                    + "\n"
                    + "1.- Inscribir a un nuevo participante en una categoría" + "\n"
                    + "2.- Mostrar a todos los participantes de una categoría" + "\n"
                    + "3.- Desinscribir a un participante de una categoría" + "\n"
                    + "4.- Cerrar el programa");
        }
        else{
            System.out.println("Error de ingreso, intente nuevamente: " + "\n"
                    + "\n"
                    + "1.- Inscribir a un nuevo participante en una categoría" + "\n"
                    + "2.- Mostrar a todos los participantes de una categoría" + "\n"
                    + "3.- Desinscribir a un participante de una categoría" + "\n"
                    + "4.- Cerrar el programa");
        }

        switch (entrada.nextLine()){
            case "1":
                inscribirParticipante();
                break;
            case "2":
                imprimirParticipantes();
                break;
            case "3":
                borrarParticipantes();
                break;
            case "4":
                System.out.println("Apagando... Hasta la próxima!");
                System.exit(0);
            default:
                iniciarPrograma(true);
        }
        entrada.close();
    }

    //Método que inscribe a nuevos participantes
    public static void inscribirParticipante(){
        HashMap<String, String> participante = new HashMap<>();
        numeroParticipante += 1;
        String numParticipante = String.valueOf(numeroParticipante);
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese los datos del participante: " + "\n");
        System.out.println("DNI del participante: ");
        participante.put("dni", entrada.nextLine());
        System.out.println("Nombre del participante: ");
        participante.put("nombre", entrada.nextLine());
        System.out.println("Apellido del participante: ");
        participante.put("apellido", entrada.nextLine());
        System.out.println("Edad del participante: ");
        participante.put("edad", entrada.nextLine());
        System.out.println("Celular del participante: ");
        participante.put("celular", entrada.nextLine());
        System.out.println("Número de emergencia del participante: ");
        participante.put("numEmergencia", entrada.nextLine());
        System.out.println("Grupo sanguíneo del participante: ");
        participante.put("grupoSanguineo", entrada.nextLine());

        System.out.println("Ingrese el circuito de competición del participante: " + "\n"
        + "1.- Circuito chico" + "\n"
        + "2.- Circuito medio" + "\n"
        + "3.- Circuito avanzado");

        switch (entrada.nextLine()){
            case "1":
                String abono = (Integer.parseInt(participante.get("edad")) < 18) ? "1300" : "1500";
                participante.put("abono", abono);
                participante.put("numeroParticipante", numParticipante);
                circuitoChico.add(participante);
                System.out.println("Participante ingresado");
            break;
            case "2":
                abono = (Integer.parseInt(participante.get("edad")) < 18) ? "2000" : "2300";
                participante.put("abono", abono);
                participante.put("numeroParticipante", numParticipante);
                circuitoMedio.add(participante);
                System.out.println("Participante ingresado");
                break;
            case "3":
                if (Integer.parseInt(participante.get("edad")) < 18){
                    System.out.println("No se permite la inscripción de menores de edad en esta categoría");
                    iniciarPrograma(true);
                }
                else{
                    participante.put("abono", "2800");
                }
                participante.put("numeroParticipante", numParticipante);
                circuitoAvanzado.add(participante);
                System.out.println("Participante ingresado");
                break;
            default:
                System.out.println("Ingreso no permitido");
                break;
        }

        System.out.println("¿Desea agregar a otro participante? (y/n)");
        String input = entrada.nextLine();
        boolean entrarAWhile = false;

        if (input.equals("y")){
            inscribirParticipante();
            entrada.close();
        }
        else if (input.equals("n")){
            iniciarPrograma(false);
            entrada.close();
        }
        else{
            entrarAWhile = true;
        }

        while(entrarAWhile){
            System.out.println("Ingreso no permitido, intente nuevamente (y/n)");
            String teclado = entrada.nextLine();
            if (teclado.equals("y")){
                entrarAWhile = false;
                inscribirParticipante();
                entrada.close();
            }
            if (teclado.equals("n")){
                entrarAWhile = false;
                iniciarPrograma(false);
                entrada.close();
            }
        }
        entrada.close();
    }

    //Método que imprime participantes
    public static void imprimirParticipantes(){
        System.out.println("Ingrese un circuito de competición: " + "\n"
                + "1.- Circuito chico" + "\n"
                + "2.- Circuito medio" + "\n"
                + "3.- Circuito avanzado");

        Scanner entrada = new Scanner(System.in);
        switch (entrada.nextLine()){
            case "1":
                if (!circuitoChico.isEmpty()) {
                    for (HashMap circuito: circuitoChico) {
                        System.out.println("Número: " + circuito.get("numeroParticipante")
                        + ", DNI: " + circuito.get("dni") + ", Nombre: " + circuito.get("nombre")
                        + " " + circuito.get("apellido") + ", Edad: " + circuito.get("edad")
                        + ", Celular: " + circuito.get("celular") + ", Número de Emergencia: " + circuito.get("numEmergencia")
                        + ", Grupo Sanguíneo: " + circuito.get("grupoSanguineo") + ", Abono: " + circuito.get("abono"));
                    }
                }
                else{
                    System.out.println("Aún no hay participantes inscritos para esta categoría");
                }
                break;
            case "2":
                if (!circuitoMedio.isEmpty()) {
                    for (HashMap circuito: circuitoMedio) {
                        System.out.println("Número: " + circuito.get("numeroParticipante")
                                + ", DNI: " + circuito.get("dni") + ", Nombre: " + circuito.get("nombre")
                                + " " + circuito.get("apellido") + ", Edad: " + circuito.get("edad")
                                + ", Celular: " + circuito.get("celular") + ", Número de Emergencia: " + circuito.get("numEmergencia")
                                + ", Grupo Sanguíneo: " + circuito.get("grupoSanguineo") + ", Abono: " + circuito.get("abono"));
                    }
                }
                else{
                    System.out.println("Aún no hay participantes inscritos para esta categoría");
                }
                break;
            case "3":
                if (!circuitoAvanzado.isEmpty()) {
                    for (HashMap circuito: circuitoAvanzado) {
                        System.out.println("Número: " + circuito.get("numeroParticipante")
                                + ", DNI: " + circuito.get("dni") + ", Nombre: " + circuito.get("nombre")
                                + " " + circuito.get("apellido") + ", Edad: " + circuito.get("edad")
                                + ", Celular: " + circuito.get("celular") + ", Número de Emergencia: " + circuito.get("numEmergencia")
                                + ", Grupo Sanguíneo: " + circuito.get("grupoSanguineo") + ", Abono: " + circuito.get("abono"));
                    }
                }
                else{
                    System.out.println("Aún no hay participantes inscritos para esta categoría");
                }
                break;
            default:
                System.out.println("Ingreso no permitido");
                break;
        }

        System.out.println("¿Desea listar participantes de otro circuito? (y/n)");
        String input = entrada.nextLine();
        boolean entrarAWhile = false;

        if (input.equals("y")){
            imprimirParticipantes();
            entrada.close();
        }
        else if (input.equals("n")){
            iniciarPrograma(false);
            entrada.close();
        }
        else{
            entrarAWhile = true;
        }

        while(entrarAWhile){
            System.out.println("Ingreso no permitido, intente nuevamente (y/n)");
            String teclado = entrada.nextLine();
            if (teclado.equals("y")){
                entrarAWhile = false;
                imprimirParticipantes();
                entrada.close();
            }
            if (teclado.equals("n")){
                entrarAWhile = false;
                iniciarPrograma(false);
                entrada.close();
            }
        }
        entrada.close();
    }

    //Método que desinscribe participantes
    public static void borrarParticipantes(){
        System.out.println("Ingrese un circuito de competición: " + "\n"
                + "1.- Circuito chico" + "\n"
                + "2.- Circuito medio" + "\n"
                + "3.- Circuito avanzado");

        Scanner entrada = new Scanner(System.in);
        switch (entrada.nextLine()){
            case "1":
                if (circuitoChico.isEmpty()){
                    System.out.println("Esta categoría no cuenta con participantes para eliminar");
                }
                else{
                    System.out.println("Ingrese el número del participante que desea eliminar");
                    String indice = entrada.nextLine();
                    for (int i = 0; i < circuitoChico.size(); i++) {
                        if (indice.equals(circuitoChico.get(i).get("numeroParticipante"))){
                            circuitoChico.remove(i);
                            System.out.println("Participante eliminado del sistema");
                        }
                        else{
                            System.out.println("El participante ingresado no se encuentra en esta categoría");
                        }
                    }
                }
                break;
            case "2":
                if (circuitoMedio.isEmpty()){
                    System.out.println("Esta categoría no cuenta con participantes para eliminar");
                }
                else{
                    System.out.println("Ingrese el número del participante que desea eliminar");
                    String indice = entrada.nextLine();
                    for (int i = 0; i < circuitoMedio.size(); i++) {
                        if (indice.equals(circuitoMedio.get(i).get("numeroParticipante"))){
                            circuitoMedio.remove(i);
                            System.out.println("Participante eliminado del sistema");
                        }
                        else{
                            System.out.println("El participante ingresado no se encuentra en esta categoría");
                        }
                    }
                }
                break;
            case "3":
                if (circuitoAvanzado.isEmpty()){
                    System.out.println("Esta categoría no cuenta con participantes para eliminar");
                }
                else{
                    System.out.println("Ingrese el número del participante que desea eliminar");
                    String indice = entrada.nextLine();
                    for (int i = 0; i < circuitoAvanzado.size(); i++) {
                        if (indice.equals(circuitoAvanzado.get(i).get("numeroParticipante"))){
                            circuitoAvanzado.remove(i);
                            System.out.println("Participante eliminado del sistema");
                        }
                        else{
                            System.out.println("El participante ingresado no se encuentra en esta categoría");
                        }
                    }
                }
                break;
            default:
                System.out.println("Ingreso no permitido");
                break;
        }

        System.out.println("¿Desea eliminar participantes de otro circuito? (y/n)");
        String input = entrada.nextLine();
        boolean entrarAWhile = false;

        if (input.equals("y")){
            borrarParticipantes();
            entrada.close();
        }
        else if (input.equals("n")){
            iniciarPrograma(false);
            entrada.close();
        }
        else{
            entrarAWhile = true;
        }

        while(entrarAWhile){
            System.out.println("Ingreso no permitido, intente nuevamente (y/n)");
            String teclado = entrada.nextLine();
            if (teclado.equals("y")){
                entrarAWhile = false;
                borrarParticipantes();
                entrada.close();
            }
            if (teclado.equals("n")){
                entrarAWhile = false;
                iniciarPrograma(false);
                entrada.close();
            }
        }
        entrada.close();
    }

    public static void main(String[] args) {
        iniciarPrograma(false);
    }
}
