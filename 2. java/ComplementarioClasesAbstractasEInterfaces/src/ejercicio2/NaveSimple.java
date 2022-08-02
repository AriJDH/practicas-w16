package ejercicio2;

public class NaveSimple implements Icompetidor {
    Nave nave;

    public NaveSimple(Nave nave) {
        this.nave = nave;
    }

    @Override
    public double calcularDistancia(int coorX, int coorY) {

        return Math.sqrt(Math.pow(nave.getCorrdenadaX()-coorX,2)+Math.pow(nave.getCoordenadaY()-coorY,2));
    }
}
