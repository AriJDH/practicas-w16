package main;

public class Circulo extends FiguraGeometrica implements Rotable{
    private float radio;

    public Circulo(int posX, int posY, float radio) {
        super(posX, posY);
        this.radio = radio;
    }

    public Circulo() {

    }

    @Override
    public double calcularArea() {
        double v = Math.PI * (Math.pow(radio, 2));
        return v;
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    @Override
    public void graficarFigura() {
        System.out.println("Ciculo graficable");
    }

    @Override
    public void rotar() {
        System.out.println("circulo rotando");
    }
}
