import java.util.*;

public class Carrera {
    //Cada participante puede inscribirse a una unica categoria
    // dni,nombre,apellido,edad,celular,numEmergencia,grupoSanguineo

    private Map<Integer, List<String>> mapChico = new HashMap<Integer, List<String>>();
    private Map<Integer, List<String>> mapMedio = new HashMap<Integer, List<String>>();
    private Map<Integer, List<String>> mapAvanz = new HashMap<Integer, List<String>>();

    private void inscribir(){
        Scanner input = new Scanner(System.in);
        // TODO: habría que verificar que los valores ingresados, aunque se guarden como String, sean números
        System.out.println("Ingresar DNI: ");
        String dni = Integer.toString( input.nextInt() );
        System.out.println("Ingresar Nombre: ");
        String nombre = input.next();
        System.out.println("Ingresar Apellido: ");
        String apellido = input.next();
        System.out.println("Ingresar Edad: ");
        String edad = Integer.toString( input.nextInt() );
        System.out.println("Ingresar Celular: ");
        String cel = input.next();
        System.out.println("Ingresar Número de Emergencia: ");
        String emerg = input.next();
        System.out.println("Ingresar Grupo Sanguineo: ");
        String grupo = input.next();

        List<String> nuevosDatos = new ArrayList<>();
        Collections.addAll(nuevosDatos,dni,nombre,apellido,edad,cel,emerg,grupo);

        if (mapChico.containsValue(nuevosDatos) || mapMedio.containsValue(nuevosDatos) || mapAvanz.containsValue(nuevosDatos)){
            System.out.println("El participante ya está inscripto.");
        } else {
            System.out.println("A qué carrera quiere ingresar?\n 1) Circuito Chico\n 2) Circuito Medio\n 3) Circuito Avanzado\n 4) Cancelar");
            short opcion = input.nextShort();
            int nuevaKey;
            switch(opcion){
                case 1:
                    nuevaKey = mapChico.size() + 1;
                    mapChico.put(nuevaKey, nuevosDatos);
                    System.out.println("Inscripción Exitosa!");
                    if(Integer.parseInt(edad) < 18){
                        System.out.println("Abonar $1300.");
                    }
                    else {
                        System.out.println("Abonar $1500.");
                    }
                    break;
                case 2:
                    nuevaKey = mapMedio.size() + 1;
                    mapMedio.put(nuevaKey, nuevosDatos);
                    System.out.println("Inscripción Exitosa!");
                    if(Integer.parseInt(edad) < 18){
                        System.out.println("Abonar $2000.");
                    }
                    else {
                        System.out.println("Abonar $2300.");
                    }
                    break;
                case 3:
                    if(Integer.parseInt(edad) < 18){
                        System.out.println("No pueden participar los menores de 18 años en este circuito.");
                    }
                    else {
                        nuevaKey = mapAvanz.size() + 1;
                        mapAvanz.put(nuevaKey, nuevosDatos);
                        System.out.println("Inscripción Exitosa!");
                        System.out.println("Abonar $2800.");
                    }
                    break;
                default:
                    System.out.println("Acción Cancelada.");
            }
        }
    }

    private void desinscribir(){
        // borrar segun key, unicamente porque es más rápido.
    }

    private void inscriptos(){
        // preguntar cual mapa. ultima opcion muestra todos los mapas.
        // recorrer las keys de cada mapa y mostrar.

    }

    private void info(){
        // Imprimir valores
        System.out.println("Circuito Chico:\n\t Menores de 18: $1300\n\t Mayores de 18: $1500\n" +
                            "Circuito Medio:\n\t Menores de 18: $2000\n\t Mayores de 18: $2300\n" +
                            "Circuito Avanzado:\n\t Menores de 18: No Válido\n\t Mayores de 18: $2800");
    }


    public static void main(String[] args) {
        boolean salida = false;
        short opcion;
        Carrera actual = new Carrera();

        while(!salida){
            Scanner input = new Scanner(System.in);

            System.out.println("Elija una opción: ");
            System.out.println("1) Inscribir Participante\n" +
                    "2) Desinscribir Participante\n" +
                    "3) Mostrar Inscriptos\n" +
                    "4) Información - Montos por Categoría\n" +
                    "5) Salir");
            opcion = input.nextShort();

            switch(opcion){
                case 1:
                    actual.inscribir();
                    break;
                case 2:
                    actual.desinscribir();
                    break;
                case 3:
                    actual.inscriptos();
                    break;
                case 4:
                    actual.info();
                    break;
                case 5:
                    salida = true;
                    break;
                default:
                    System.out.println("Opción Invalida.");
            }
        }
    }
}
