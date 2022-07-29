package Main;

public class Circulo extends FiguraGeometrica{
    private float radio;

    public Circulo(int x, int y, float radio) {
        super(x, y);
        this.radio = radio;
    }

    public Circulo() {}

    @Override
    public double calcularArea() {
        return Math.PI*(Math.pow(radio,2));
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }
}
