package clases_abs_int.asteroid.models;

import clases_abs_int.asteroid.interfaces.ILogicaNave;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlotaNaves implements ILogicaNave {
    List<Nave> naves;

    @Override
    public String toString() {
        return this.naves.get(0).toString();
    }

    public FlotaNaves() {
        this.naves = new ArrayList<>();
        this.añadirNaves();
    }

    public void añadirNaves() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Creando flota: ");
        System.out.println("Ingrese la cantidad de naves:");
        int cantidadNaves = sc.nextInt();
        sc.nextLine();
        for(int i = 1; i <= cantidadNaves; i++) {
            System.out.printf("Creando nave %s:\n", i);
            this.naves.add(new Nave());
        }
    }

    @Override
    public int getMarcador() {
        return this.naves.get(0).getMarcador();
    }

    @Override
    public void incrementarMarcador() {
        this.naves.stream().forEach(nave -> nave.incrementarMarcador());
    }

    @Override
    public double calcularDistancia(int x, int y) {
        return this.naves.stream()
                .mapToDouble(n -> n.calcularDistancia(x,y))
                .average()
                .orElse(Double.NaN);
    }
}
