package com.bootcamp.ejercicio2.documentos;

import com.bootcamp.ejercicio2.interfaces.Imprimible;

public class Main {
  public static void main(String[] args) {
    Curriculum a = new Curriculum();
    System.out.println(a.getClass().getSimpleName().equals("Curriculum"));
  }
}
