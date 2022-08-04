package main;

public abstract class FiguraGeometrica implements Graficable{
    private int posX;
    private int posY;

    public FiguraGeometrica(int posX, int posY) {
        posX= posX;
        this.posY = posY;
    }

    public FiguraGeometrica() {

    }

    public void mensaje(){
        System.out.println("Hola soy una figura geométrica");
    }

    public abstract double calcularArea();



}
