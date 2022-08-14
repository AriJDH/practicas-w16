package ClaseEnVivo;

public class Triangulo extends FiguraGeometrica{
    private float base;
    private float altura;

    public Triangulo(int posX, int posY, float base, float altura) {
        super(posX, posY);
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
        System.out.println("El triangulo es graficable");
    }
}
