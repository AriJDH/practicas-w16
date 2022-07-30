package com.bootcamp;

public class Main {
  public static String getIMC(Integer imc){
    if(imc == -1) return "Bajo peso";
    if(imc == 0) return "Peso saludable";
    if(imc == 1) return "Sobrepeso";
    return "";
  }
  public static String isMayor(boolean edad){
    if(edad) return " Es mayor de edad";
    return " Es mejor de edad";
  }

  public static void main(String[] args) {
    Persona kevin = new Persona();
    Persona sergio = new Persona("sergio", 28, "1110583037");
    Persona mary = new Persona("Mary", 32, "1110583039", 53.0,1.60 );

//    Esto no es posible dado que no creamos un constructor que reciba solo estos dos parametros
//    Persona Marlon = new Persona("Marlon", 25);

    Integer imcMary = mary.calcularIMC();
    System.out.println("La persona " + mary.getNombre() + " tiene " + getIMC(imcMary));

    boolean esMayor = mary.esMayorDeEdad();
    System.out.println("La persona " + mary.getNombre() + isMayor(esMayor));

    System.out.println(mary);
  }
}
