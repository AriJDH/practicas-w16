package pgEjercicios;

import java.util.*;

public class EstructurasDinamicas {
    static Map<String, String> circuitoChico = new HashMap<>();
    static Map<String, String> circuitoMedio = new HashMap<>();
    static Map<String, String> circuitoAvanzado = new HashMap<>();

    static Scanner scanner = new Scanner(System.in);

    static int inscriptionNumber = 1;

    public static void main(String[] args) {

        int option;

        do {

            System.out.println("Seleccione una opcion");
            System.out.println("1 - Inscribir participante");
            System.out.println("2 - Mostrar lista de inscriptos a una categoria");
            System.out.println("3 - Eliminar un participante");
            System.out.println("4 - Salir");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addRunner();
                    break;

                case 2:
                    showAllRunners();
                    break;

                case 3:
                    removeRunner();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
            }

        } while (option != 4);


    }

    static void addRunner() {
        System.out.println("Ingrese Nombre y apellido");
        String name = scanner.nextLine();
        System.out.println("Ingrese el DNI");
        String dni = scanner.nextLine();

        System.out.println("Ingrese celular");
        String phone = scanner.nextLine();
        System.out.println("Ingrese la edad");
        int age = scanner.nextInt();
        System.out.println("Ingrese el numero de Categoria: 1-circuito chico, 2-circuito medio,  3-circuito avanzado");
        int categoryNumber = scanner.nextInt();

        String data = "Numero " + inscriptionNumber + " -- Nombre: " + name + "- DNI: " + dni + "- Celular: " + phone + "- Edad: " + age;
        switch (categoryNumber) {
            case 1:
                if (age < 18)
                    System.out.println("El costo de inscripcion de $1300");
                else
                    System.out.println("El costo de inscripcion de $1500");

                circuitoChico.put(dni, data);
                break;
            case 2:
                if (age < 18)
                    System.out.println("El costo de inscripcion de $2000");
                else
                    System.out.println("El costo de inscripcion de $2300");

                circuitoMedio.put(dni, data);
                break;

            case 3:
                if (age < 18) {
                    System.out.println("No se permite la inscripcion a menores");
                    inscriptionNumber--;
                } else {
                    System.out.println("El costo de inscripcion de $2800");
                    circuitoAvanzado.put(dni, data);
                }
                break;
            default:
                inscriptionNumber--;
                System.out.println("Seleccione una categoria valida");

        }
        inscriptionNumber++;
    }

    static void showAllRunners() {
        System.out.println("Ingrese la categoria que desea visualizar  1-circuito chico, 2-circuito medio,  3-circuito avanzado");
        int category = scanner.nextInt();

        switch (category) {
            case 1:
                circuitoChico.forEach((k,v) -> System.out.println(v));
                break;
            case 2:
                circuitoMedio.forEach((k,v) -> System.out.println(v));
                break;
            case 3:
                circuitoAvanzado.forEach((k,v) -> System.out.println(v));
                break;
            default:
                System.out.println("Ingrese una categoria valida");
        }
    }

    static void removeRunner() {
        System.out.println("Ingrese el DNI de la persona a borrar");
        String dni = scanner.nextLine();

        circuitoChico.remove(dni);
        circuitoMedio.remove(dni);
        circuitoAvanzado.remove(dni);
    }
}
