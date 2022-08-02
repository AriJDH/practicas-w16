package com.tomas.carrera;

import java.util.*;

/**
 * Desarrollador: Tomas Octavio Rodriguez Herrera
 * Fecha: 26 de julio 2022
 * Descripción: Clase que realiza el ejercicio de la carrera de la selva
 * para almacenar los participantes de acuerdo a los circuitos chico, medio o avanzado
 * utilizando maps y arrayList
 */

public class Main {


    public static void main(String[] args) {

        //Mapas que recibirán Integer como clave y ArrayList como valores
        Map<Integer, ArrayList>  categoriaChico = new HashMap<Integer, ArrayList>();
        Map<Integer, ArrayList> categoriaMedio = new HashMap<Integer, ArrayList>();
        Map<Integer, ArrayList> categoriaAvanzado = new HashMap<Integer, ArrayList>();

        ArrayList<String> datos = new ArrayList<String>();


        //Inicialización de variables
        byte continuar = 0;
        String dni = "";
        String nombre = "";
        String apellido = "";
        String edad = "";
        String celular = "";
        String numeroEmergencia = "";
        String grupoSanguineo = "";

        byte opcionMenu = 0;
        byte opcionCategoria = 0;
        int numeroInscripcion = 1;
        int edadNumero = 0;
        float valorPagar = 0;

        String espera;


        Scanner entrada = new Scanner(System.in);

        do {

            boolean existeParticipante = false;
            String categoria = "";

            //Menú principal del programa

            System.out.println("\n------------------------------------------------");
            System.out.println("\tBienvenido a la carrera de la selva");
            System.out.println("------------------------------------------------\n");
            System.out.println("1. Inscribir a un nuevo participante");
            System.out.println("2. Mostrar inscritos de determinada categoría");
            System.out.println("3. Desinscribir particiante");
            System.out.println("4. Salir\n");
            System.out.println("------------------------------------------------");
            System.out.println("Por favor, seleccione una opción: ");

            opcionMenu = Byte.parseByte(entrada.nextLine());

            switch (opcionMenu) {

                case 1:

                    ArrayList<String> participante = new ArrayList<String>();

                    System.out.println("Ingrese el dni del participante: ");
                    dni = entrada.nextLine();

                    //Recorre el map para saber si el dni está registrado en el circuito chico
                    for(Map.Entry contenido : categoriaChico.entrySet()) {

                        datos = categoriaChico.get(contenido.getKey());

                        if(datos.get(0).equals(dni)) {

                            existeParticipante = true;
                            categoria = "Circuito chico";

                            break;

                        }

                    }

                    if(!existeParticipante) {
                        //Recorre el map para saber si el dni está registrado en el circuito medio
                        for (Map.Entry contenido : categoriaMedio.entrySet()) {

                            datos = categoriaMedio.get(contenido.getKey());

                            if (datos.get(0).equals(dni)) {

                                existeParticipante = true;
                                categoria = "Circuito medio";

                                break;

                            }

                        }
                    }

                    if(!existeParticipante) {
                        //Recorre el map para saber si el dni está registrado en el circuito avanzado
                        for (Map.Entry contenido : categoriaAvanzado.entrySet()) {

                            datos = categoriaAvanzado.get(contenido.getKey());

                            if (datos.get(0).equals(dni)) {

                                existeParticipante = true;
                                categoria = "Circuito avanzado";

                                break;

                            }

                        }
                    }

                    if(existeParticipante) {

                        System.out.println("¡Atencion!");
                        System.out.println("El participante con dni " + dni + " ya se encuentra registrado en la categoría " + categoria);

                        System.out.println("\nPresione enter o cualquier tecla para volver al menú principal: ");
                        espera = entrada.nextLine();

                    } else {

                        //Pide los demás datos del participante una vez validó que el dni no está registrado en ninguna categoría

                        System.out.println("Ingrese el nombre: ");
                        nombre = entrada.nextLine();

                        System.out.println("Ingrese el apellido: ");
                        apellido = entrada.nextLine();

                        System.out.println("Ingrese la edad: ");
                        edad = entrada.nextLine();

                        System.out.println("Ingrese el celular: ");
                        celular = entrada.nextLine();

                        System.out.println("Ingrese el número de emergencia: ");
                        numeroEmergencia = entrada.nextLine();

                        System.out.println("Ingrese el grupo sanguineo: ");
                        grupoSanguineo = entrada.nextLine();

                        participante.add(dni);
                        participante.add(nombre);
                        participante.add(apellido);
                        participante.add(edad);
                        participante.add(celular);
                        participante.add(numeroEmergencia);
                        participante.add(grupoSanguineo);

                        edadNumero = Integer.parseInt(edad);

                        //Menú para seleccionar la categoría
                        do {

                            System.out.println("------------------------------------------------");
                            System.out.println("\tMenú de Categrías");
                            System.out.println("------------------------------------------------\n");
                            System.out.println("1. Circuito chico");
                            System.out.println("2. Circuito medio");
                            System.out.println("3. Circuito avanzado");
                            System.out.println("4. Volver al menú principal\n");
                            System.out.println("------------------------------------------------");
                            System.out.println("Por favor, seleccione la categoría a inscribir al participante: ");

                            opcionCategoria = Byte.parseByte(entrada.nextLine());
                            switch (opcionCategoria) {

                                case 1:

                                    if (edadNumero < 18) {

                                        valorPagar = 1300;

                                    } else {

                                        valorPagar = 1500;

                                    }

                                    System.out.println("Categoria: Circuito chico");
                                    System.out.println("Edad participante: " + edadNumero);
                                    System.out.println("Monto a abonar: " + valorPagar);

                                    //Se obtienen las claves del maps en forma de set, se recorre para encontrar el último valor
                                    Set<Integer> clavesCategoriaChico = categoriaChico.keySet();
                                    for ( Integer clave : clavesCategoriaChico ) {
                                        numeroInscripcion = clave + 1;
                                    }

                                    //Almacena número de inscripción y participantes en el circuito chico
                                    categoriaChico.put(numeroInscripcion, participante);

                                    System.out.println("\nPresione enter o cualquier tecla para volver al menú principal: ");
                                    espera = entrada.nextLine();

                                    break;

                                case 2:

                                    if (edadNumero < 18) {

                                        valorPagar = 2000;

                                    } else {

                                        valorPagar = 2300;

                                    }

                                    System.out.println("Categoria: Circuito medio");
                                    System.out.println("Edad participante: " + edadNumero);
                                    System.out.println("Total a pagar: " + valorPagar);

                                    //Se obtienen las claves del maps en forma de set, se recorre para encontrar el último valor
                                    Set<Integer> clavesCategoriaMedio = categoriaMedio.keySet();
                                    for ( Integer clave : clavesCategoriaMedio ) {
                                        numeroInscripcion = clave + 1;
                                    }

                                    //Almacena número de inscripción y participantes en el circuito medio
                                    categoriaMedio.put(numeroInscripcion, participante);

                                    System.out.println("\nPresione enter o cualquier tecla para volver al menú principal: ");
                                    espera = entrada.nextLine();

                                    break;

                                case 3:

                                    if (edadNumero >= 18) {

                                        valorPagar = 2800;

                                        System.out.println("Categoria: Circuito avanzado");
                                        System.out.println("Edad participante: " + edadNumero);
                                        System.out.println("Total a pagar: " + valorPagar);

                                        //Se obtienen las claves del maps en forma de set, se recorre para encontrar el último valor
                                        Set<Integer> clavesCategoriaAvanzado = categoriaAvanzado.keySet();
                                        for ( Integer clave : clavesCategoriaAvanzado ) {
                                            numeroInscripcion = clave + 1;
                                        }

                                        //Almacena número de inscripción y participantes en el circuito avanzado
                                        categoriaAvanzado.put(numeroInscripcion, participante);

                                        System.out.println("\nPresione enter o cualquier tecla para volver al menú principal: ");
                                        espera = entrada.nextLine();


                                    } else {

                                        System.out.println("-----------¡Atención!------------");
                                        System.out.println("No se permiten inscripciones menores de 18 años");

                                        System.out.println("\nPresione enter o cualquier tecla para volver al menú principal: ");
                                        espera = entrada.nextLine();

                                    }


                                    break;

                                case 4:

                                    opcionCategoria = -1;

                                    break;

                                default:
                                    System.out.println("-----------¡Atención!------------");
                                    System.out.println("La opción ingresada no existe, intentelo nuevamente");

                                    opcionCategoria = 0;


                            }

                        }while(opcionCategoria == 0);

                    }

                    break;

                case 2:

                    do {

                        //Menú de categorías
                        System.out.println("------------------------------------------------");
                        System.out.println("\tMenú de Categrías");
                        System.out.println("------------------------------------------------\n");
                        System.out.println("1. Circuito chico");
                        System.out.println("2. Circuito medio");
                        System.out.println("3. Circuito avanzado");
                        System.out.println("4. Volver al menú principal\n");
                        System.out.println("------------------------------------------------");
                        System.out.println("Por favor, seleccione la categoría a listar de participantes: ");

                        opcionCategoria = Byte.parseByte(entrada.nextLine());
                        switch (opcionCategoria) {

                            case 1:

                                //Lista los participantes del circuito chico

                                System.out.println("-----------------------------------------");
                                System.out.println("Participantes categoría circuito chico");
                                System.out.println("-----------------------------------------");

                                System.out.print("Inscripción");
                                System.out.print("\t DNI");
                                System.out.print("\t Nombre");
                                System.out.print("\t Apellido");
                                System.out.print("\t Edad");
                                System.out.print("\t Celular");
                                System.out.print("\t Número de emergencia");
                                System.out.print("\t Grupo Sanguineo");

                                //Recorre el map encontrando el key (número de inscripción)
                                for (Map.Entry contenido : categoriaChico.entrySet()) {

                                    System.out.print( "\n\t" + contenido.getKey() + "\t");

                                    datos = categoriaChico.get(contenido.getKey());

                                    //Recorre el ArrayList encontrado dentro del key map especificado
                                    for(String elemento : datos) {
                                        System.out.print(elemento + "\t");
                                    }


                                }

                                System.out.println("\n\nPresione enter o cualquier tecla para volver al menú principal: ");
                                espera = entrada.nextLine();

                                break;

                            case 2:

                                //Lista los participantes del circuito medio

                                System.out.println("-----------------------------------------");
                                System.out.println("Participantes categoría circuito medio");
                                System.out.println("-----------------------------------------");

                                System.out.print("Inscripción");
                                System.out.print("\t DNI");
                                System.out.print("\t Nombre");
                                System.out.print("\t Apellido");
                                System.out.print("\t Edad");
                                System.out.print("\t Celular");
                                System.out.print("\t Número de emergencia");
                                System.out.print("\t Grupo Sanguineo");

                                //Recorre el map encontrando el key (número de inscripción)
                                for (Map.Entry contenido : categoriaMedio.entrySet()) {

                                    System.out.print( "\n\t" + contenido.getKey() + "\t");

                                    datos = categoriaMedio.get(contenido.getKey());

                                    //Recorre el ArrayList encontrado dentro del key map especificado
                                    for(String elemento : datos) {
                                        System.out.print(elemento + "\t");
                                    }


                                }

                                System.out.println("\n\nPresione enter o cualquier tecla para volver al menú principal: ");
                                espera = entrada.nextLine();

                                break;

                            case 3:

                                //Lista los participantes del circuito avanzado

                                System.out.println("-----------------------------------------");
                                System.out.println("Participantes categoría circuito avanzado");
                                System.out.println("-----------------------------------------");

                                System.out.print("Inscripción");
                                System.out.print("\t DNI");
                                System.out.print("\t Nombre");
                                System.out.print("\t Apellido");
                                System.out.print("\t Edad");
                                System.out.print("\t Celular");
                                System.out.print("\t Número de emergencia");
                                System.out.print("\t Grupo Sanguineo");

                                //Recorre el map encontrando el key (número de inscripción)
                                for (Map.Entry contenido : categoriaAvanzado.entrySet()) {

                                    System.out.print( "\n\t" + contenido.getKey() + "\t");

                                    //Recorre el ArrayList encontrado dentro del key map especificado
                                    datos = categoriaAvanzado.get(contenido.getKey());

                                    for(String elemento : datos) {
                                        System.out.print(elemento + "\t");
                                    }


                                }

                                System.out.println("\n\nPresione enter o cualquier tecla para volver al menú principal: ");
                                espera = entrada.nextLine();

                            case 4:

                                opcionCategoria = -1;

                                break;


                            default:
                                System.out.println("-----------¡Atención!------------");
                                System.out.println("La opción ingresada no existe, intentelo nuevamente");

                                opcionCategoria = 0;


                        }

                    }while(opcionCategoria == 0);



                    break;

                case 3:

                    System.out.println("Ingrese el dni del participante a eliminar: ");
                    dni = entrada.nextLine();

                    //Recorre el map y luego obtiene del ArrayList el dni para saber si coincide con el ingresado
                    for(Map.Entry contenido : categoriaChico.entrySet()) {

                        datos = categoriaChico.get(contenido.getKey());

                        if(datos.get(0).equals(dni)) {

                            existeParticipante = true;
                            categoria = "Circuito chico";

                            //Elimina los el ArrayList que contiene los datos del participante
                            categoriaChico.remove(contenido.getKey());

                            break;

                        }

                    }

                    if(!existeParticipante) {
                        //Recorre el map y luego obtiene del ArrayList el dni para saber si coincide con el ingresado
                        for (Map.Entry contenido : categoriaMedio.entrySet()) {

                            datos = categoriaMedio.get(contenido.getKey());

                            if (datos.get(0).equals(dni)) {

                                existeParticipante = true;
                                categoria = "Circuito medio";

                                //Elimina los el ArrayList que contiene los datos del participante
                                categoriaMedio.remove(contenido.getKey());

                                break;

                            }

                        }
                    }

                    if(!existeParticipante) {
                        //Recorre el map y luego obtiene del ArrayList el dni para saber si coincide con el ingresado
                        for (Map.Entry contenido : categoriaAvanzado.entrySet()) {

                            datos = categoriaAvanzado.get(contenido.getKey());

                            if (datos.get(0).equals(dni)) {

                                existeParticipante = true;
                                categoria = "Circuito avanzado";

                                //Elimina los el ArrayList que contiene los datos del participante
                                categoriaAvanzado.remove(contenido.getKey());

                                break;

                            }

                        }
                    }

                    if(existeParticipante) {

                        System.out.println("\nEl participante con dni " + dni + " fue eliminado satisfactoriamente de la carrera que pertenencía al " + categoria);

                    } else {

                        System.out.println("\nEl dni ingresado no se encuentra registrado");

                    }

                    System.out.println("\n\nPresione enter o cualquier tecla para volver al menú principal: ");
                    espera = entrada.nextLine();


                    break;

                default:


            }

        }while(opcionMenu != 4);

        entrada.close();


    }
}
