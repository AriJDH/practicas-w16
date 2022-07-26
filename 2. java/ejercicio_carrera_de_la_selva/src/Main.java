import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int inscriptionCounter = 1;
        ArrayList<String> runnersCircuitoChico = new ArrayList<>();
        ArrayList<String> runnersCircuitoMedio = new ArrayList<>();
        ArrayList<String> runnersCircuitoAvanzado = new ArrayList<>();

        boolean appIsBeingExecuted = true;

        while (appIsBeingExecuted){
            Scanner scanner = new Scanner(System.in);
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("Opciones: 1. Inscribir - 2. Inscriptos en una categoria - 3. Desinscribir - 4. Salir");
            System.out.println("------------------------------------------------------------------------------------");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Inscribir nuevo participante.");
                    enrollNewRunnerConsidering(scanner, inscriptionCounter, runnersCircuitoChico, runnersCircuitoMedio, runnersCircuitoAvanzado);
                    inscriptionCounter += 1;
                    continue;
                case "2":
                    System.out.println("Listar participantes. Escriba: 1. circuito chico - 2. circuito medio - 3. circuito avanzado");
                    listAllRunnersOfCategory(scanner, runnersCircuitoChico, runnersCircuitoMedio, runnersCircuitoAvanzado);
                    continue;
                case "3":
                    System.out.println("Desinscribir un corredor. Ingrese DNI.");
                    removeInscriptionOfRunner(scanner, runnersCircuitoChico, runnersCircuitoMedio, runnersCircuitoAvanzado);
                    continue;
                default:
                    appIsBeingExecuted = false;
                    break;
            }}

    }

    private static void removeInscriptionOfRunner(Scanner scanner, ArrayList<String> runnersCircuitoChico, ArrayList<String> runnersCircuitoMedio, ArrayList<String> runnersCircuitoAvanzado) {
        System.out.println("Escriba el dni del corredor a eliminar.");
        String dni = scanner.nextLine();

        if(runnersCircuitoChico.stream().filter(runner -> runner.contains(dni)).findFirst().isPresent()) {
            String runner = runnersCircuitoChico.stream().filter(aRunner -> aRunner.contains(dni)).findFirst().get();
            runnersCircuitoChico.remove(runner);
        } else if(runnersCircuitoMedio.stream().filter(runner -> runner.contains(dni)).findFirst().isPresent()) {
            String runner = runnersCircuitoMedio.stream().filter(aRunner -> aRunner.contains(dni)).findFirst().get();
            runnersCircuitoMedio.remove(runner);
        } else if(runnersCircuitoAvanzado.stream().filter(runner -> runner.contains(dni)).findFirst().isPresent()) {
            String runner = runnersCircuitoAvanzado.stream().filter(aRunner -> aRunner.contains(dni)).findFirst().get();
            runnersCircuitoAvanzado.remove(runner);
        } else {
            System.out.println("No existe runner con Dni ingresado.");
        }
    }

    private static void listAllRunnersOfCategory(Scanner scanner, ArrayList<String> runnersCircuitoChico, ArrayList<String> runnersCircuitoMedio, ArrayList<String> runnersCircuitoAvanzado) {
        switch (scanner.nextInt()) {
            case 1:
                runnersCircuitoChico.forEach(System.out::println);
                break;
            case 2:
                runnersCircuitoMedio.forEach(System.out::println);
                break;
            case 3:
                runnersCircuitoAvanzado.forEach(System.out::println);
                break;
            default:
                System.out.println("No has escrito un numero de categoria válido.");
        }
    }

    private static void enrollNewRunnerConsidering(Scanner scanner, int inscriptionCounter, ArrayList<String> runnersCircuitoChico, ArrayList<String> runnersCircuitoMedio, ArrayList<String> runnersCircuitoAvanzado) {
        System.out.println("Ingrese DNI");
        String dni = scanner.nextLine();
        System.out.println("Ingrese Nombre, Apellido y Celular");
        String data = scanner.nextLine();
        System.out.println("Ingrese la edad");
        int years = scanner.nextInt();

        System.out.println("Escriba numero de Categoria: 1. chico - 2. medio - 3. avanzado");
        int categoryNumber = scanner.nextInt();

        String newRunner = "Inscripcion: " + inscriptionCounter + " - DNI: " + dni + " - Datos: " + data + " " + years;

        if (years < 18 && categoryNumber == 3) {
            inscriptionCounter -= 1;
            System.out.println("No puedes inscribirte siendo menor a categoria Avanzado.");
        } else {
            if(categoryNumber == 1) {
                runnersCircuitoChico.add(newRunner);
            } else if(categoryNumber == 2) {
                runnersCircuitoMedio.add(newRunner);
            } else {
                runnersCircuitoAvanzado.add(newRunner);
            }
            printPriceToPayForARunnerEnrolledIn(categoryNumber, years);
        }

    }

    private static void printPriceToPayForARunnerEnrolledIn(int aCategoryNumber, int anAmountOfYears) {
        int price;
        if (aCategoryNumber == 1) {
            if(anAmountOfYears < 18) {
                price = 1300;
            } else {
                price = 1500;
            }
        } else if (aCategoryNumber == 2) {
            if(anAmountOfYears < 18) {
                price = 2000;
            } else {
                price = 2300;
            }
        } else {
            price = 2800;
        }
        System.out.println("El precio es " + price + "$");
    }

}
