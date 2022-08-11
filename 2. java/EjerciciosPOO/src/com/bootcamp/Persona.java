package com.bootcamp;

public class Persona {
  String nombre;
  Integer edad;
  String dni;
  Double peso;
  Double altura;

  public Persona() {
  }

  public Persona(String nombre, Integer edad, String dni) {
    this.nombre = nombre;
    this.edad = edad;
    this.dni = dni;
  }

  public Persona(String nombre, Integer edad, String dni, Double peso, Double altura) {
    this.nombre = nombre;
    this.edad = edad;
    this.dni = dni;
    this.peso = peso;
    this.altura = altura;
  }

  public Integer calcularIMC() {
    Double imc = (this.peso / (Math.pow(this.altura, 2)));
    if (imc < 20) return -1;
    else {
      if (imc <= 25) return 0;
      return 1;
    }
  }

  public boolean esMayorDeEdad() {
    return this.edad >= 18;
  }

  @Override
  public String toString() {
    return "Soy " + nombre + " y mis datos con los siguientes {" +
        " edad=" + edad +
        ", dni='" + dni + '\'' +
        ", peso=" + peso +
        ", altura=" + altura +
        '}';
  }

  public String getNombre() {
    return nombre;
  }

  public Integer getEdad() {
    return edad;
  }

  public String getDni() {
    return dni;
  }

  public Double getPeso() {
    return peso;
  }

  public Double getAltura() {
    return altura;
  }
}
