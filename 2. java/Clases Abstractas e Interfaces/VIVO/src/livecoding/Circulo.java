package livecoding;

public class Circulo extends FiguraGeometrica implements Rotable{
    private float radio;

    public Circulo(int posX, int poxY, float radio) {
        super(posX, poxY);
        this.radio = radio;
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    public Circulo() {}

    @Override
    public double calcularArea() {
        return (Math.PI*(Math.pow(radio,2)));
    }

    @Override
    public void graficarFigura() {
        System.out.println("Se grafica el Circulo");
    }

    @Override
    public void rotarFigura() {
        System.out.println("Circulo rotado");
    }
}
