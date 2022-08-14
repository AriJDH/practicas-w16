package ClaseEnVivo;

public abstract class FiguraGeometrica implements Graficable{
    private int posX;
    private int posY;

    public FiguraGeometrica(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public FiguraGeometrica() {}

    public abstract double calcularArea();
}
