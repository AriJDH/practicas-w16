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
    }

    public void agregarNave(Nave nave){
        this.naves.add(nave);
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
