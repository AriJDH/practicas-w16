package clases_abs_int.asteroid.models;

public class Asteroide {
    private int x;
    private int y;

    public Asteroide(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("Asteroide en la posicion: (%s, %s).", this.x, this.y);
    }
}
