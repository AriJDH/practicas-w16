package JavaAbstractInterfaceVIVO.figurasGeometricas;

public class Triangulo extends FiguraGeometrica {
    private float base;
    private float altura;


    public Triangulo() {
    }

    public Triangulo(int x, int y, float base, float altura) {
        super(x, y);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return (base * altura) / 2;
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
    public void graficarFigura() {
        System.out.println("Triangulo Graficado");
    }
}
