package poo.figuraGeometrica;

public class Circulo extends FiguraGeometrica implements Rotable, Graficable {

    private float radio;

    public Circulo(int posX, int posY, float radio) {
        super(posX, posY);
        this.radio = radio;
    }

    public Circulo() {
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * (Math.pow(radio, 2));
    }

    @Override
    public void graficarFigura() {
        System.out.println("Circulo graficado!");
    }

    @Override
    public void rotar() {
        System.out.println("Circulo rotando!");
    }
}
