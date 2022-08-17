package Ejercicio5.clases;


import java.util.List;

public class FlotaNave extends Composite {
    private List<Composite> flotaNaves;

    public FlotaNave(List<Composite> flotaNaves) {
        this.flotaNaves = flotaNaves;
    }

    public List<Composite> getFlotaNaves() {
        return flotaNaves;
    }

    public void setFlotaNaves(List<Composite> flotaNaves) {
        this.flotaNaves = flotaNaves;
    }

    @Override
    public double calcularDistancia(Coordenada coordenadaObjetivo) {
        double sumaDeDistancias = 0;
        for(Composite nave: this.flotaNaves){
            sumaDeDistancias += nave.calcularDistancia(coordenadaObjetivo);
        }
        double distanciaPromedio = sumaDeDistancias / this.flotaNaves.size();

        return distanciaPromedio;
    }
}
