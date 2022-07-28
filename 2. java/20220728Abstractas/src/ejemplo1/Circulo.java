package ejemplo1;

public class Circulo extends FiguraGeometrica implements Rotable, Graficable{
    private float radio;

    public Circulo(int n, int m, float radio) {
        super(n, m);
        this.radio = radio;
    }

    public Circulo(){}

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI*(Math.pow(radio,2));
    }

    @Override
    public void graficarFigura() {
        System.out.println("Circulo graficado");
    }

    @Override
    public void rotar() {
        System.out.println("Circulo rotado");
    }
}
