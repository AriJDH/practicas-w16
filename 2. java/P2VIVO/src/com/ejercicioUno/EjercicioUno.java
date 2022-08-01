package com.ejercicioUno;

import java.util.*;

public class EjercicioUno {
    public int inscripciones = -1;
    public HashMap<Integer, List> mapParticipantes = new HashMap<Integer, List>();
    public HashMap<Integer, String> mapCircuitu = new HashMap<Integer, String>();
    public List<String> nuevoPartcipante = new ArrayList<String>();


    public int calcularCostoInscripcion(int edad, String nombreCircuito){
        int costos = 0;
        switch (nombreCircuito){
            case "Circuito Chico":
                costos = edad<18?1300:1500;
                break;
            case "Circuito Medio":
                costos = edad<18?2000:2300;
                break;
            case "Circuito Avanzado":
                costos = 2800;
                break;

        }
        return costos;
    }

    public String elegirCircuito(int edad){

        Scanner entradaCircuito = new Scanner(System.in);

        String nombreCircuito = "";
        boolean bandera = false;


        do{
            System.out.print("" +
                    "****************************\n" +
                    "***Selecciona el circuito***\n" +
                    "****************************\n");
            if (edad >= 18){
                System.out.print("" +
                        "1. Circuito Chico: 2Km Selva y arroyos\n" +
                        "2. Circuito Medio: 5Km Selva, arroyos y barro\n" +
                        "3. Circuito Avanzdo 10km por selva, arroyos, barro y escalada por piedra\n");

            }else {
                System.out.print("" +
                        "1. Circuito Chico: 2Km Selva y arroyos\n" +
                        "2. Circuito Medio: 5Km Selva, arroyos y barro\n");
            }
            int circuitoElegido = entradaCircuito.nextInt();

            switch (circuitoElegido) {
                case 1:
                    nombreCircuito = "Circuito Chico";
                    bandera = false;
                    break;
                case 2:
                    nombreCircuito = "Circuito Medio";
                    bandera = false;
                    break;
                case 3:
                    nombreCircuito = "Circuito Avanzado";
                    bandera = false;
                    break;
                default:
                    System.out.println("Error. Ingrese un circuito valido, vuelvalo a intentar.");
                    bandera = true;
                    break;
            }

        }while(bandera);


        return nombreCircuito;
    }

    public void inscribirParticipante(){

        Scanner scInscripcion = new Scanner(System.in);

        inscripciones++;
        int numeroId = inscripciones;
        String nombre, apellido, grupoSanguineo, celularEmergencia, celular;
        int edad, dni;


        nuevoPartcipante.add(0, String.valueOf(numeroId));
        System.out.print("" +
                "****************************************\n" +
                "***Ingresa los datos del participante***\n\n" +
                "DNI: ");
        dni = scInscripcion.nextInt();
        nuevoPartcipante.add(1, String.valueOf(dni));

        if(mapParticipantes.containsKey(dni)) { //Ya esta registrado
            System.out.println("Ya esta registrado el DNI: " + dni + " ");
            if (mapCircuitu.containsKey(dni)) {
                System.out.println("y esta inscrito a " + mapCircuitu.get(dni));
            } else {
                System.out.println();
                edad = Integer.parseInt(mapParticipantes.get(dni).get(4).toString());
                String circuito = elegirCircuito(edad);

                int costoInscripcion = calcularCostoInscripcion(edad, circuito);


                System.out.print("" +
                        "\nEl costo de inscripcion es de: $" + costoInscripcion);
            }
        } else {
            System.out.print("Nombre: ");
            nombre = scInscripcion.next();
            nuevoPartcipante.add(2, nombre);

            System.out.print("Apellido: ");
            apellido = scInscripcion.next();
            nuevoPartcipante.add(3, apellido);

            System.out.print("Edad: ");
            edad = scInscripcion.nextInt();
            nuevoPartcipante.add(4, String.valueOf(edad));

            System.out.print("Celular: ");
            celular = scInscripcion.next();
            nuevoPartcipante.add(5, celular);

            System.out.print("Celular de emergencia: ");
            celularEmergencia = scInscripcion.next();
            nuevoPartcipante.add(6, celularEmergencia);

            System.out.print("Grupo sanguíneo: ");
            grupoSanguineo = scInscripcion.next();
            nuevoPartcipante.add(7, grupoSanguineo);


            mapParticipantes.put(dni, nuevoPartcipante);
            String circuito = elegirCircuito(edad);
            mapCircuitu.put(dni, circuito);

            int costosInscripcion = calcularCostoInscripcion(edad, circuito);

            System.out.print("" +
                    "El costo de inscripcion es de: $" + costosInscripcion + "\n" );
        }

    }

    public void mostrarIncripcionPorCircuito(){
        String circuito = "";
        Scanner listEntrada = new Scanner(System.in);

        System.out.print("" +
                "\n--- Incriptos a un circuito ---\n" +
                "1. Circuito Chico: 2Km Selva y arroyos\n" +
                "2. Circuito Medio: 5Km Selva, arroyos y barro\n" +
                "3. Circuito Avanzdo 10km por selva, arroyos, barro y escalada por piedra\n");
        System.out.print("Circuito: ");

        int circuitoElgido = listEntrada.nextInt();

        boolean bandera = false;

        do{
            switch (circuitoElgido){
                case 1:
                    circuito = "Circuito Chico";
                    break;
                case 2:
                    circuito = "Circuito Medio";
                    break;
                case 3:
                    circuito = "Circuito Avanzando";
                    break;
                default:
                    System.out.println("Error: Ingrese un apcion valida. Vuelva lo a intentar.");
                    bandera = true;
                    break;
            }
        }while (bandera);

        if (mapCircuitu.containsValue(circuito)){
            System.out.println("---Participantes del " + circuito + " ---");
                for (Map.Entry inscrito: mapCircuitu.entrySet()){
                    if (inscrito.getValue() == circuito){
                        System.out.println(mapParticipantes.get(inscrito.getKey()));
                    }
                }
        }else{
            System.out.println("El " + circuito + " no tiene participantes incriptos.");
        }

    }


    public void menu(){
        Scanner scMenu = new Scanner(System.in);
        boolean bandera = true;
        do{
            System.out.print("" +
                    "---Carrera de la selva---\n" +
                    "--------------menu---------\n" +
                    "1) Inscribir participante\n" +
                    "2) Lista de inscritos a un circuito\n" +
                    "3) salir\n");
            int opcMenu = scMenu.nextInt();

            switch (opcMenu){
                case 1:
                    inscribirParticipante();
                    break;
                case 2:
                    mostrarIncripcionPorCircuito();
                    break;
                case 3:
                    System.out.println("Finalizando Sistema");
                    break;
                default:
                    System.out.println("Error: Elega una opcion correcta");
                    bandera = true;
                    break;
            }
        }while(bandera);
    }

    public static void main(String[] args){
        EjercicioUno x = new EjercicioUno();
        x.menu();
    }
}
