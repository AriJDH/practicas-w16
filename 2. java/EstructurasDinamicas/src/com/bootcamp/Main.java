package com.bootcamp;

import java.util.*;

public class Main {
  static List<Map> circuitoChico = new ArrayList<>();
  static List<Map> circuitoMedio = new ArrayList<>();
  static List<Map> circuitoAvanzado = new ArrayList<>();

  public static void inserUser(String nombre, String dni, String edad, List<Map> lista) {
    Map<String, String> map = new HashMap<String, String>();
    map.put("nombre", nombre);
    map.put("dni", dni);
    map.put("edad", edad);
    lista.add(map);
  }

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    Integer option = input.nextInt();
    while (option != 0) {
      System.out.println("Ingrese su nombre");
      String nombre = inputString.nextLine();
      System.out.println("Ingrese su dni");
      String dni = inputString.nextLine();
      System.out.println("Ingrese su edad");
      String edad = inputString.nextLine();
//      inserUser(nombre, dni, edad, carrera1);
      option = input.nextInt();
    }

//    System.out.println(carrera1);

//    List<String> listaPersonas = new LinkedList<String>();
//    Map<Integer, String> map = new HashMap<Integer, String>();

  }
}
