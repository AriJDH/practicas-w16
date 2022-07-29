package Main;

public abstract class FiguraGeometrica {
    private int posx;
    private int posy;

    public FiguraGeometrica(int x, int y){
        posx=x;
        posy=y;

    }
    public FiguraGeometrica(){}

    public void mensaje(){
        System.out.println(" ");
    }

    public abstract double calcularArea();
}
