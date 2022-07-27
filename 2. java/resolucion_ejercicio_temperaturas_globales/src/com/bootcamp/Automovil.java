package com.bootcamp;

public class   Automovil {

        String marca;
        String color;
        double kilometros;
        String modelo;

public Automovil(String marca,String color,double kilometros,String modelo){
        this.marca = marca;
        this.color = color;
        this.kilometros = kilometros;
        this.modelo=modelo;
        }



public Automovil(String marca,String color,double kilometros) {
        this.marca = marca;
        this.color = color;
        this.kilometros = kilometros;
        }

public String mostrarMarcaYColor() {
        return "La marca del auto es: " + marca + ". El color del auto es: " + color;

        }
        }

