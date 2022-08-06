package Estructuras;

import java.util.*;

public class Carrera_Selva {


    public static void main(String[] args) {

        int opcion = 0;
        int contador = 0;
        Scanner entrada = new Scanner(System.in);

        Map<Integer, Map<String, String>> Mapinscripcion = new HashMap<>();
        do {
            System.out.println("Ingrese una opción");
            System.out.println("1. Inscribir nuevo participante");
            System.out.println("2. Mostrar todos los inscritos");
            System.out.println("3. Desinscribir a un participante de una categoría");
            opcion = entrada.nextInt();
            switch (opcion) {

                case 1:
                    entrada = new Scanner(System.in);
                    String cat;
                    String dni;
                    String nombre;
                    String apellido;
                    String edad;
                    String celular;
                    String emergency;
                    String RH;
                    Double monto = 0.0;

                    System.out.println("Escoja una categoria para inscribirse");
                    System.out.println("1. Inscripción categoria circuito chico: Menores de 18 años $1300. Mayores de 18 años $1500.");
                    System.out.println("2. Inscripción categoria circuito medio: Menores de 18 años $2000. Mayores de 18 años $2300.");
                    System.out.println("3. Inscripción categoria circuito Avanzado: No se permite inscripciones a menores de 18 años. Mayores de 18 años $2800");
                    cat = entrada.next();

                    Map<String, String> datosMap = new HashMap<String, String>();
                    System.out.println("Ingrese su dni");
                    dni = entrada.next();
                    datosMap.put("dni", dni);

                    System.out.println("Ingrese su nombre");
                    nombre = entrada.next();
                    datosMap.put("nombre", nombre);

                    System.out.println("Ingrese su apellido");
                    apellido = entrada.next();
                    datosMap.put("apellido", apellido);

                    System.out.println("Ingrese su edad");
                    edad = entrada.next();
                    datosMap.put("edad", edad);

                    System.out.println("Ingrese su celular");
                    celular = entrada.next();
                    datosMap.put("celular", celular);

                    System.out.println("Ingrese su numero de emergencia");
                    emergency = entrada.next();
                    datosMap.put("emergency", emergency);

                    System.out.println("Ingrese su grupo sanguineo");
                    RH = entrada.next();
                    datosMap.put("RH", RH);

                    datosMap.put("categoria", cat);
                    contador++;
                    int edad1 = Integer.parseInt(edad);
                    if (cat == "1") {
                        if (edad1 < 18) {
                            monto = 1.300d;
                        } else {
                            monto = 1.500d;
                        }
                    } else if (cat == "2") {
                        if (edad1 < 18) {
                            monto = 2000d;
                        } else {
                            monto = 2300d;
                        }
                    } else {
                        if (edad1 > 18) {
                            monto = 2800d;
                        }else if(edad1 < 18) {
                            System.out.println("No se permite inscripciones a menores de 18 años. ");
                            break;
                        }
                        }

                    String montostring = Double.toString(monto);
                    datosMap.put("monto", montostring);
                    Mapinscripcion.put(contador, datosMap);
                    System.out.println("Se ha inscrito exitosamente");
                    break;

                case 2:
                    System.out.println("Listado de inscritos");
                    for(Map.Entry<Integer, Map<String, String>> entry : Mapinscripcion.entrySet()){
                        Integer clave = entry.getKey();
                        System.out.println("Numero de inscripción: " + clave);
                        System.out.println("dni:" + entry.getValue().get("dni"));
                        System.out.println("nombre:" + entry.getValue().get("nombre"));
                        System.out.println("apellido:" + entry.getValue().get("apellido"));
                        System.out.println("edad:" + entry.getValue().get("edad"));
                        System.out.println("celular:" + entry.getValue().get("celular"));
                        System.out.println("emergency:" + entry.getValue().get("emergency"));
                        System.out.println("RH:" + entry.getValue().get("RH"));
                        System.out.println("categoria:" + entry.getValue().get("categoria"));
                        System.out.println("monto:" + entry.getValue().get("monto"));
                    }
                    break;

                case 3:

                    int inscripcion;
                    System.out.println("Ingrese su numero de inscripcion para eliminar");
                    inscripcion = entrada.nextInt();
                    Mapinscripcion.keySet().removeIf(entry -> entry.equals(inscripcion));
                    System.out.println("La inscripcion" + inscripcion + "ha sido eliminada");
                    break;

                default:

                    System.out.println("Ingrese un numero valido");
            }

        } while (opcion != 5);

        entrada.close();


    }

}


