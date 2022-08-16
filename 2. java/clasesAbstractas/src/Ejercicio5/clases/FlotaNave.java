package Ejercicio5.clases;

import Ejercicio5.interfaces.INaveDistancia;

import java.util.List;

public class FlotaNave implements INaveDistancia {
    private List<NaveSimple> flotaNaves;

    public FlotaNave(List<NaveSimple> flotaNave) {
        this.flotaNaves = flotaNave;
    }

    public List<NaveSimple> getFlotaNaves() {
        return flotaNaves;
    }

    public void setFlotaNaves(List<NaveSimple> flotaNaves) {
        this.flotaNaves = flotaNaves;
    }

    @Override
    public double calcularDistancia(Double x, Double y) {
        double resultado = 0;
        double distancia = 0;
        int cantNaves = this.flotaNaves.size();
        for (int i = 0; i < cantNaves; i++) {
            NaveSimple naveSimple = this.flotaNaves.get(i);
            distancia += naveSimple.calcularDistancia(x, y);
        }
        resultado = distancia/cantNaves;
        return resultado;
    }
}
