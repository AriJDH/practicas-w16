package clases_abs_int.asteroid.models;

import clases_abs_int.asteroid.interfaces.ILogicaNave;

import java.util.Scanner;

public class Nave implements ILogicaNave {
    private String nombre;
    private int marcador;
    private int x;
    private int y;

    public Nave() {}

    public Nave(String nombre, int x, int y) {
        this.marcador = 0;
        this.nombre = nombre;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("Nave:\n\t-Nombre: %s\n\t-Puntuación: %s",this.nombre, this.marcador);
    }
    @Override
    public void incrementarMarcador() {
        this.marcador += 1;
    }

    public int getMarcador() {
        return marcador;
    }

    @Override
    public double calcularDistancia(int x, int y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }
}
