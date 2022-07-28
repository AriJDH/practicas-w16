package livecoding;

public class Triangulo extends FiguraGeometrica {

    private float base;
    private float altura;

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public Triangulo(int posX, int poxY, float base, float altura) {
        super(posX, poxY);
        this.base = base;
        this.altura = altura;
    }

    public Triangulo() {}

    @Override
    public double calcularArea() {
        return ((base*altura)/2);
    }

    @Override
    public void graficarFigura() {
        System.out.println("Se grafica el triangulo");
    }
}
