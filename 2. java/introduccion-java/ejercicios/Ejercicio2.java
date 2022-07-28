package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ejercicio2 {

    public static void main(String[] args){

        Set<Map> circuitoChico = new HashSet<>();
        Set<Map> circuitoMedio = new HashSet<>();
        Set<Map> circuitoAvanzado = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int opcion = 1;

        do {

            String opciondentro;
            System.out.println("----------------------------------------------------");
            System.out.println();
            System.out.println("1. Inscribir participante");
            System.out.println("2. Mostrar participantes circuito chico");
            System.out.println("3. Mostrar participantes circuito medio");
            System.out.println("4. Mostrar participantes circuito avanzado");
            System.out.println("5. Desinscribir participante");
            System.out.println("0. SALIR");
            System.out.println();
            System.out.println("----------------------------------------------------");

            System.out.println("Ingrese una opcion: ");
            opciondentro = sc.next();
            opcion = Integer.parseInt(opciondentro);

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el DNI: ");
                    String dni = sc.next();
                    System.out.println("Ingrese el nombre: ");
                    String nombre = sc.next();
                    System.out.println("Ingrese el apellido: ");
                    String apellido = sc.next();
                    System.out.println("Ingrese la edad: ");
                    String edad = sc.next();
                    System.out.println("Ingrese el celular: ");
                    String celular = sc.next();
                    System.out.println("Ingrese el numero de emergencia: ");
                    String numeroEmergencia = sc.next();
                    System.out.println("Ingrese el grupo sanguineo: ");
                    String grupoSanguineo = sc.next();
                    System.out.println("Ingrese la categoria: ");
                    String categoria = sc.next();

                    switch (categoria){
                        case "chico":
                            Map<String, String> participante = new HashMap<>();
                            participante.put("dni", dni);
                            participante.put("nombre", nombre);
                            participante.put("apellido", apellido);
                            participante.put("edad", edad);
                            participante.put("celular", celular);
                            participante.put("numeroEmergencia", numeroEmergencia);
                            participante.put("grupoSanguineo", grupoSanguineo);
                            participante.put("categoria", categoria);
                            circuitoChico.add(participante);

                            if(Integer.parseInt(edad)> 18){
                                System.out.println("El monto a abonar es de $1500");
                            }else {
                                System.out.println("El monto a abonar es de $1300");
                            }
                            break;

                        case "medio":
                            Map<String, String> participante1 = new HashMap<>();
                            participante1.put("dni", dni);
                            participante1.put("nombre", nombre);
                            participante1.put("apellido", apellido);
                            participante1.put("edad", edad);
                            participante1.put("celular", celular);
                            participante1.put("numeroEmergencia", numeroEmergencia);
                            participante1.put("grupoSanguineo", grupoSanguineo);
                            participante1.put("categoria", categoria);
                            circuitoMedio.add(participante1);

                            if(Integer.parseInt(edad)> 18){
                                System.out.println("El monto a abonar es de $2300");
                            }else {
                                System.out.println("El monto a abonar es de $2000");
                            }
                            break;

                        case "avanzado":
                            if(Integer.parseInt(edad)> 18){
                                Map<String, String> participante2 = new HashMap<>();
                                participante2.put("dni", dni);
                                participante2.put("nombre", nombre);
                                participante2.put("apellido", apellido);
                                participante2.put("edad", edad);
                                participante2.put("celular", celular);
                                participante2.put("numeroEmergencia", numeroEmergencia);
                                participante2.put("grupoSanguineo", grupoSanguineo);
                                participante2.put("categoria", categoria);
                                circuitoAvanzado.add(participante2);
                                System.out.println("El monto a abonar es de $2800");
                            }else {
                                System.out.println("No se permite inscripciones a menores de 18 años");
                            }
                            break;
                    }//switch categoria
                    break;
                case 2:
                    System.out.println();
                    for (int i = 0; i < circuitoChico.size(); i++) {
                        System.out.println("Participante con id: "+ i +" -- "+circuitoChico.toArray()[i]);
                    }
                    break;
                case 3:
                    System.out.println();
                    for (int i = 0; i < circuitoMedio.size(); i++) {
                        System.out.println("Participante con id: "+ i +" -- "+circuitoMedio.toArray()[i]);
                    }
                    break;
                case 4:
                    System.out.println();
                    for (int i = 0; i < circuitoAvanzado.size(); i++) {
                        System.out.println("Participante con id: "+ i +" -- "+circuitoAvanzado.toArray()[i]);
                    }
                    break;
                case 5:
                    System.out.println("Ingrese la categoria (chico, medio, avanzado): ");
                    String categoriaDesinscripcion = sc.next();
                    System.out.println("Ingrese el id: ");
                    int id = sc.nextInt();

                    switch (categoriaDesinscripcion){
                        case "chico":
                            circuitoChico.remove(id -1);
                            System.out.println("Se ha desinscripto correctamente");
                            break;
                        case "medio":
                            circuitoMedio.remove(id-1);
                            System.out.println("Se ha desinscripto correctamente");
                            break;
                        case "avanzado":
                            circuitoAvanzado.remove(id-1);
                            System.out.println("Se ha desinscripto correctamente");
                            break;
                    }
                    break;

            }//switch menu


        } while (opcion != 0);

        System.out.println("FINALIZADO");

    }
}