package estructuraDinamica;

import objetos.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    static List<Competidor> chico = new ArrayList<Competidor>();
    static List<Competidor> mediano = new ArrayList<Competidor>();
    static List<Competidor> grande = new ArrayList<Competidor>();
    static int secChico = 0;
    static int secMediano = 0;
    static int secGrande = 0;

    public static void inscribir(Competidor e, List m){
        System.out.println("Inscribo a "+ e.getNombre() + " a Circuito " + m);
        if (m.contains(e)){
            System.out.println(e.getNombre() + " ya existe en Circuito ");
        } else {

            m.add(e);
            System.out.println("Se agrego a " + e.getNombre() + " con el ID: " + secChico);
        }
    }

    public static void cargarParticipante(){

        Competidor c1 = new Competidor(123,"Daniel", "Condori", 31, 3512040,35120400,"A+");
        Competidor c2 = new Competidor(123,"Daniel1", "Condori1", 32, 3512040,35120400,"A+");
        Competidor c3 = new Competidor(123,"Daniel2", "Condori2", 33, 3512040,35120400,"A+");
        Competidor c4 = new Competidor(123,"Daniel3", "Condori3", 34, 3512040,35120400,"A+");
        Competidor c5 = new Competidor(123,"Daniel4", "Condori4", 35, 3512040,35120400,"A+");
        System.out.println("Cree competidores");
        inscribir(c1, chico);
        inscribir(c2, mediano);
        inscribir(c3, mediano);
        inscribir(c4, grande);
        inscribir(c5, chico);
        inscribir(c1, chico);

    }

    public static void eliminarParticipante(){
        System.out.println("EliminoParticipante");
    }

    public static void mostrarParticipantes(){
        System.out.println("MostarParticipante");
    }


    public static void main(String[] args) {
        System.out.println("1 - Cargar participante");
        System.out.println("2 - Elimilar participante");
        System.out.println("3 - Mostrar participantes");
        System.out.println("9 - Salir");
        System.out.print("Ingresa opcion: ");
        int opcion;
        Scanner teclado = new Scanner(System.in);
        opcion = teclado.nextInt();

        while (opcion != 9){
            switch (opcion){
                case 1: cargarParticipante();
                break;
                case 2: eliminarParticipante();
                    break;
                case 3: mostrarParticipantes();
                    break;
                case 4: cargarParticipante();
                    break;
                case 9:
                    break;
            }
            System.out.print("Ingresa opcion: ");
            teclado = new Scanner(System.in);
            opcion = teclado.nextInt();
        }
        System.out.println("Finalizado");
        teclado.close();
    }
}
