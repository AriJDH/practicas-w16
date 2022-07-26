package func;

import clases.Circuito;
import clases.Participante;

import java.util.*;

public class Main {

    public static int siguienteNum = 1;
    public static Circuito circuitoChico = new Circuito("Chico", 1300, 1500);
    public static Circuito circuitoMedio = new Circuito("Chico", 2000, 2300);
    public static Circuito circuitoAvanzado = new Circuito("Chico", -1, 2800);
    public static Map<Integer, Integer> map_participantes_general = new HashMap<>(); //{ NroParticipante, NroCircuito }

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu(){
        Scanner teclado = new Scanner(System.in);
        int menuSeleccionado;

        System.out.println("------------------------------------------------------");
        System.out.println("Seleccione una opcion");
        System.out.println("------------------------------------------------------");
        System.out.println("1: Agregar participante");
        System.out.println("2: Mostrar inscriptos");
        System.out.println("3: Desinscribir participante");
        System.out.println("------------------------------------------------------");
        menuSeleccionado = teclado.nextInt();

        switch(menuSeleccionado){
            case 1:
                nuevoParticipante();
                break;
            case 2:
                mostrarInscriptos();
                break;
            case 3:
                desinscribirParticipante();
                break;
        }
    }

    public static void backToMainMenu(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("------------------------------------------------------");
        System.out.println("Presione ENTER tecla para volver al menu.");
        System.out.println("------------------------------------------------------");
        teclado.nextLine();
        mainMenu();
    }

    public static void nuevoParticipante(){
        Participante p = crearParticipante();
        agregarACircuito(p);
    }

    public static Participante crearParticipante(){

        Participante nuevo = new Participante();
        nuevo.nroParticipante = siguienteNum;
        siguienteNum++;

        return nuevo;
    }

    public static void agregarACircuito(Participante nuevo){

        int circuitoSeleccionado = 0;

        Scanner teclado = new Scanner(System.in);
        System.out.println("------------------------------------------------------");
        System.out.println("Seleccione el circuito");
        System.out.println("------------------------------------------------------");

        if(nuevo.edad >= 18)
            System.out.println("1: Corto, 2: Medio, 3: Avanzado");
        else
            System.out.println("1: Corto, 2: Medio");

        circuitoSeleccionado = teclado.nextInt();
        double precio = 0;

        switch(circuitoSeleccionado){
            case 1:
                circuitoChico.agregarParticipante(nuevo);
                precio = circuitoChico.getPrecio(nuevo);
                map_participantes_general.put(nuevo.nroParticipante, 1);
                break;
            case 2:
                circuitoMedio.agregarParticipante(nuevo);
                precio = circuitoMedio.getPrecio(nuevo);
                map_participantes_general.put(nuevo.nroParticipante, 2);
                break;
            case 3:
                circuitoAvanzado.agregarParticipante(nuevo);
                precio = circuitoAvanzado.getPrecio(nuevo);
                map_participantes_general.put(nuevo.nroParticipante, 3);
                break;
        }

        System.out.println("Debe abonar: $ " + precio);
        backToMainMenu();
    }

    public static void mostrarInscriptos(){

        Scanner teclado = new Scanner(System.in);
        int menuSeleccionado;

        System.out.println("------------------------------------------------------");
        System.out.println("Seleccione un circuito");
        System.out.println("------------------------------------------------------");
        System.out.println("1: Circuito chico");
        System.out.println("2: Circuito medio");
        System.out.println("3: Circuito avanzado");
        System.out.println("------------------------------------------------------");
        menuSeleccionado = teclado.nextInt();

        switch(menuSeleccionado){
            case 1:
                circuitoChico.listarParticipantes();
                break;
            case 2:
                circuitoMedio.listarParticipantes();
                break;
            case 3:
                circuitoAvanzado.listarParticipantes();
                break;
        }

        backToMainMenu();
    }

    public static void desinscribirParticipante(){
        Scanner teclado = new Scanner(System.in);
        int nro;
        int circuitoSeleccionado;

        System.out.println("------------------------------------------------------");
        System.out.println("Desinscribir participante");
        System.out.println("------------------------------------------------------");
        System.out.println("Ingrese el numero del participante:");
        nro = teclado.nextInt();

        circuitoSeleccionado = map_participantes_general.get(nro);

        boolean eliminado = false;
        switch(circuitoSeleccionado){
            case 1:
                eliminado = circuitoChico.eliminarParticipante(nro);
                break;
            case 2:
                eliminado = circuitoMedio.eliminarParticipante(nro);
                break;
            case 3:
                eliminado = circuitoAvanzado.eliminarParticipante(nro);
                break;
        }

        if(eliminado){
            map_participantes_general.remove(nro);
            System.out.println("Participante eliminado correctamente.");
        }
        else{
            System.out.println("No se encontro el participante.");
        }

        backToMainMenu();
    }
}
