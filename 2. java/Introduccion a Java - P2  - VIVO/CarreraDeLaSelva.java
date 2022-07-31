import java.util.*;


public class CarreraDeLaSelva {
    static int numInscripcion = 0;


    public static void main(String[] args) {

        List<Map<String, String>> circuitoChico = new ArrayList();
        List<Map<String, String>> circuitoMedio = new ArrayList();
        List<Map<String, String>> circuitoAvanzado = new ArrayList();
        Scanner data = new Scanner(System.in);
        Map<String, String> datosParticipante = new HashMap();
        Map<String, String> participante1 = new HashMap();
        Map<String, String> participante2 = new HashMap();
        Map<String, String> participante3 = new HashMap();

        participante1.put("dni", "37200789");
        participante1.put("nombre","Elena");
        participante1.put("apellido","Gomez");
        participante1.put("edad","28");
        participante1.put("celular","1127382912");
        participante1.put("numeroEmergencia","122323312212");
        participante1.put("grupoSanguineo","0-");
        participante1.put("numeroParticipante",String.valueOf(numInscripcion+1));
        circuitoChico.add(participante1);

        participante2.put("dni", "35230789");
        participante2.put("nombre","Selena");
        participante2.put("apellido","Perez");
        participante2.put("edad","23");
        participante2.put("celular","124443535");
        participante2.put("numeroEmergencia","121232323");
        participante2.put("grupoSanguineo","0+");
        participante2.put("numeroParticipante",String.valueOf(numInscripcion+1));
        circuitoMedio.add(participante2);

        participante3.put("dni", "430000231");
        participante3.put("nombre","Pablo");
        participante3.put("apellido","Silva");
        participante3.put("edad","20");
        participante3.put("celular","13445534343");
        participante3.put("numeroEmergencia","1223443424");
        participante3.put("grupoSanguineo","A+");
        participante3.put("numeroParticipante",String.valueOf(numInscripcion+1));
        circuitoAvanzado.add(participante3);




        System.out.println("***** CARRERA DE LA SELVA *****");
        System.out.println("///////////////////");
        System.out.println("A continuacion seleccione alguna de las siguientes opciónes: ");
        System.out.println("1: Inscribir a un nuevo participante en una categoria.");
        System.out.println("2: Ver todos los inscriptos a una determinada categoría.");
        System.out.println("3: Desinscribir a un participante de una categoría.");
        System.out.println("4: Salir.");
        System.out.println("///////////////////");
        int opciones = data.nextInt();

        switch (opciones) {

            case 1:
                System.out.println("Ingrese DNI del participante: ");
                String dni = data.next();
                datosParticipante.put("dni", dni);
                System.out.println("Ingrese el nombre del participante: ");
                String nombre = data.next();
                datosParticipante.put("nombre", nombre);
                System.out.println("Ingrese el apellido del participante: ");
                String apellido = data.next();
                datosParticipante.put("apellido", apellido);
                System.out.println("Ingrese la edad del participante: ");
                String edad = data.next();
                datosParticipante.put("edad", edad);
                System.out.println("Ingrese el celular del participante: ");
                String celular = data.next();
                datosParticipante.put("celular", celular);
                System.out.println("Ingrese el numero de emergencia del participante: ");
                String numeroEmergencia = data.next();
                datosParticipante.put("numero de emergencia", numeroEmergencia);
                System.out.println("Ingrese el grupo sanguineo del participante: ");
                String grupoSanguineo = data.next();
                datosParticipante.put("grupo sanguineo", grupoSanguineo);
                System.out.println("Ingrese la categoria del participante: ");
                System.out.println("1: Circuito Chico");
                System.out.println("2: Circuito Medio");
                System.out.println("3: Circuito Avanzado");
                int categoria = data.nextInt();
                datosParticipante.put("categoria", String.valueOf(categoria));
                numInscripcion += 1;
                datosParticipante.put("numero de inscripcion: ", String.valueOf(numInscripcion));

                switch (categoria) {
                    case 1:

                        if (Integer.parseInt(edad) <= 18) {
                            circuitoChico.add(datosParticipante);
                            System.out.println("Inscripcion exitosa! usted debera abonar $1300");
                        } else {
                            circuitoChico.add(datosParticipante);
                            System.out.println("Inscripcion exitosa! usted debera abonar $1500");
                        }

                        break;
                    case 2:
                        if (Integer.parseInt(edad) <= 18) {
                            circuitoMedio.add(datosParticipante);
                            System.out.println("Inscripcion exitosa! usted debera abonar $2000");
                        } else {
                            circuitoMedio.add(datosParticipante);
                            System.out.println("Inscripcion exitosa! usted debera abonar $2300");
                        }

                        break;
                    case 3:
                        if (Integer.parseInt(edad) >= 18) {
                            circuitoAvanzado.add(datosParticipante);
                            System.out.println("Inscripcion exitosa! usted debera abonar $2800");
                        } else {
                            System.out.println("No se pueden inscribir participantes menores de 18 años");
                            break;
                        }
                        break;
                    default:
                        System.out.println("opcion no valida");
                        break;
                }
                break;

            case 2:
                System.out.println("///////////////////");
                System.out.println("A continuacion seleccione los participantes de la categoria que desea ver: ");
                System.out.println("1: Circuito chico.");
                System.out.println("2: Circuito medio.");
                System.out.println("3: Circuito avanzado.");
                System.out.println("4: Salir.");
                System.out.println("///////////////////");
                int circuito = data.nextInt();

                switch (circuito) {
                    case 1:
                        System.out.println(circuitoChico);
                        break;
                    case 2:
                        System.out.println(circuitoMedio);
                        break;
                    case 3:
                        System.out.println(circuitoAvanzado);
                        break;
                    default:
                        System.out.println("Programa finalizado");
                        break;
                }
                break;

            case 3:
                System.out.println("*********************************************");
                System.out.println("Ingrese el dni del participante a eliminar: ");
                System.out.println("*********************************************");
                String saltoDeLinea = data.nextLine();
                String eliminar = data.nextLine();


                for(Map participant : circuitoChico){
                    if(participant.remove("dni",eliminar)) {
                        circuitoChico.remove(participant);
                        System.out.println("Participante con dni:  " + eliminar + " del circuito chico eliminado");
                        break;
                    }
                    System.out.println("Participante no encontrado en el circuito chico");
            }

                for(Map participant : circuitoMedio){
                    if(participant.remove("dni",eliminar)){
                        circuitoMedio.remove(participant);
                        System.out.println("Participante con dni: " +eliminar +  " del circuito medio eliminado");
                        break;
                    }
                    System.out.println("Participante no encontrado en el circuito medio");
                }

                for(Map participant : circuitoAvanzado){
                if(participant.remove("dni",eliminar)){
                    circuitoAvanzado.remove(participant);
                    System.out.println("Participante con dni: " + eliminar +  " del circuito avanzado eliminado");
                    break;
                }
                    System.out.println("Participante no encontrado en el circuito avanzado");
            }

                break;
            default:
                System.out.println("Programa finzalizado");
                break;
        }


    }


}
