package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Imprimible{
    protected String nombre;
    protected int edad;
    protected String[] habilidades;

    public Curriculum(String nombre, int edad, String[] habilidades){
        this.nombre = nombre;
        this.edad = edad;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Nombre: "+nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Lista de sus habilidades: ");
        for (int i = 0; i <habilidades.length ; i++) {
            System.out.println(habilidades[i]);
        }
    }
}
