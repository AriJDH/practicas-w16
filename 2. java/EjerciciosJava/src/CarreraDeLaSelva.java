import java.util.*;

public class CarreraDeLaSelva {

    public static Map<Integer, String[]> mapaCat1 = new HashMap<Integer, String[]>();
    public static Map<Integer, String[]> mapaCat2 = new HashMap<Integer, String[]>();
    public static Map<Integer, String[]> mapaCat3 = new HashMap<Integer, String[]>();
    public static int id = 0;

    public static void inscribir(Map<Integer, String[]> mapaCat1, Map<Integer, String[]> mapaCat2, Map<Integer, String[]> mapaCat3, int id){

        boolean flag = true;

        while(flag){
            Scanner catScanner = new Scanner(System.in);
            System.out.println("------------------------------------");
            System.out.println("A que categoría desea inscribir?");
            System.out.println("------------------------------------");
            System.out.println("1) Circuito chico");
            System.out.println("2) Circuito medio");
            System.out.println("3) Circuito Avanzado");
            System.out.println("4) Volver");
            System.out.println("------------------------------------");

            int categoria = catScanner.nextInt();

            switch(categoria){
                case 1:
                    String[] datos = new String[7];
                    Scanner datosScanner = new Scanner(System.in);
                    System.out.println("------------------------------------");
                    System.out.println("DNI:");
                    datos[0] = datosScanner.nextLine();
                    System.out.println("Nombre:");
                    datos[1] = datosScanner.nextLine();
                    System.out.println("Apellido:");
                    datos[2] = datosScanner.nextLine();
                    System.out.println("Edad:");
                    datos[3] = datosScanner.nextLine();
                    System.out.println("Celular:");
                    datos[4] = datosScanner.nextLine();
                    System.out.println("Numero de emergencia:");
                    datos[5] = datosScanner.nextLine();
                    System.out.println("Grupo sanguineo:");
                    datos[6] = datosScanner.nextLine();
                    System.out.println("------------------------------------");

                    id++;
                    mapaCat1.put(id, datos);

                    System.out.println("Inscripcion realizada con exito!");

                    int monto = 0;
                    if(Integer.parseInt(datos[3]) < 18){
                        monto = 1300;
                    } else {
                        monto = 1500;
                    }

                    System.out.println("La persona inscrita deberá abonar $" + monto + " pesos");
                    System.out.println("------------------------------------");
                break;
                case 2:
                    String[] datos2 = new String[7];
                    Scanner datosScanner2 = new Scanner(System.in);
                    System.out.println("------------------------------------");
                    System.out.println("DNI:");
                    datos2[0] = datosScanner2.nextLine();
                    System.out.println("Nombre:");
                    datos2[1] = datosScanner2.nextLine();
                    System.out.println("Apellido:");
                    datos2[2] = datosScanner2.nextLine();
                    System.out.println("Edad:");
                    datos2[3] = datosScanner2.nextLine();
                    System.out.println("Celular:");
                    datos2[4] = datosScanner2.nextLine();
                    System.out.println("Numero de emergencia:");
                    datos2[5] = datosScanner2.nextLine();
                    System.out.println("Grupo sanguineo:");
                    datos2[6] = datosScanner2.nextLine();
                    System.out.println("------------------------------------");

                    id++;
                    mapaCat2.put(id, datos2);

                    System.out.println("Inscripcion realizada con exito!");

                    int monto2 = 0;
                    if(Integer.parseInt(datos2[3]) < 18){
                        monto2 = 2000;
                    } else {
                        monto2 = 2300;
                    }

                    System.out.println("La persona inscrita deberá abonar $" + monto2 + " pesos");
                    System.out.println("------------------------------------");
                break;
                case 3:
                    String[] datos3 = new String[7];
                    Scanner datosScanner3 = new Scanner(System.in);
                    System.out.println("------------------------------------");
                    System.out.println("DNI:");
                    datos3[0] = datosScanner3.nextLine();
                    System.out.println("Nombre:");
                    datos3[1] = datosScanner3.nextLine();
                    System.out.println("Apellido:");
                    datos3[2] = datosScanner3.nextLine();
                    System.out.println("Edad:");
                    datos3[3] = datosScanner3.nextLine();
                    if(Integer.parseInt(datos3[3]) < 18){
                        System.out.println("Lo sentimos, no puede inscribir un menor a la categoría avanzada");
                        System.out.println("------------------------------------");
                    } else {
                        System.out.println("Celular:");
                        datos3[4] = datosScanner3.nextLine();
                        System.out.println("Numero de emergencia:");
                        datos3[5] = datosScanner3.nextLine();
                        System.out.println("Grupo sanguineo:");
                        datos3[6] = datosScanner3.nextLine();
                        System.out.println("------------------------------------");

                        id++;
                        mapaCat3.put(id, datos3);

                        System.out.println("Inscripcion realizada con exito!");

                        System.out.println("La persona inscrita deberá abonar $2800 pesos");
                        System.out.println("------------------------------------");
                    }
                break;
                case 4:
                    flag = false;
                break;
                default:
                    System.out.println("Numero de categoria incorrecto");
                break;
            }
        }

    }

    public static void listar(Map<Integer, String[]> mapaCat1, Map<Integer, String[]> mapaCat2, Map<Integer, String[]> mapaCat3){

        boolean flag = true;

        while(flag) {
            Scanner catScanner = new Scanner(System.in);
            System.out.println("------------------------------------");
            System.out.println("Los participantes de qué categoría desea listar?");
            System.out.println("------------------------------------");
            System.out.println("1) Circuito chico");
            System.out.println("2) Circuito medio");
            System.out.println("3) Circuito Avanzado");
            System.out.println("4) Volver");
            System.out.println("------------------------------------");

            int categoria = catScanner.nextInt();

            switch (categoria) {
                case 1:
                    for(Map.Entry<Integer, String[]> entrada : mapaCat1.entrySet()){
                        System.out.println("-----------------------");
                        System.out.println("Número de inscripción: " + entrada.getKey());
                        System.out.println(Arrays.toString(entrada.getValue()));
                        System.out.println("-----------------------");
                    }
                break;
                case 2:
                    for(Map.Entry<Integer, String[]> entrada : mapaCat2.entrySet()){
                        System.out.println("-----------------------");
                        System.out.println("Número de inscripción: " + entrada.getKey());
                        System.out.println(Arrays.toString(entrada.getValue()));
                        System.out.println("-----------------------");
                    }
                break;
                case 3:
                    for(Map.Entry<Integer, String[]> entrada : mapaCat3.entrySet()){
                        System.out.println("-----------------------");
                        System.out.println("Número de inscripción: " + entrada.getKey());
                        System.out.println(Arrays.toString(entrada.getValue()));
                        System.out.println("-----------------------");
                    }
                break;
                case 4:
                    flag = false;
                break;
                default:
                    System.out.println("Número de categoría incorrecto");
                break;
            }
        }

    }

    public static void desinscribir(Map<Integer, String[]> mapaCat1, Map<Integer, String[]> mapaCat2, Map<Integer, String[]> mapaCat3, int id){

        boolean flag = true;

        while(flag) {
            Scanner catScanner = new Scanner(System.in);
            System.out.println("------------------------------------");
            System.out.println("De qué categoría desea desinscribir un participante?");
            System.out.println("------------------------------------");
            System.out.println("1) Circuito chico");
            System.out.println("2) Circuito medio");
            System.out.println("3) Circuito Avanzado");
            System.out.println("4) Volver");
            System.out.println("------------------------------------");

            int categoria = catScanner.nextInt();

            switch (categoria) {
                case 1:
                    System.out.println("---------------");
                    System.out.println("Ingrese número de participante que desea desinscribir: ");
                    Scanner scan1 = new Scanner(System.in);
                    int num1 = scan1.nextInt();

                    mapaCat1.remove(num1);

                    System.out.println("El participante fue desinscipto exitosamente");
                    System.out.println("-------------------------");
                break;
                case 2:
                    System.out.println("---------------");
                    System.out.println("Ingrese número de participante que desea desinscribir");
                    Scanner scan2 = new Scanner(System.in);
                    int num2 = scan2.nextInt();

                    mapaCat2.remove(num2);

                    System.out.println("El participante fue desinscipto exitosamente");
                    System.out.println("-------------------------");
                break;
                case 3:
                    System.out.println("---------------");
                    System.out.println("Ingrese número de participante que desea desinscribir");
                    Scanner scan3 = new Scanner(System.in);
                    int num3 = scan3.nextInt();

                    mapaCat3.remove(num3);

                    System.out.println("El participante fue desinscipto exitosamente");
                    System.out.println("-------------------------");
                break;
                case 4:
                    flag = false;
                break;
                default:
                    System.out.println("Número de categoría incorrecto");
                break;
            }
        }

    }

    public static void main(String[] args) {

        boolean flag = true;

        while(flag){
            System.out.println("Carrera de la Selva");
            System.out.println("--------------------");
            System.out.println("1) Inscribir a un nuevo participante");
            System.out.println("2) Mostrar participantes por categoría");
            System.out.println("3) Desinscribir participante");
            System.out.println("4) Cerrar el programa");
            System.out.println("--------------------");

            Scanner scan = new Scanner(System.in);
            int opcion = scan.nextInt();

            switch(opcion){
                case 1:
                    inscribir(mapaCat1, mapaCat2, mapaCat3, id);
                break;
                case 2:
                    listar(mapaCat1, mapaCat2, mapaCat3);
                break;
                case 3:
                    desinscribir(mapaCat1, mapaCat2, mapaCat3, id);
                break;
                case 4:
                    flag = false;
                break;
                default:
                    System.out.println("Numero de opcion incorrecto");
                    System.out.println("-----------------------------");
                break;

            }
        }
    }

}
