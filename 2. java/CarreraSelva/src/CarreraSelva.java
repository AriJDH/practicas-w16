import java.util.HashMap;
import java.util.Scanner;

public class CarreraSelva {

    static Scanner leer = new Scanner(System.in);
    static Integer contInscritos = 0;

    static HashMap<Integer, Participante> circuitoChico = new HashMap<Integer, Participante>();
    static HashMap<Integer, Participante> circuitoMedio = new HashMap<Integer, Participante>();
    static HashMap<Integer, Participante> circuitoAvanzado = new HashMap<Integer, Participante>();

    public static void main(String[] args) {

        Integer opcion = 0;

        do {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n");

            System.out.println("1. Inscribir participante");
            System.out.println("2. Mostrar inscritos por categoria");
            System.out.println("3. Desinscribir participante");
            System.out.println("4. Monto a pagar por participante");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            opcion = leer.nextInt();

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n");

            if (opcion == 1) {
                capturarDatos();
            } else if (opcion == 2) {
                mostrarDatos();
            } else if (opcion == 3) {
                desinscribirParticipante();
            } else if (opcion == 4) {
                mostrarMonto();
            }

        } while (opcion != 5);

    }

    public static void mostrarMonto() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");

        Integer categoria = capturarCategoria("ver el monto a pagar");

        System.out.print("Ingrese el ID de la inscripcion: ");
        Integer id = leer.nextInt();

        if (categoria == 1) {
            System.out.println("El participante: " + circuitoChico.get(id).getNombre() + " " +
                    circuitoChico.get(id).getApellido() + " - Debe pagar: " + circuitoChico.get(id).getMontoPago());
        } else if (categoria == 2) {
            System.out.println("El participante: " + circuitoMedio.get(id).getNombre() + " " +
                    circuitoMedio.get(id).getApellido() + " - Debe pagar: " + circuitoMedio.get(id).getMontoPago());
        } else if (categoria == 3) {
            System.out.println("El participante: " + circuitoAvanzado.get(id).getNombre() + " " +
                    circuitoAvanzado.get(id).getApellido() + " - Debe pagar: " + circuitoAvanzado.get(id).getMontoPago());
        }
    }

    public static void desinscribirParticipante() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");

        Integer categoria = capturarCategoria("desinscribirse");

        System.out.print("Ingrese el ID de la inscripcion: ");
        Integer id = leer.nextInt();
        if (categoria == 1) {
            circuitoChico.remove(id);
            System.out.println("Participante eliminado");
        } else if (categoria == 2) {
            circuitoMedio.remove(id);
            System.out.println("Participante eliminado");
        } else if (categoria == 3) {
            circuitoAvanzado.remove(id);
            System.out.println("Participante eliminado");
        }
    }

    public static void mostrarDatos() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");

        Integer categoria = capturarCategoria("ver inscritos");

        if (categoria == 1) {
            System.out.println("Los participantes para Circuito Chico son: ");
            for (Integer i : circuitoChico.keySet()) {
                System.out.println("Inscrito numero: " + i);
                System.out.println(circuitoChico.get(i).toString());
            }
        } else if (categoria == 2) {
            System.out.println("Los participantes para Circuito Chico son: ");
            for (Integer i : circuitoMedio.keySet()) {
                System.out.println("Inscrito numero: " + i);
                System.out.println(circuitoMedio.get(i).toString());
            }
        } else if (categoria == 3) {
            System.out.println("Los participantes para Circuito Chico son: ");
            for (Integer i : circuitoAvanzado.keySet()) {
                System.out.println("Inscrito numero: " + i);
                System.out.println(circuitoAvanzado.get(i).toString());
            }
        }
    }

    public static void capturarDatos() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");

        Participante participante = new Participante();

        Integer categoria = capturarCategoria("Inscribirse");

        if (categoria == 1 || categoria == 2 || categoria == 3) {
            System.out.print("Ingrese DNI: ");
            participante.setDni(leer.next());

            System.out.print("Ingrese nombre: ");
            participante.setNombre(leer.next());

            System.out.print("Ingrese apellido: ");
            participante.setApellido(leer.next());

            System.out.print("Ingrese edad: ");
            participante.setEdad(leer.nextInt());

            System.out.print("Ingrese celular: ");
            participante.setCelular(leer.next());

            System.out.print("Ingrese número emergencia: ");
            participante.setNumeroEmergencia(leer.next());

            System.out.print("Ingrese grupo sanguineo: ");
            participante.setGrupoSanguineo(leer.next());

            if (categoria == 1) {
                if (participante.getEdad() < 18) {
                    participante.setMontoPago(1300);
                } else if (participante.getEdad() > 18) {
                    participante.setMontoPago(1500);
                }
                circuitoChico.put(++contInscritos, participante);
                System.out.println("Se agrego correctamente");
            } else if (categoria == 2) {
                if (participante.getEdad() < 18) {
                    participante.setMontoPago(2000);
                } else if (participante.getEdad() > 18) {
                    participante.setMontoPago(2300);
                }
                circuitoMedio.put(++contInscritos, participante);
                System.out.println("Se agrego correctamente");
            } else if (categoria == 3) {
                if (participante.getEdad() < 18) {
                    participante.setMontoPago(0);
                    System.out.println("No se permite inscripcion!!");
                } else if (participante.getEdad() > 18) {
                    participante.setMontoPago(2800);
                    circuitoAvanzado.put(++contInscritos, participante);
                    System.out.println("Se agrego correctamente");
                }
            }
        } else {
            System.out.println("Categoria no existe");
        }
    }

    public static Integer capturarCategoria(String mensaje) {
        Integer categoria;

        System.out.println("1. Circuito chico");
        System.out.println("2. Circuito medio");
        System.out.println("3. Circuito avanzado");
        System.out.print("Ingrese la categoria a la que quiere " + mensaje + ": ");
        categoria = leer.nextInt();

        return categoria;
    }

}
