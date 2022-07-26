import java.sql.SQLOutput;
import java.util.*;

public class CarreraDeLaSelva {
    static List<Map> circuitoChico = new ArrayList<>();
    static List<Map> circuitoMedio = new ArrayList<>();
    static List<Map> circuitoAvanzado = new ArrayList<>();

    public static void insertUser(String dni, String nombre, String apellido, String edad,
                            String celular, String numeroEmergencia, String grupoSanguineo,
                            String  numeroParticipante, String montoAbonar, List<Map> lista){
        Map<String, String> map = new HashMap<String,String>();
        map.put("dni", dni);
        map.put("nombre",nombre);
        map.put("apellido",apellido);
        map.put("edad",edad);
        map.put("celular",celular);
        map.put("numeroEmergencia",numeroEmergencia);
        map.put("grupoSanguineo",grupoSanguineo);
        map.put("numeroParticipante",numeroParticipante);
        map.put("montoAbonar",montoAbonar);
        lista.add(map);


    }
    
    public static void imprimirUsuarios( List<Map> lista){
        System.out.println("DNI \t NOMBRE \t APELLIDO \t EDAD \t CELULAR \t #EMERGENCIA \t GRUPOSANGUINEO  #PARTICIPANTE  MONTO ABONAR");
        for (Map<String,String> map: lista) {
            String dni= map.get("dni");
            String nombre = map.get("nombre");
            String apellido = map.get("apellido");
            String edad = map.get("edad");
            String celular = map.get("celular");
            String numeroEmergencia = map.get("numeroEmergencia");
            String grupoSanguineo = map.get("grupoSanguineo");
            String numeroParticipante = map.get("numeroParticipante");
            String montoAbonar = map.get("montoAbonar");
            System.out.println(dni+"\t"+nombre+"\t"+apellido+"\t"+edad+"\t"+celular+"\t"+numeroEmergencia+"\t"+grupoSanguineo+"\t"+numeroParticipante
                    +"\t"+montoAbonar);
        }

    }
    public static void eliminarParticipante(List<Map> lista, String numeroParticipante){
        int contador=0;
        int i=-1;
        for (Map<String,String> map: lista){
            if(map.get("numeroParticipante").equals(numeroParticipante)){
                i=contador;
            }
            contador++;
        }
        if (i!=-1) {
            lista.remove(i);
            System.out.println("Participante Eliminado");
        }else{
            System.out.println("No se Encontro el Participante");
        }
    }
    public static void main(String[] args) {
        int seguir=1;
        int opcion;
        int categoria;
        int montoAbonar;
        int numeroParticipante=1;
        Scanner teclado=new Scanner(System.in);
        do {
            System.out.println("##########################################################");
            System.out.println("Bienvenido Seleccione una opcion: ");
            System.out.println("----------------------------------------------------------");
            System.out.println("1. Inscribir nuevo participante");
            System.out.println("2. Motrar Participantes inscritos");
            System.out.println("3. Eliminar a un participante");
            opcion= teclado.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Inscribir Nuevo Participante");
                    System.out.print("Ingrese dni:");
                    String dni = teclado.next();
                    System.out.print("Ingrese Nombre");
                    String nombre = teclado.next();
                    System.out.print("Ingrese Apellido");
                    String apellido = teclado.next();
                    System.out.print("Ingrese Edad");
                    String edad = teclado.next();
                    System.out.print("Ingrese Celular");
                    String celular = teclado.next();
                    System.out.print("Ingrese Numero de Emergencia");
                    String numeroEmergencia = teclado.next();
                    System.out.print("Ingrese Grupo Sanguineo");
                    String grupoSanguineo = teclado.next();
                    System.out.println("Ingrese la Categoria");
                    System.out.println("1. Circuito Chico");
                    System.out.println("2. Circuito Medio");
                    System.out.println("3. Circuito Avanzado");
                    categoria=teclado.nextInt();
                    switch (categoria){
                        case 1:
                            if(Integer.parseInt(edad)<=18){
                                montoAbonar=1300;
                            }else{
                                montoAbonar=1500;
                            }
                            insertUser(dni,nombre,apellido,edad,celular,numeroEmergencia,grupoSanguineo,
                                    String.valueOf(numeroParticipante),String.valueOf(montoAbonar),circuitoChico);
                            break;
                        case 2:
                            if(Integer.parseInt(edad)<=18){
                                montoAbonar=2000;
                            }else{
                                montoAbonar=2300;
                            }
                            insertUser(dni,nombre,apellido,edad,celular,numeroEmergencia,grupoSanguineo,
                                    String.valueOf(numeroParticipante),String.valueOf(montoAbonar),circuitoMedio);
                            break;
                        case 3:
                            if(Integer.parseInt(edad)>=18){
                                montoAbonar=2800;
                                insertUser(dni,nombre,apellido,edad,celular,numeroEmergencia,grupoSanguineo,
                                        String.valueOf(numeroParticipante),String.valueOf(montoAbonar),circuitoAvanzado);
                            }else{
                                System.out.println("No se puede inscribir participantes menores de 18 años");
                                break;
                            }
                            break;
                        default:
                            System.out.println("opcion no valida");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Mostrar Participantes");
                    System.out.println("Ingrese la Categoria");
                    System.out.println("1. Circuito Chico");
                    System.out.println("2. Circuito Medio");
                    System.out.println("3. Circuito Avanzado");
                    categoria=teclado.nextInt();
                    switch (categoria){
                        case 1:
                            System.out.println(circuitoChico);
                            imprimirUsuarios(circuitoChico);
                            break;
                        case 2:
                            System.out.println(circuitoMedio);
                            imprimirUsuarios(circuitoMedio);
                            break;
                        case 3:
                            System.out.println(circuitoAvanzado);
                            imprimirUsuarios(circuitoAvanzado);
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Eliminar de una lista");
                    System.out.println("Ingrese la Categoria");
                    System.out.println("1. Circuito Chico");
                    System.out.println("2. Circuito Medio");
                    System.out.println("3. Circuito Avanzado");
                    categoria=teclado.nextInt();
                    System.out.println("Ingrese numero Participante");
                    String numParticipante = teclado.next();

                    switch (categoria){
                        case 1:
                            eliminarParticipante(circuitoChico,numParticipante);
                            break;
                        case 2:
                            eliminarParticipante(circuitoChico,numParticipante);
                            break;
                        case 3:
                            eliminarParticipante(circuitoChico,numParticipante);
                            break;
                        default:
                            System.out.println("Opcion No Valida");
                            break;
                    }

                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
            System.out.println("Quiere Continuar: ");
            System.out.println("1. Si");
            System.out.println("2. No");
            seguir=teclado.nextInt();
            numeroParticipante++;
        }while(seguir!=2);

    }
}
