package main;

public class Circulo extends FiguraGeometrica implements Rotable {
    private float radio;

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }
    public Circulo(int posX, int posY, float radio) {
        super(posX, posY);
        this.radio = radio;
    }

    public Circulo(){
    }

    @Override
    public double calcularArea() {
        return Math.PI * (radio * radio);
    }

    @Override
    public void graficarFigura() {
        System.out.println("Circulo gradicado");
    }

    @Override
    public void rotarFigura(int grados) {
        System.out.println("Circulo rotado "+grados+" grados");
    }
}
