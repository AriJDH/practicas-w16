package main;

public class Circulo extends FigurasGeometricas{
    private float radio;

    public Circulo() {}

    public Circulo(int posX, int posY, float radio) {
        super(posX, posY);
        this.radio = radio;
    }
    public double calcularArea(){
        return Math.PI*(Math.pow(radio,2));
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }
}
