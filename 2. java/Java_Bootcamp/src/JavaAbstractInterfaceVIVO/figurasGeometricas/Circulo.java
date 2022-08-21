package JavaAbstractInterfaceVIVO.figurasGeometricas;

public class Circulo extends FiguraGeometrica implements Rotable {
    private float radio;

    public Circulo() {
    }

    public Circulo(int x, int y, float radio) {
        super(x, y);
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * (Math.pow(radio, 2));
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    @Override
    public void graficarFigura() {
        System.out.println("Circulo Graficado");
    }

    @Override
    public void rotar() {
        System.out.println("Circulo Rotado");
    }
}
