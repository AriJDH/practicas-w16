import java.util.*;

public class EjercicioPractico {

    static ArrayList<String> participantesTotal = new ArrayList<>();
    static HashMap<String, ArrayList> circuitoChico = new HashMap<>();
    static HashMap<String, ArrayList> circuitoMedio = new HashMap<>();
    static HashMap<String, ArrayList> circuitoAvanzado = new HashMap<>();
    static int edadPorCobro;

    public static void categorías() {

        System.out.println("Bienvenid@ a Carrera de la Selva, indicanos tu EDAD");
        Scanner dataEntry = new Scanner(System.in);
        Scanner circuito = new Scanner(System.in);

        int edad = dataEntry.nextInt();

        if (edad < 18) {
            edadPorCobro = edad;
            System.out.println("Seleccioná tu circuito favorito:\n" +
                    "1)Circuito chico: 2 km por selva y arroyos.\n" +
                    "2)Circuito medio: 5 km por selva, arroyos y barro.\n" +
                    "IMPORTANTE SI TENES MENOS DE 18 AÑOS NO PODES ACCEDER AL CIRCUITO AVANZADO");
        } else {
            System.out.println("Seleccioná tu circuito favorito:\n" +
                    "1)Circuito chico: 2 km por selva y arroyos.\n" +
                    "2)Circuito medio: 5 km por selva, arroyos y barro.\n" +
                    "3)Circuito Avanzado: 10 km por selva, arroyos, barro y escalada en piedra.\n" +
                    "IMPORTANTE SI TENES MENOS DE 18 AÑOS NO PODES ACCEDER AL CIRCUITO AVANZADO");

        }
        int circuitoIngresado = circuito.nextInt();

        switch (circuitoIngresado) {
            case 1:
                circuitoChico();
                break;
            case 2:
                circuitoMedio();
                break;
            case 3:
               circuitoAvanzado();
                break;
            default:
                System.out.println("Elige una opción correcta.");
                break;
        }
    }

       public static void circuitoChico() {
            ArrayList participante = incripcion();
            circuitoChico.put(String.valueOf(participantesTotal.size() + 1), participante);
            participantesTotal.add("chico");
            System.out.println(circuitoChico);
            if(edadPorCobro< 18){
                System.out.println("El monto a abonar es de $1300");
            }else{
                System.out.println("El monto a abonar es de $1500");

            }
        }

    public static void circuitoMedio() {
        ArrayList participante = incripcion();
        circuitoMedio.put(String.valueOf(participantesTotal.size() + 1), participante);
        participantesTotal.add("medio");
        System.out.println(circuitoMedio);
        if(edadPorCobro< 18){
            System.out.println("El monto a abonar es de $2000");
        }else {
            System.out.println("El monto a abonar es de $2300");

        }
    }

    public static void circuitoAvanzado() {
        ArrayList participante = incripcion();
        participantesTotal.add("avanzado");
        circuitoAvanzado.put(String.valueOf(participantesTotal.size() + 1), participante);
        System.out.println("El monto a abonar es de $2800");
        System.out.println(circuitoAvanzado);
    }

        public static ArrayList<String> incripcion() {

        ArrayList<String> nuevoParticipante = new ArrayList<>();
            String nombre, apellido, grupoSanguineo, celular, numEmergencia;
            Integer dni;
            Scanner ingresoDeDatos = new Scanner(System.in);

            System.out.println("Introduzca nombre");
            nombre = ingresoDeDatos.nextLine();
            nuevoParticipante.add(0, nombre);

            System.out.println("Introduzca apellido");
            apellido = ingresoDeDatos.nextLine();
            nuevoParticipante.add(1, apellido);

            System.out.println("Introduzca grupoSanguineo");
            grupoSanguineo = ingresoDeDatos.nextLine();
            nuevoParticipante.add(2, grupoSanguineo);

            System.out.println("Introduzca DNI");
            dni = Integer.valueOf(ingresoDeDatos.nextLine());
            nuevoParticipante.add(3, String.valueOf(dni));

            System.out.println("Introduzca número de celular");
            celular = ingresoDeDatos.nextLine();
            nuevoParticipante.add(4, String.valueOf(celular));

            System.out.println("Introduzca Telefono de Emergencia");
            numEmergencia = ingresoDeDatos.nextLine();
            nuevoParticipante.add(5, String.valueOf(numEmergencia));
            nuevoParticipante.add(String.valueOf(participantesTotal.size()+ 1));
            System.out.println(nuevoParticipante);
            return nuevoParticipante;
        }

    public static void menuCarrera() {

        boolean funcionamientoMenu = true;
        do {
            System.out.println("----------------MENU PRINCIPAL. Digita:---------------");
            System.out.println("1.- Inscribir un participante");
            System.out.println("2.- Desinscrbir participante");
            System.out.println("3.- Lista inscritos");
            System.out.println("4.- Salir");
            System.out.println();

            Scanner entradaMenu = new Scanner(System.in);
            System.out.print("Opción: ");
            int opcion = entradaMenu.nextInt();
            switch (opcion) {
                case 1:
                    categorías();
                    break;
                case 2:
                    System.out.println("Ingrese el numero de participante");
                    Scanner chau = new Scanner(System.in);
                    int chauchau = chau.nextInt();
                    desinscribir(chauchau);
                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("Finalizando Sistema....");
                    funcionamientoMenu = false;
                    break;
                default:
                    System.out.println("[ERROR] Elegir una opción correcta.");
                    break;
            }
        }
            while (funcionamientoMenu) ;
        }

    public static void desinscribir(int inscripto){
        String encontrar = participantesTotal.get(inscripto - 1);
        switch (encontrar){
            case "chico": circuitoChico.remove(String.valueOf(inscripto));
            participantesTotal.set(inscripto -1, "desinscripto");
            break;
            case "medio": circuitoMedio.remove(String.valueOf(inscripto));
                participantesTotal.set(inscripto -1, "desinscripto");
                break;
            case "avanzado": circuitoAvanzado.remove(String.valueOf(inscripto));
                participantesTotal.set(inscripto -1, "desinscripto");
            break;
            case "desinscripto":
                System.out.println("No estás en la carrera");
                break;
            default:
                System.out.println("Datos erroneos");
        }
    }

    public static void main(String[] args) {
        System.out.println("Programa Carrera de la Selva");
        menuCarrera();

    }

}
