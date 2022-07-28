package ejemplo1;

public class Triangulo extends FiguraGeometrica implements Graficable {
    private float base;
    private float altura;

    public Triangulo  ( int poX, int y, float base, float altura){
        super(poX, y);
        this.base = base;
        this.altura = altura;
    }

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

    public Triangulo(int poX, int y){
        super(poX, y);
    }

    public Triangulo (){}

    @Override
    public double calcularArea() {
        return (base*altura)/2;

    }

    @Override
    public void graficarFigura() {
        System.out.println("Triangulo Graficado");
    }
}
