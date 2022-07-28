package com.bootcamp;

import java.util.*;

public class Main {
  static List<Map> circuitoChico = new ArrayList<>();
  static List<Map> circuitoMedio = new ArrayList<>();
  static List<Map> circuitoAvanzado = new ArrayList<>();
  static Scanner input = new Scanner(System.in);
  static String separador = "===================================";
  static String optionMenu = "Por favor elija una opcion: ";
  static Integer numeroCircuito = 0;
  static Integer numeroTotalParticipantes = 0;

  public static void menuPrincipal() {
    System.out.println(separador);
    System.out.println("Bienvenido a la aplicacion");
    System.out.println("1. Inscribir participante");
    System.out.println(separador);
    System.out.print(optionMenu);
    Integer option = input.nextInt();
    input.nextLine();
    if (option == 1) menuInscribirParticipante();
  }

  public static void menuInscribirParticipante() {
    System.out.println(separador);
    System.out.println("Para que carrera desea inscribir \nel participante");
    System.out.println("1. Circuito Chico");
    System.out.println("2. Circuito Medio");
    System.out.println("3. Circuito Avanzado");
    System.out.println(separador);
    System.out.print(optionMenu);
    Integer optionCircuito = input.nextInt();
    numeroCircuito = optionCircuito;
    input.nextLine();
    menuDatosPersonales(optionCircuito);
  }

  public static void inscribirParticipante(String dni, String nombre, String apellido, String edad, String celular,
                                           String numeroEmergencia, String grupoSanguineo) {
    if (!validarInscripcion(dni)) menuPrincipal();
    Map<String, String> participante = new HashMap<>();
    participante.put("dni", dni);
    participante.put("nombre", nombre);
    participante.put("apellido", apellido);
    participante.put("edad", edad);
    participante.put("celular", celular);
    participante.put("numeroEmergie", numeroEmergencia);
    participante.put("grupoSanguineo", grupoSanguineo);
    participante.put("numeroParticipante", (String.valueOf(numeroTotalParticipantes + 1)));
    if (numeroCircuito.equals(1)) circuitoChico.add(participante);
    if (numeroCircuito.equals(2)) circuitoMedio.add(participante);
    if (numeroCircuito.equals(3)) circuitoAvanzado.add(participante);
    System.out.println(separador);
    montoAbonar(Integer.valueOf(edad));
  }

  public static void menuDatosPersonales(Integer optionCircuito) {
    System.out.println(separador);
    System.out.println("Ingrese su DNI: ");
    String dni = input.nextLine();
    System.out.println("Ingrese su nombre: ");
    String nombre = input.nextLine();
    System.out.println("Ingrese su apellido: ");
    String apellido = input.nextLine();
    System.out.println("Ingrese su edad: ");
    String edad = input.nextLine();
    System.out.println("Ingrese su celular");
    String celular = input.nextLine();
    System.out.println("Ingrese numero de emergencia: ");
    String numeroEmergencia = input.nextLine();
    System.out.println("Ingrese su grupo sanguineo: ");
    String grupoSanguineo = input.nextLine();
    inscribirParticipante(dni, nombre, apellido, edad, celular, numeroEmergencia, grupoSanguineo);
  }

  public static boolean validarInscripcion(String dni) {
    List<Map> circuitos = new ArrayList<>();
    circuitos.addAll(circuitoChico);
    circuitos.addAll(circuitoMedio);
    circuitos.addAll(circuitoAvanzado);
    numeroTotalParticipantes = circuitos.size();
    for (Map participante : circuitos) {
      if (participante.get("dni").equals(dni)) {
        System.out.println("***** El participante ya esta inscrito en una carrera");
        return false;
      }
    }
    return true;
  }

  public static void montoAbonar(Integer edad) {
    StringBuilder mensaje = new StringBuilder();
    String textoAuxiliar = "***** El usuario se ha registrado correctamente\nEl total a pagar es ";
    if (numeroCircuito.equals(1)) {
      if (edad < 18) mensaje.append(textoAuxiliar).append("$1300");
      else mensaje.append(textoAuxiliar).append("$1500");
    }
    if (numeroCircuito.equals(2)) {
      if (edad < 18) mensaje.append(textoAuxiliar).append("$2000");
      else mensaje.append(textoAuxiliar).append("$2300");
    }
    if (numeroCircuito.equals(3)) {
      if (edad < 18) mensaje.append("No se permite inscripciones a menores de 18 años.");
      else mensaje.append(textoAuxiliar).append("$2800");
    }
    mensaje.append("\n" + separador);
    System.out.println(mensaje);
    System.out.println("Precione cualquier tecla para continuar");
    input.nextLine();
    menuPrincipal();
  }

  public static void main(String[] args) {
    menuPrincipal();
  }
}
