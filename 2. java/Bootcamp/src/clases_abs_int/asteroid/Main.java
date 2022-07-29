package clases_abs_int.asteroid;

import clases_abs_int.asteroid.models.Juego;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Vamo a juga 🕹");
        Scanner sc = new Scanner(System.in);
        Juego juego = new Juego(4, 2, 20, 20);
        juego.jugar();
        sc.close();
    }
}
