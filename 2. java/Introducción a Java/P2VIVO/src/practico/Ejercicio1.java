package practico;

import java.util.*;

public class Ejercicio1 {
    public int inscriptosTotales = -1;
    HashMap<Integer, List> participantes = new HashMap<Integer, List>();
    HashMap<Integer, String> circuitos = new HashMap<Integer, String>();

    public String elegirCircuito(int edad) {
        Scanner entradaCircuito = new Scanner(System.in);
        String circuito = "";
        boolean invalido = false;
        do {
            System.out.println();
            System.out.println("--- Seleccionar Circuito ---");
            if (edad >= 18) {
                System.out.println("" +
                        "1) Circuito Chico (2Km por selva y arroyos)\n" +
                        "2) Circuito Medio (5Km por selva, arroyos y barro)\n" +
                        "3) Circuito Avanzado (10km por selva, arroyos, barro y escalada por piedra)");

            } else {
                System.out.println("" +
                        "1) Circuito Chico (2Km por selva y arroyos)\n" +
                        "2) Circuito Medio (5Km por selva, arroyos y barro)");
            }
            int circuitoElegido = entradaCircuito.nextInt();

            switch (circuitoElegido) {
                case 1:
                    circuito = "Circuito Chico";
                    invalido = false;
                    break;
                case 2:
                    circuito = "Circuito Medio";
                    invalido = false;
                    break;
                case 3:
                    if (edad < 18) {
                        System.out.println("[ERROR] Ingresó un valor inválido, vuelva a intentar.\n");
                        invalido = true;
                    } else {
                        circuito = "Circuito Avanzado";
                        invalido = false;
                    }
                    break;
                default:
                    System.out.println("[ERROR] Ingresó un valor inválido, vuelva a intentar.\n");
                    invalido = true;
                    break;
            }
        } while (invalido);
        return circuito;
    }


    public int calcularCostoInscripcion(int edad, String circuito) {
        int costo = 0;
        switch (circuito) {
            case "Circuito Chico":
                if (edad < 18) {
                    costo = 1300;
                } else {
                    costo = 1500;
                }
                break;
            case "Circuito Medio":
                if (edad < 18) {
                    costo = 2000;
                } else {
                    costo = 2300;
                }
                break;
            case "Circuito Avanzado":
                costo = 2800;
                break;
        }
        return costo;
    }

    public void inscribirParticipante() {
        List<String> nuevoParticipante = new ArrayList<>();

        inscriptosTotales++;
        int numeroId = inscriptosTotales;
        String nombre, apellido, grupoSanguineo, nroEmergencia, celular;
        int edad, dni;
        Scanner entradaInscripcion = new Scanner(System.in);

        nuevoParticipante.add(0, String.valueOf(numeroId));
        System.out.println();
        System.out.println("--- Ingresar datos de participante ---");
        System.out.print("DNI: ");
        dni = entradaInscripcion.nextInt();
        nuevoParticipante.add(1, String.valueOf(dni));
        entradaInscripcion.nextLine();
        if (participantes.containsKey(dni)) { //Ya está registrado, elegír nueva categoria
            System.out.print("Ya está registrado el DNI: " + dni + " ");
            if (circuitos.containsKey(dni)) {
                System.out.println("y está inscrito a " + circuitos.get(dni));

            } else {
                System.out.println();
                edad = Integer.parseInt(participantes.get(dni).get(4).toString());
                String circuito = elegirCircuito(edad);

                circuitos.put(dni, circuito);

                int costoInscripcion = calcularCostoInscripcion(edad, circuito);

                System.out.println();
                System.out.println("El costo de inscripción es de: $" + costoInscripcion);
            }
        } else {  //No existe, registrar y elegir categoria.
            System.out.print("Nombre: ");
            nombre = entradaInscripcion.nextLine();
            nuevoParticipante.add(2, nombre);
            System.out.print("Apellido: ");
            apellido = entradaInscripcion.nextLine();
            nuevoParticipante.add(3, apellido);
            System.out.print("Edad: ");
            edad = entradaInscripcion.nextInt();
            nuevoParticipante.add(4, String.valueOf(edad));
            entradaInscripcion.nextLine();
            System.out.print("Celular: ");
            celular = entradaInscripcion.nextLine();
            nuevoParticipante.add(5, celular);
            System.out.print("Nro. Emergencia: ");
            nroEmergencia = entradaInscripcion.nextLine();
            nuevoParticipante.add(6, nroEmergencia);
            System.out.print("Grupo Sanguíneo: ");
            grupoSanguineo = entradaInscripcion.nextLine();
            nuevoParticipante.add(7, grupoSanguineo);

            participantes.put(dni, nuevoParticipante);

            String circuito = elegirCircuito(edad);
            circuitos.put(dni, circuito);

            int costoInscripcion = calcularCostoInscripcion(edad, circuito);

            System.out.println();
            System.out.println("El costo de inscripción es de: $" + costoInscripcion + "\n");
        }
    }

    public void mostrarInscriptosPorCircuito() {
        String circuito = "";
        System.out.println("\n--- Inscritos a un Circuito ---");
        System.out.println("" +
                "1) Circuito Chico (2Km por selva y arroyos)\n" +
                "2) Circuito Medio (5Km por selva, arroyos y barro)\n" +
                "3) Circuito Avanzado (10km por selva, arroyos, barro y escalada por piedra)");
        System.out.print("Circuito: ");
        Scanner listEntrada = new Scanner(System.in);
        int circuitoElegido = listEntrada.nextInt();

        boolean invalido = false;
        do {
            switch (circuitoElegido) {
                case 1:
                    circuito = "Circuito Chico";
                    break;
                case 2:
                    circuito = "Circuito Medio";
                    break;
                case 3:
                    circuito = "Circuito Avanzado";
                    break;
                default:
                    System.out.println("[ERROR] Ingresó un valor inválido, vuelva a intentar.\n");
                    invalido = true;
                    break;
            }
        } while (invalido);

        if (circuitos.containsValue(circuito)) {
            System.out.println("\n--- Participantes del " + circuito + " ---");
            for (Map.Entry inscrito : circuitos.entrySet()) {
                if (inscrito.getValue() == circuito) {
                    System.out.println(participantes.get(inscrito.getKey()));
                }
            }
        } else {
            System.out.println("\nEl " + circuito + " no tiene participantes inscritos.");
        }

    }

    public void desinscribirParticipante() {
        System.out.println("\n--- Desinscribir participante ---");
        System.out.print("DNI: ");
        Scanner unsubEntrada = new Scanner(System.in);
        int dni = unsubEntrada.nextInt();

        if (circuitos.containsKey(dni)) {
            String circuitoInscrito = circuitos.get(dni);
            circuitos.remove(dni);
            System.out.println("Participante desinscrito del " + circuitoInscrito + " con exito!\n");
        } else {
            System.out.println("No existe un participante con el DNI: " + dni + "\n");
        }
    }

    public void menu() {
        boolean mantenerSistema = true;

        do {
            System.out.println();
            System.out.println("--- Sistema CARRERA DE LA SELVA ---");
            System.out.println("----------------MENÚ---------------");
            System.out.println("1) Inscribir participante");
            System.out.println("2) Desinscrbir participante a un circuito");
            System.out.println("3) Lista inscritos a un circuito");
            System.out.println("4) Salir");
            System.out.println();

            Scanner entradaMenu = new Scanner(System.in);
            System.out.print("Opción: ");
            int optMenu = entradaMenu.nextInt();
            switch (optMenu) {
                case 1:
                    inscribirParticipante();
                    break;
                case 2:
                    desinscribirParticipante();
                    break;
                case 3:
                    mostrarInscriptosPorCircuito();
                    break;
                case 4:
                    System.out.println("Finalizando Sistema....");
                    mantenerSistema = false;
                    break;
                default:
                    System.out.println("[ERROR] Elegir una opción correcta.");
                    break;
            }
        } while (mantenerSistema);

    }

    public static void main(String[] args) {
        Ejercicio1 x = new Ejercicio1();
        x.menu();
    }

}
