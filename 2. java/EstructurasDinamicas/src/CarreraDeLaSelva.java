import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CarreraDeLaSelva {

  private static Scanner teclado;

  public static void agregar(HashMap<Integer, String> mapa1, ArrayList<Integer> listaChico, ArrayList<Integer> listaMedio, ArrayList<Integer> listaAvanzado) {

    String participante = null;
    String circuito = null;
    teclado = new Scanner(System.in);

    int edad;
    int id;
    int abono = 0;
    System.out.println("¿Cuantos participantes desea agregar?");
    int cantidad = teclado.nextInt();
    for (int i = 0; i < cantidad; i++) {

      System.out.println("Ingrese el nombre del participante:");
      participante = teclado.next();
      id = i + 1;
      mapa1.put(id, participante);

      System.out.println("¿Que edad tiene?");
      edad = teclado.nextInt();

      System.out.println("¿Desea inscribirse al circuito chico, medio o avanzado?");
      circuito = teclado.next();

      if (edad < 18 && circuito.equals("avanzado")) {
        System.out.println("Debe ser mayor de 18 para inscribirse en el circuito avanzado");
        break;
      } else if (edad < 18 && circuito.equals("medio")) {
        abono = 2000;
      } else if (edad < 18 && circuito.equals("chico")) {
        abono = 1300;
      } else if (edad >= 18 && circuito.equals("avanzado")) {
        abono = 2800;
      } else if (edad >= 18 && circuito.equals("medio")) {
        abono = 2300;
      } else if (edad >= 18 && circuito.equals("chico")) {
        abono = 1500;
      }

      switch (circuito) {
        case "chico":
          listaChico.add(id);
          System.out.println("agregado a " + circuito);
          break;
        case "medio":
          listaMedio.add(id);
          System.out.println("agregado a " + circuito);
          break;
        case "avanzado":
          listaAvanzado.add(id);
          System.out.println("agregado a " + circuito);
          break;
        default:
          System.out.println("Debe ingresar un circuito valido");
          break;
      }
      System.out.println(participante + " ha sido inscripto satisfactoriamente!");
      System.out.println("El numero del participante es:" + i);
      System.out.println("Debe abonar: $" + abono + "\n\n");
    }
    teclado.close();
  }

  public static void mostrarInscriptos(HashMap<Integer, String> mapa1, ArrayList<Integer> listaChico, ArrayList<Integer> listaMedio, ArrayList<Integer> listaAvanzado) {

    System.out.println("R E S U M E N");
    System.out.println("-------------------------");
    System.out.println("I N S C R I T O S");
    System.out.println("-------------------------");
    System.out.println("Numero\tNombre\n------\t-");
    for (Map.Entry datos : mapa1.entrySet()) {
      System.out.print(datos.getKey() + "\t\t");
      System.out.println(datos.getValue());
    }
    System.out.println("\n\n---------------------");
    System.out.println("C I R C U I T O S");
    System.out.println("-------------------------");

    System.out.print("Participantes inscriptos en el circuito CHICO: ");
    for (int i = 0; i < listaChico.size(); i++) {
      System.out.print(mapa1.get(listaChico.get(i)) + ", ");
    }
    System.out.println("");

    System.out.print("Participantes inscriptos en el circuito MEDIO: ");
    for (int i = 0; i < listaMedio.size(); i++) {
      System.out.print(mapa1.get(listaMedio.get(i)) + ", ");
    }
    System.out.println("");

    System.out.print("Participantes inscriptos en el circuito AVANZADO: ");
    for (int i = 0; i < listaAvanzado.size(); i++) {
      System.out.print(mapa1.get(listaAvanzado.get(i)) + ", ");
    }
    System.out.println("");
  }

  public static void main(String[] args) {

    HashMap<Integer, String> participantes = new HashMap<>();
    ArrayList<Integer> circuitoChico = new ArrayList<>();
    ArrayList<Integer> circuitoMedio = new ArrayList<>();
    ArrayList<Integer> circuitoAvanzado = new ArrayList<>();
    agregar(participantes, circuitoChico, circuitoMedio, circuitoAvanzado);
    mostrarInscriptos(participantes, circuitoChico, circuitoMedio, circuitoAvanzado);

  }
}