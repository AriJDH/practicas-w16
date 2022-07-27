package com.bootcamp.ejercicio1;

public class PracticaExcepciones {

  public static Integer a = 0;
  public static Integer b = 300;

  public static void calcular() {
    try {
      double division = b/a;
    } catch (Exception e) {
      throw new IllegalArgumentException("No se puede dividir por cero");
    } finally {
      System.out.println("Programa finalizado");
    }
  }

  public static void main(String[] args) {
    calcular();
  }
}
