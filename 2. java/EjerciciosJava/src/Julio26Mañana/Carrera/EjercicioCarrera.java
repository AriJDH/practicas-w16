package Julio26Mañana.Carrera;

import jdk.jfr.Category;

import java.sql.SQLOutput;
import java.util.*;

public class EjercicioCarrera {

    private static enum categoria{chico,mediano,avanzada};
    private static int numeroInscripcion = 0;
    private static Map<String,categoria> usuarios = new HashMap<String,categoria>();

    private static List<Map> carreraChica = new ArrayList<Map>();
    private static List<Map> carreraMediana = new  ArrayList<Map>();
    private static List<Map> carreraAvanzada = new ArrayList<Map>();

   //dni, nombre, apellido, edad, celular, número de emergencia y grupo sanguíneo,numeroCarrera
    public static void imprimirLista(List<Map> lista)
    {
        System.out.println("Dni      Nombre    Apellido   Edad  Celular   NumeroEmergencia  GrupoSanguineo  Numero_de_carrera");
        for(Map<String,String> elemento :lista)
        {
            //System.out.println(elemento.get("DNI")+elemento.get("Nombre")+elemento.get("Apellido")+elemento.get("Edad")+elemento.get("Celular")+elemento.get("NumEmergencia")+elemento.get("GrupoSang")+elemento.get("numeroInscripcion"));
            System.out.println(elemento);
        }
    }
    public static Map buscarUsuario(List<Map> lista,String dni){
        for(Map<String,String> element:lista)
        {
            if(element.get("DNI").equals(dni))
            {
                return element;

            }
        }
        return null;
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void ingresarUsuario(String dni,String nombre,String apellido,String edad,String celular,String numEmergencia,String grupoSang,int carrera)
    {
        numeroInscripcion ++;
        Map<String,String> nuevoUsuario = new HashMap<String,String>();
        nuevoUsuario.put("DNI",dni);
        nuevoUsuario.put("Nombre",nombre);
        nuevoUsuario.put("Apellido",apellido);
        nuevoUsuario.put("Edad",edad);
        nuevoUsuario.put("Celular",celular);
        nuevoUsuario.put("NumEmergencia",numEmergencia);
        nuevoUsuario.put("GrupoSang",grupoSang);
        nuevoUsuario.put("numeroInscripcion",Integer.toString( numeroInscripcion));


        switch(carrera)
        {
            case 1:
                carreraChica.add(nuevoUsuario);
                usuarios.put(dni,categoria.chico);
                break;
            case 2:
                carreraMediana.add(nuevoUsuario);
                usuarios.put(dni,categoria.mediano);
                break;
            case 3:
                carreraAvanzada.add(nuevoUsuario);
                usuarios.put(dni,categoria.avanzada);
                break;

        }

    }
    public static void inscribirParticipante()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("ingrese el Dni:");
        String dni = sc.next();

        if(!usuarios.containsKey(dni))
        {
            System.out.println("ingrese el Nombre:");
            String nombre = sc.next();
            System.out.println("ingrese el apellido:");
            String apellido = sc.next();
            System.out.println("ingrese el edad:");
            String edad = sc.next();
            System.out.println("ingrese el celular:");
            String celular = sc.next();
            System.out.println("ingrese el Numero de emergencia:");
            String numero_de_emergencia = sc.next();
            System.out.println("ingrese el grupo sanguineo:");
            String grupoSanguineo = sc.next();
            clearScreen();
            System.out.println("A que carrera lo desea inscribir:");
            System.out.println("1_ Chica");
            System.out.println("2_ Mediana");
            System.out.println("3_ Avanzada");
            int tipoCarrera = sc.nextInt();

            ingresarUsuario(dni,nombre,apellido,edad,celular,numero_de_emergencia,grupoSanguineo,tipoCarrera);

        }else
        {
            System.out.println("ese usuario esta inscripto a la carrera" + usuarios.get(dni));
        }
        clearScreen();
    }
    public static void mostrarInscripciones()
    {
        System.out.println("Elija una categoria");
        System.out.println("1_ Chica");
        System.out.println("2_ Mediana");
        System.out.println("3_ Avanzada");
        Scanner sc = new Scanner(System.in) ;
        int opcion = sc.nextInt();
        List<Map> listaAImprimir = new ArrayList<>();
        switch(opcion)
        {
            case 1:
                listaAImprimir = carreraChica;
                break;
            case 2:
                listaAImprimir = carreraMediana;
                break;
            case 3:
                listaAImprimir = carreraAvanzada;
                break;

        }
        imprimirLista(listaAImprimir);
        clearScreen();
    }
    public static void desInscribirParticipante()
    {
        System.out.println("Ingrese el DNI del participante:");
        Scanner sc = new Scanner(System.in);

        String dni = sc.next();
        if (usuarios.containsKey(dni))
        {
            categoria carrerainscripta = usuarios.get(dni);
            System.out.println("Este Usuario esta inscripto en la carrera "+carrerainscripta+" esta seguro que desea eliminarlo?");
            String opcion = sc.next();
            if(opcion.equals("y")||opcion.equals("si"))
            {
                usuarios.remove(dni);
                List<Map>listaContenedora = new ArrayList<>();
                switch (carrerainscripta){
                    case chico:
                        listaContenedora = carreraChica;
                        break;
                    case mediano:
                        listaContenedora = carreraMediana;
                        break;
                    case avanzada:
                        listaContenedora = carreraAvanzada;
                        break;
                }
                boolean encontro = false;
                int i = 0;
                while (i< listaContenedora.size() && !encontro)
                {
                    if (listaContenedora.get(i).get("DNI").equals(dni)){encontro = true;}
                    else{i++;}
                }
                listaContenedora.remove(i);
                System.out.println("se elimino completamente el usuario del sistema");
            }else{
                System.out.println("no se elimino el usuario");
            }

        }else{
            System.out.println("Ese usuario no esta inscripto a ninguna carrera");
        }
        clearScreen();
    }
    public static void determinarMontoApagar()
    {
        System.out.println("Ingrese el DNI de la persona que desea ver el monto a pagar");
        Scanner sc = new Scanner(System.in);
        String dni = sc.next();
        if (usuarios.containsKey(dni))
        {
            categoria cat = usuarios.get(dni);
            Map<String,String> usuario;
            int monto = 0 ;
            switch (cat){
                case chico:
                    usuario = buscarUsuario(carreraChica,dni);
                    if(Integer.parseInt(usuario.get("Edad")) <= 18){monto =1300;}
                    else{monto = 1500;}
                    break;
                case mediano:
                    usuario = buscarUsuario(carreraMediana,dni);
                    if(Integer.parseInt(usuario.get("Edad")) <= 18){monto = 2000;}
                    else{monto = 2300;}
                    break;
                case avanzada:
                     usuario = buscarUsuario(carreraAvanzada,dni);
                    if(Integer.parseInt(usuario.get("Edad")) > 18){monto =2800;}
                    break;
            }
        }else{
            System.out.println("Ese usuario no esta ingresado en el sistema");
        }
    }

    public static void main(String[] args) {

        boolean exit = false;
        int opcion;
        Scanner sc = new Scanner(System.in);
        while(!exit)
        {
            System.out.println("Lista de opciones:");
            System.out.println("1_inscribir un nuevo participante");
            System.out.println("2_mostrar todos los inscriptos de una categoria");
            System.out.println("3_Desinscribir a un participante de una categoria");
            System.out.println("4_determinar el monto a pagar");
            System.out.println("otro para salir");
            opcion = sc.nextInt();

            switch (opcion)
            {
                case 1:
                    inscribirParticipante();
                    break;
                case 2:
                    mostrarInscripciones();
                    break;
                case 3:
                    desInscribirParticipante();
                    break;
                case 4:
                    determinarMontoApagar();
                    break;
                default:
                    exit = !true;
            }

        }

    }
}
