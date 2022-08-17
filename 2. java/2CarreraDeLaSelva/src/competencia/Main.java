package competencia;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        System.out.println("Carrera de la Selva \n");

        String edad;
        int edadInt;
        String categoriaElegida;
        boolean continua = true;
        int consecutivoC=0, consecutivoM=0, consecutivoA=0;
        Boolean inscribeC= true, inscribeM=true, inscribeA= true;

        Scanner sc = new Scanner(System.in);

        Map<String,HashMap> circuitoChico = new HashMap<>();
        Map<String,HashMap> circuitoMedio = new HashMap<>();
        Map<String,HashMap> circuitoAvanzado = new HashMap<>();

        //Categorías
        Map<String,String>  categorias = new LinkedHashMap<>();
        categorias.put("Inscribir un participante al Circuito chico","2 km por selva y arroyos");
        categorias.put("Inscribir un participante al Circuito medio","5 km por selva, arroyos y barro");
        categorias.put("Inscribir un participante al Circuito avanzado","10 km por selva, arroyos, barro y escalada en piedra.");
        categorias.put("Listar circuito"  ,"Deberá elegir un circuito");
        categorias.put("Desinscribir un participante","");
        categorias.put("Salir","");

        do {

            System.out.println("\n\tMenú de Circuitos");
            int i=0;
            for(Map.Entry<String,String> categoria : categorias.entrySet()){
                i++;
                String circuito = categoria.getKey();
                String descrip = categoria.getValue();
                System.out.println(i +". " + circuito + ": " + descrip);
            }

            //solicito la categoría a inscribir
            System.out.println("\nSeleccione categoría a inscribir: ");
            categoriaElegida = sc.next();

            System.out.println("\nIngrese Participante: ");

            switch (categoriaElegida) {
                case "1":
                    //Controlo que no se inscriba participante ya inscrito
                    System.out.println("Favor ingrese el DNI el participante a inscribir: ");
                    String dni = sc.next();
                    for (Map.Entry<String, HashMap> existePartic : circuitoChico.entrySet()) {
                        if(existePartic.getKey().equalsIgnoreCase(dni)){
                            System.out.println("Participante ya inscrito");
                            inscribeC= false;
                            break;
                        }else{
                            inscribeC=true;
                        }
                    }
                    if (inscribeC) {
                        Map<String, String> participanteChico = new LinkedHashMap<>();
                        consecutivoC++;
                        participanteChico.put("Consecutivo", String.valueOf(consecutivoC));
                        participanteChico.put("Categoria", categoriaElegida);
                        participanteChico.put("DNI", dni);
                        System.out.println("Nombre: ");
                        String nombre =sc.next();
                        participanteChico.put("Nombre", nombre);
                        System.out.println("Apellido: ");
                        String apellido = sc.next();
                        participanteChico.put("Apellido", apellido);
                        System.out.println("Edad: ");
                        edad = sc.next();
                        participanteChico.put("Edad", edad);
                        System.out.println("Celular: ");
                        participanteChico.put("Celular", sc.next());
                        System.out.println("Nro De Emergencia: ");
                        participanteChico.put("Nro De Emergencia", sc.next());
                        System.out.println("Grupo Sanguíneo: ");
                        participanteChico.put("Grupo Sanguíneo", sc.next());
                        participanteChico.put("Monto de Inscripción", montoDeInscripcion(categoriaElegida, edad));
                        circuitoChico.put(dni, (HashMap) participanteChico);
                    }
                    break;
                case "2":
                    //Controlo que no se inscriba participante ya inscrito
                    System.out.println("Favor ingrese el DNI el participante a inscribir: ");
                    String dniM = sc.next();
                    for (Map.Entry<String, HashMap> existeMedio : circuitoMedio.entrySet()) {
                        if(existeMedio.getKey().equalsIgnoreCase(dniM)){
                            System.out.println("Participante ya inscrito");
                            inscribeM= false;
                            break;
                        }else{
                            inscribeM=true;
                        }
                    }
                    if (inscribeM) {
                            Map<String, String> participanteMedio = new LinkedHashMap<>();
                            consecutivoM++;
                            participanteMedio.put("Consecutivo", String.valueOf(consecutivoM));
                            participanteMedio.put("Categoria", categoriaElegida);
                            participanteMedio.put("DNI", dniM);
                            System.out.println("Nombre: ");
                            String nombre = sc.next();
                            participanteMedio.put("Nombre", nombre);
                            System.out.println("Apellido: ");
                            String apellido = sc.next();
                            participanteMedio.put("Apellido", apellido);
                            System.out.println("Edad: ");
                            edad = sc.next();
                            participanteMedio.put("Edad", edad);
                            System.out.println("Celular: ");
                            participanteMedio.put("Celular", sc.next());
                            System.out.println("Nro De Emergencia: ");
                            participanteMedio.put("Nro De Emergencia", sc.next());
                            System.out.println("Grupo Sanguíneo: ");
                            participanteMedio.put("Grupo Sanguíneo", sc.next());
                            participanteMedio.put("Monto de Inscripción", montoDeInscripcion(categoriaElegida, edad));
                            circuitoMedio.put(dniM, (HashMap) participanteMedio);
                    }
                    break;
                case "3":
                    //Controlo que no se inscriba participante ya inscrito
                    System.out.println("Favor ingrese el DNI el participante a inscribir: ");
                    String dniA = sc.next();
                    for (Map.Entry<String, HashMap> existeAvanzado : circuitoAvanzado.entrySet()) {
                        if(existeAvanzado.getKey().equalsIgnoreCase(dniA)){
                            System.out.println("Participante ya inscrito");
                            inscribeA= false;
                            break;
                        }else{
                            inscribeA=true;
                        }
                    }
                    if (inscribeA) {
                        System.out.println("Ingrese la Edad: ");
                        edadInt = sc.nextInt();
                        if (edadInt<18){
                            System.out.println("El participante para este circuito debe ser mayor de edad. No se puede inscribir en Avanzado!");
                        }else {
                            Map<String, String> participanteAvanzado = new LinkedHashMap<>();
                            consecutivoA++;
                            participanteAvanzado.put("Consecutivo", String.valueOf(consecutivoA));
                            participanteAvanzado.put("Categoria", categoriaElegida);
                            participanteAvanzado.put("DNI", dniA);
                            System.out.println("Nombre: ");
                            String nombre = sc.next();
                            participanteAvanzado.put("Nombre", nombre);
                            System.out.println("Apellido: ");
                            String apellido = sc.next();
                            participanteAvanzado.put("Apellido", apellido);
                            edad = String.valueOf(edadInt);
                            participanteAvanzado.put("Edad", edad);
                            System.out.println("Celular: ");
                            participanteAvanzado.put("Celular", sc.next());
                            System.out.println("Nro De Emergencia: ");
                            participanteAvanzado.put("Nro De Emergencia", sc.next());
                            System.out.println("Grupo Sanguíneo: ");
                            participanteAvanzado.put("Grupo Sanguíneo", sc.next());
                            participanteAvanzado.put("Monto de Inscripción", montoDeInscripcion(categoriaElegida, edad));
                            circuitoAvanzado.put(dniA, (HashMap) participanteAvanzado);
                        }
                    }
                    break;
                case "4": //listar
                    System.out.println("Seleccione categoría a listar entre 1, 2 o 3: ");
                    int listaCat = sc.nextInt();
                    if (listaCat==1){
                        System.out.println("\n\nParticipantes del CIRCUITO CHICO \n");
                        for(Map.Entry<String,HashMap> chico : circuitoChico.entrySet()){
                            String campo = chico.getKey();
                            HashMap valor = chico.getValue();
                            System.out.println(campo + ": " + valor );
                        }
                    }else if(listaCat==2){
                        System.out.println("\n\nParticipantes del CIRCUITO Medio \n");
                        for(Map.Entry<String,HashMap> medio : circuitoMedio.entrySet()){
                            String campo = medio.getKey();
                            HashMap valor = medio.getValue();
                            System.out.println(campo + ": " + valor );
                        }
                    }else if(listaCat==3){
                        System.out.println("\n\nParticipantes del CIRCUITO Avanzado \n");
                        for(Map.Entry<String,HashMap> avanz : circuitoAvanzado.entrySet()){
                            String campo = avanz.getKey();
                            HashMap valor = avanz.getValue();
                            System.out.println(campo + ": " + valor );
                        }
                    }else{
                        System.out.println("Opción Inválida. Intente de nuevo");
                    }
                   break;
                case "5"://eliminar
                    System.out.println("Seleccione categoría a buscar entre 1, 2 o 3: ");
                    int circuitoDesinscribir = sc.nextInt();
                    if (circuitoDesinscribir>0 && circuitoDesinscribir<4){
                        //ojo colocar error si no ponde 1 2 o 3, o hacerlo en case
                        System.out.println("Seleccione DNI de participante a desinscribir");
                        String dniEliminar = sc.next();
                        if (circuitoDesinscribir == 1) {
                            boolean eliminoC = circuitoChico.keySet().removeIf(key -> key.equalsIgnoreCase(dniEliminar));
                            if (eliminoC) {
                                System.out.println("Participante: " + dniEliminar + " fue desinscrito!");
                            } else {
                                System.out.println("Participante no existe, no puede desinscribirse.");
                            }
                        } else if (circuitoDesinscribir == 2) {
                            boolean eliminoM = circuitoMedio.keySet().removeIf(key -> key.equalsIgnoreCase(dniEliminar));
                            if (eliminoM) {
                                System.out.println("Participante: " + dniEliminar + " fue desinscrito!");
                            } else {
                                System.out.println("Participante no existe, no puede desinscribirse.");
                            }
                        } else if (circuitoDesinscribir == 3) {
                            boolean eliminoA = circuitoAvanzado.keySet().removeIf(key -> key.equalsIgnoreCase(dniEliminar));
                            if (eliminoA) {
                                System.out.println("Participante: " + dniEliminar + " fue desinscrito!");
                            } else {
                                System.out.println("Participante no existe, no puede desinscribirse.");
                            }
                        } else {
                            System.out.println("Opción Inválida. Intente de nuevo");
                        }
                    }else{
                        System.out.println("Opción Inválida. Intente de nuevo");
                    }
                    break;
                case "6":
                    //como se sale?
                    break;
                default:
                    System.out.println("Opción Inválida, Intentar nuevamente.");
                    break;
            }

            System.out.println("\nDesea continuar Y/N? ");

            String resp = sc.next();
            if (resp.equalsIgnoreCase("y")) {
                continua = true;
            }else{
                continua = false;
            }
        }while (continua) ;

        sc.close();
    }

    //Método para Calcular monto a abonar de la inscripción
    public static String montoDeInscripcion(String categoriaElegida, String edad){
        String devuelve;
        int edadInt = Integer.parseInt(edad);

        final String CHICOMENOR = "1300";
        final String CHICOMAYOR = "1500";

        final String MEDIOMENOR = "2000";
        final String MEDIOMAYOR = "2300";

        final String AVANZADOMAYOR = "2800";

        if(categoriaElegida.equalsIgnoreCase("1")){
            if(edadInt < 18){
                devuelve = CHICOMENOR;
            }else{
                devuelve = CHICOMAYOR;
            }
        }else if(categoriaElegida.equalsIgnoreCase("2")){
            if(edadInt < 18){
                devuelve = MEDIOMENOR;
            }else{
                devuelve = MEDIOMAYOR;
            }
        }else {//3
            devuelve = AVANZADOMAYOR;//RECUERDA QUE NO HAY PARA MENORES
        }
        System.out.println("\nMonto a abonar: " + devuelve);
        return devuelve;
    }


}
