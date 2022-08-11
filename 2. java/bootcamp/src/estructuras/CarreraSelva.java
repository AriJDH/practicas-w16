package estructuras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CarreraSelva {

    public static int identificador;
    static HashMap<Integer, ArrayList<String>> circuitoChico = new HashMap<Integer, ArrayList<String>>();
    static HashMap<Integer, ArrayList<String>> circuitoMedio = new HashMap<Integer, ArrayList<String>>();
    static HashMap<Integer, ArrayList<String>> circuitoAvanzado = new HashMap<Integer, ArrayList<String>>();

    public static void main(String[] args) {
        identificador=0;

        int opcion = -1;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("Menu Principal. Por favor, digite la opción que desee : \n 1: Inscribir participante \n " +
                    "2: Mostrar Participantes \n 3: Eliminar Participante \n 4: Ver monto a pagar \n 5: Salir");

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    inscribirParticipante();
                    break;
                case 2:
                    mostrarParticipantes();
                    break;
                case 3:
                    eliminarParticipante();
                    break;
                case 4:
                    obtenerMonto();
                    break;
            }
        }while (opcion != 5);

        teclado.close();
    }


    private static void inscribirParticipante(){
        ArrayList<String> datos = new ArrayList<String>();
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese en que categoría va a inscribir al participante : \n 1: Circuito Chico \n " +
                "2: Circuito Medio \n 3: Circuito Avanzado");

        int circuito = teclado.nextInt();

        teclado = new Scanner(System.in);
        System.out.println("Ingrese DNI del participante : ");
        datos.add(teclado.nextLine());

        System.out.println("Ingrese Nombre del participante : ");
        datos.add(teclado.nextLine());

        System.out.println("Ingrese apellido del participante : ");
        datos.add(teclado.nextLine());

        System.out.println("Ingrese edad del participante : ");
        String edad = teclado.nextLine();
        datos.add(edad);
        int parseEdad = Integer.valueOf(edad);
        if (circuito == 3 && parseEdad < 18) {
            System.out.println("No se permiten inscripciones a menores de 18 a este circuito");
        }
        else {
            System.out.println("Ingrese celular del participante : ");
            datos.add(teclado.nextLine());

            System.out.println("Ingrese Número de emergencia del participante : ");
            datos.add(teclado.nextLine());

            System.out.println("Ingrese Grupo Sanguíneo del participante : ");
            datos.add(teclado.nextLine());

            System.out.print("Participante inscripto correctamente. ");
            if (circuito == 1) {
                circuitoChico.put(identificador, datos);
                if (parseEdad < 18)
                    System.out.println("El monto a abonar es : $1300");
                else
                    System.out.println("El monto a abonar es : $1500");
            } else if (circuito == 2) {
                circuitoMedio.put(identificador, datos);
                if (parseEdad < 18)
                    System.out.println("El monto a abonar es : $2000");
                else
                    System.out.println("El monto a abonar es : $2300");
            } else if (circuito == 3) {
                circuitoAvanzado.put(identificador, datos);
                System.out.println("El monto a abonar es : $2800");
            }

            identificador++;
        }
    }

    private static void mostrarParticipantes(){
        HashMap<Integer, ArrayList<String>> participantes;

        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese de que categoría quiere ver los participantes : \n 1 : Circuito Chico \n " +
                "2: Circuito Medio \n 3: Circuito Avanzado");

        int circuito = teclado.nextInt();

        if (circuito == 1 )
            participantes = circuitoChico;
        else if (circuito == 2)
            participantes = circuitoMedio;
        else if (circuito == 3)
            participantes = circuitoAvanzado;
        else
            participantes = new HashMap<Integer, ArrayList<String>>();

        for (Integer id : participantes.keySet()){
            System.out.println("Participante : " + id);
            ArrayList<String> datos = participantes.get(id);
            System.out.println("DNI : " + datos.get(0));
            System.out.println("Nombre : " + datos.get(1));
            System.out.println("Apellido : " + datos.get(2));
            System.out.println("Edad : " + datos.get(3));
            System.out.println("Celular : " + datos.get(4));
            System.out.println("Num de Emergencia : " + datos.get(5));
            System.out.println("Grupo Sanguíneo : " + datos.get(6));

            System.out.println();
        }
    }

    private static void eliminarParticipante(){
        System.out.println("Ingrese el identificador del participante que quiere eliminar: ");

        Scanner teclado = new Scanner(System.in);
        int id = teclado.nextInt();

        if (circuitoChico.containsKey(id))
            circuitoChico.remove(id);
        else if (circuitoMedio.containsKey(id))
            circuitoMedio.remove(id);
        else if (circuitoAvanzado.containsKey(id))
            circuitoAvanzado.remove(id);
        else
            System.out.println("Participante no existe");

        System.out.println("Participante eliminado");
    }

    private static void obtenerMonto(){
        System.out.println("Ingrese el identificador del participante que quiere saber el monto a pagar: ");

        Scanner teclado = new Scanner(System.in);
        int id = teclado.nextInt();
        int monto = 0;

        if (circuitoChico.containsKey(id)) {
            ArrayList<String> datos = circuitoChico.get(id);
            int edad = Integer.valueOf(datos.get(3));
            if (edad < 18)
                monto = 1300;
            else
                monto = 1500;
        }
        else if (circuitoMedio.containsKey(id)) {
            ArrayList<String> datos = circuitoChico.get(id);
            int edad = Integer.valueOf(datos.get(3));
            if (edad < 18)
                monto = 2000;
            else
                monto = 2300;
        }
        else if (circuitoAvanzado.containsKey(id))
            monto = 2800;

        System.out.println("El monto a abonar es: " + monto);
    }

}
