package ClaseEnVivo;

public class Circulo extends FiguraGeometrica implements Rotable{
    private float radio;

    public Circulo(int posX, int posY, float radio) {
        super(posX, posY);
        this.radio = radio;
    }

    public Circulo() {}

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return (Math.PI*(Math.pow(radio,2)));
    }

    @Override
    public void graficarFigura() {
        System.out.println("El circulo es graficable");
    }

    @Override
    public void rotable() {
        System.out.println("El círculo es rotable");
    }
}
