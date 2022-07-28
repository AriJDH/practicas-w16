package estructurasDinamicas;

import java.util.*;

public class EjercicioEstructurasDinamicas {
    public static void main(String[] args) {


        ejecutarSistema();



    }
    static int contador = 1;
    static List<Map> chico = new ArrayList<Map>();
    static List<Map> medio = new ArrayList<Map>();
    static List<Map> avanzado = new ArrayList<Map>();
    public static void mostrarMenu(){
        System.out.println("Ingrese 1 para agregar participante");
        System.out.println("Ingrese 2 para mostrar todos los participante de una categoria");
        System.out.println("Ingrese 3 para borrar participante");
        System.out.println("Ingrese 4 para calcular cuanto debe abonar un participante");
        System.out.println("Ingrese 0 para salir");
    }

    public static void ejecutarSistema() {
        mostrarMenu();
        Scanner teclado = new Scanner(System.in);
        int opcionMenu;
        do {
            opcionMenu = Integer.parseInt(teclado.nextLine());

            if (opcionMenu == 1) {
                agregarParticipante();
            } else if (opcionMenu == 2) {
                    mostrarDatosParaUnaCategoria();
            } else if (opcionMenu == 3) {
                    removerParticipante();
            } else if (opcionMenu == 4) {
determinarMontoPagoParaParticipante();
            } else {
                System.out.println("La ejecucion ha finalizado");
            }
        } while (opcionMenu!=0);

    }

    private static void determinarMontoPagoParaParticipante() {
        int montoAPagar = 0;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese circuito al que se desea inscribir: ");
        String circuito = teclado.nextLine();
        System.out.println("Ingrese la edad del participante: ");
        String edad = teclado.nextLine();
        if(circuito.equals("chico")){
            if(Integer.parseInt(edad)<18){
                montoAPagar = 1300;
            }
            else {
                montoAPagar = 1500;
            }
        } else  if(circuito.equals("medio")){
            if(Integer.parseInt(edad)<18){
                montoAPagar = 2000;
            }
            else {
                montoAPagar =2300;
            }
        } else{
            montoAPagar =  2800;
        }
        System.out.println( "El participante que desea incribirse al circuito " + circuito + " y tiene " + edad + " años debe abonar $" + montoAPagar);
        ejecutarSistema();
    }

    private static void mostrarDatosParaUnaCategoria() {
        System.out.println("Ingrese para que categoria desea ver los datos (chico - medio - avanzado): ");
        Scanner teclado = new Scanner(System.in);   
        String categoria = teclado.nextLine();
        if(categoria.equals("chico")){
            mostarDatosCategiaDeUnaCategoriaRecibida(chico);
        }
        else if(categoria.equals("medio")){
            mostarDatosCategiaDeUnaCategoriaRecibida(medio);
        } else{
            mostarDatosCategiaDeUnaCategoriaRecibida(avanzado);
        }
      ejecutarSistema();
    }

    private static void mostarDatosCategiaDeUnaCategoriaRecibida(List<Map> lista) {
        if(lista.size()==0){
            System.out.println("No hay participantes registrados");
        }else {
            System.out.println("Informacion de los participantes: \n");
            for (Map<String, String> participante : lista
            ) {
                for (Map.Entry<String, String> entrada : participante.entrySet()
                ) {
                    System.out.println(entrada.getKey() + ": " + entrada.getValue());
                }
                System.out.println("------------------------------------------------");
            }
        }
    }

    private static void agregarParticipante() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese nombre: ");
        String nombre = teclado.nextLine();
        System.out.println("Ingrese apellido: ");
        String apellido = teclado.nextLine();
        System.out.println("Ingrese dni: ");
        String dni = teclado.nextLine();
        System.out.println("Ingrese edad: ");
        String edad = teclado.nextLine();
        System.out.println("Ingrese celular: ");
        String celular = teclado.nextLine();
        System.out.println("Ingrese numero de emergencia: ");
        String nroEmergencia = teclado.nextLine();
        System.out.println("Ingrese grupo sanguineo: ");
        String grupoSanguineo = teclado.nextLine();
        System.out.println("Ingrese circuito al cual se quiere inscribir (chico - medio - avanzado): ");
        String circuito = teclado.nextLine();

        Map<String, String> participante = new HashMap<String, String>();

        participante.put("nombre",nombre);
        participante.put("dni",dni);
        participante.put("apellido",apellido);
        participante.put("edad",edad);
        participante.put("celular",celular);
        participante.put("nroEmergencia",nroEmergencia);
        participante.put("grupoSanguineo",grupoSanguineo);
        participante.put("nroParticipante",""+ contador);
        contador++;
        agregarALista(participante,circuito);
        ejecutarSistema();


    }

    private static void agregarALista(Map<String, String> participante, String circuito) {
        if(circuito.equals("chico")){
            chico.add(participante);
        } else if(circuito.equals("medio")){
            medio.add(participante);
        }
        else{
            avanzado.add(participante);
        }
    }

    private static void removerParticipante(){

        System.out.println("Ingrese dni del participante que desea remover: ");
        Scanner teclado = new Scanner(System.in);
        String dni = teclado.nextLine();

        System.out.println("Ingrese categoria de la que desea eliminar el participante (Se asume que existe dicho participante en la categoria): ");
        String categoria = teclado.nextLine();

        if(categoria.equals("chico")){
            removerParticipanteSeleccionado(chico,dni);
        } else if(categoria.equals("medio")){
            removerParticipanteSeleccionado(medio,dni);
        } else{
                removerParticipanteSeleccionado(avanzado,dni);
        }
    ejecutarSistema();
    }

    private static void removerParticipanteSeleccionado(List<Map> lista, String dni){
        int posicion = 0;
        if(lista.size()==0){
            System.out.println("No hay participantes registrados");
        } else{
           int contador=0;
            for (Map<String, String> participante: lista
            ) {
                for (Map.Entry<String,String> entrada: participante.entrySet()
                ) {
                    if(entrada.getValue().equals(dni)){
                        posicion = contador;
                    }
                }
                contador ++;
            }

            lista.remove(posicion);

        }

    }

}



