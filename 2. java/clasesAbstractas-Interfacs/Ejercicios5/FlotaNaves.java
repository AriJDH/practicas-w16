package Ejercicios5;

import java.util.ArrayList;
import java.util.List;

public class FlotaNaves implements Distanciable {
    private List<Nave> flotaNaves;

    public FlotaNaves(List nave) {
        this.flotaNaves = nave;
    }

    public List<Nave> getFlotaNaves() {
        return flotaNaves;
    }

    public void setFlotanaves(List<Nave> flotanaves) {
        this.flotaNaves = flotanaves;
    }

    @Override
    public double coordenadaADistancia() {
        var result = flotaNaves.stream().mapToDouble(nave -> nave.coordenadaADistancia()).sum();
        var flotita = flotaNaves.size();
        return Math.round(result)/flotita;
    }
}
