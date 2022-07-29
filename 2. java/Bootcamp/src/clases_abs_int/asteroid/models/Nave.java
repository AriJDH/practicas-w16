package clases_abs_int.asteroid.models;

import clases_abs_int.asteroid.interfaces.ILogicaNave;

import java.util.Scanner;

public class Nave implements ILogicaNave {
    private String nombre;
    private int marcador;
    private int x;
    private int y;

    public Nave() {
        this.marcador = 0;
        this.crearNave();
    }

    public void crearNave(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el nombre para la nave: ");
        this.nombre = sc.nextLine();
        System.out.println("Ingresa la posicion en x:");
        this.x = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingresa la posicion en y:");
        this.y = sc.nextInt();
        sc.nextLine();
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
