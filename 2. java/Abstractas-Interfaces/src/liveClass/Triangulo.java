package liveClass;

public class Triangulo extends FiguraGeometrica implements Graficable{
    private float base;
    private float altura;

    public Triangulo(int posX, int posY, float base, float altura) {
        super(posX, posY);
        this.base = base;
        this.altura = altura;
    }

    public Triangulo(){
        super();
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

    @Override
    public double calcularArea() {
        return (base*altura)/2;
    }

    @Override
    public void graficarFigura() {
        System.out.println("Triangulo graficado");
    }
}
