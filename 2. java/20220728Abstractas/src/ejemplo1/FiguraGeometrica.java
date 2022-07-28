package ejemplo1;

public abstract class FiguraGeometrica {
    private int posX;
    private int posY;

    public FiguraGeometrica(int n, int m){
        posX = n;
        posY = m;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public FiguraGeometrica(){}

    public abstract double calcularArea();

    public void mensaje(){
        System.out.println("Este es un mjke");
    }
}
