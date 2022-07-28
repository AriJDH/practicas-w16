package main;

public abstract class FigurasGeometricas {
    private int posX;
    private int posY;

    public FigurasGeometricas() {}

    public FigurasGeometricas(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
    public void mensaje(){
        System.out.println("hola este tiene una implmentacion");
    }
    public abstract double calcularArea();
}
