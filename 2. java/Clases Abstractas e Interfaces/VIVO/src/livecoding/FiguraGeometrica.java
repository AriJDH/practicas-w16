package livecoding;

public abstract class FiguraGeometrica implements Graficable{

    private int posX;
    private int posY;

    public FiguraGeometrica(int posX, int poxY){
        this.posX = posX;
        this.posY = poxY;
    }

    public FiguraGeometrica(){}

    public abstract double calcularArea();
}
