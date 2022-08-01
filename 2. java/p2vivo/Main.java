package ejerciciosintegradores;

import java.util.*;


public class Main {

    public static void main(String[] args) {

        HashMap<String,String> persona = new HashMap<>();
        List<HashMap> circuitoChico = new LinkedList<>();
        List<HashMap> circuitoMedio = new LinkedList<>();
        List<HashMap> circuitoAvanzado = new LinkedList<>();
        Map<Integer, String> participantes = new HashMap<>();
        int numeroInscripcion = 1;
        Scanner eleccion = new Scanner(System.in);
        boolean esInscrito = false;
        boolean encendido = true;



        do {
            System.out.println("------------------------------------------------------");
            System.out.println("////SOFTWARE CARRERA DE LA SELVA////");
            System.out.println("------------------------------------------------------");
            System.out.println("Elija a que circuito desea inscribirse:\n 1.-Circuito Chico \n 2.-Circuito Medio \n 3.-Circuito Avanzado \n 4.-Ver Participantes \n 5.-Desinscribir \n 6.-Cerrar");


            switch (eleccion.nextInt()){
                case 1:
                    esInscrito = inscribir(participantes, persona, numeroInscripcion, circuitoChico, "Circuito Chico");
                    if(esInscrito) System.out.println("Inscrito Correctamente");
                    break;

                case 2:
                    esInscrito = inscribir(participantes, persona, numeroInscripcion, circuitoMedio, "Circuito Medio");
                    if(esInscrito) System.out.println("Inscrito Correctamente");
                    break;

                case 3:
                    esInscrito = inscribir(participantes, persona, numeroInscripcion, circuitoAvanzado, "Circuito Avanzado");
                    if(esInscrito) System.out.println("Inscrito Correctamente");
                    break;
                case 4:
                    mostrarInscritos(circuitoChico, circuitoMedio, circuitoAvanzado);
                    break;

                case 5:
                    Scanner dni = new Scanner(System.in);
                    System.out.println("Ingrese el dni");
                    int dni_participante = dni.nextInt();

                    for (Map.Entry participante : participantes.entrySet()){
                        Integer clave = (Integer) participante.getKey();

                        if(clave == dni_participante){
                            System.out.println("Eliminado");
                        }
                    }
                    break;
                case 6:
                    System.out.println("Hasta pronto!");
                    encendido = false;
                    break;

                default:
                    System.out.println("Debe elegir una opción valida");
                    break;
            }
        }while (encendido);


    }



    public static void mostrarInscritos(List circuitoChico, List circuitoMedio, List circuitoAvanzado) {
        System.out.println("Elija una categoria para ver los participantes inscritos: \n 1.-Circuito Chico \n 2.-Circuito Medio \n 3.-Circuito Avanzado");
        Scanner categoria = new Scanner(System.in);
        int eleccion = categoria.nextInt();
        if(eleccion == 1){
            System.out.println(circuitoChico);
        }else if(eleccion == 2){
            System.out.println(circuitoMedio);
        }else if (eleccion == 3){
            System.out.println(circuitoAvanzado);
        }else{
            System.out.println("Debe elegir una categoria valida");
        }

    }


    public static double validarEdadMonto(int edad, String circuito) {
        double monto = 0;

        if(edad < 18 && circuito.equals("Circuito Chico")){
            monto = 1300;
        }else if (edad >= 18 && circuito.equals("Circuito Chico")){
            monto = 1500;
        }else if(edad < 18 && circuito.equals("Circuito Medio")){
            monto = 2000;
        }else if (edad >= 18 && circuito.equals("Circuito Medio")){
            monto = 2300;
        }else if (edad >= 18 && circuito.equals("Circuito Avanzado")){
            monto = 2800;
        }else{
            return 0;
        }
        
        return monto;
    }


    public static boolean inscribir(Map participantes, Map persona, int numeroInscripcion, List circuito, String nombreCircuito) {
        Scanner dni = new Scanner(System.in);
        Scanner nombre = new Scanner(System.in);
        Scanner apellido = new Scanner(System.in);
        Scanner edad = new Scanner(System.in);
        Scanner celular = new Scanner(System.in);
        Scanner numeroEmergencia = new Scanner(System.in);
        Scanner grupoSanguineo = new Scanner(System.in);

        System.out.println("Ingrese su dni sin  puntos y sin digito verificador:");
        System.out.println("------------------------------------------------------");
        String dniParticipante = dni.nextLine();
        if(participantes.get(dniParticipante) != null) {
            System.out.println("El participante se encuentra actualmente inscrito");
            return false;
        }
        System.out.println("Ingrese su edad");
        System.out.println("------------------------------------------------------");
        int edadParticipante = edad.nextInt();
        double monto = validarEdadMonto(edadParticipante, nombreCircuito);
        if(monto == 0) {
            System.out.println("No se permiten inscripciones a menores de 18 años");
            return false;
        }

        participantes.put(Integer.parseInt(dniParticipante), nombreCircuito);

        persona.put("dni", dniParticipante);
        persona.put("edad", String.valueOf(edadParticipante));
        persona.put("monto", String.valueOf(monto));


        System.out.println("Ingrese su nombre:");
        System.out.println("------------------------------------------------------");
        persona.put("nombre", nombre.nextLine());

        System.out.println("Ingrese su apellido: ");
        System.out.println("------------------------------------------------------");
        persona.put("apellido", apellido.nextLine());

        System.out.println("Ingrese su celular:");
        System.out.println("------------------------------------------------------");
        persona.put("celular", celular.nextLine());

        System.out.println("Ingrese un número de emergencia:");
        System.out.println("------------------------------------------------------");
        persona.put("numero de emergencia", numeroEmergencia.nextLine());

        System.out.println("Ingrese su grupo sanguineo");
        System.out.println("------------------------------------------------------");
        persona.put("grupo sanguineo", grupoSanguineo.nextLine());

        persona.put("numero de participante", String.valueOf(numeroInscripcion++));

        circuito.add(persona.entrySet());

        return true;
    }


}
