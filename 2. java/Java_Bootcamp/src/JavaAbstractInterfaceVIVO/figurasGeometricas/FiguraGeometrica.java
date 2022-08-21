package JavaAbstractInterfaceVIVO.figurasGeometricas;

public abstract class FiguraGeometrica implements Graficable {
    private int posX;
    private int posY;

    public FiguraGeometrica() {
    }

    public FiguraGeometrica(int x, int y) {
        posX = x;
        posY = y;
    }

    public void mensaje() {
        System.out.println("Esto es un mensaje");
    }

    public abstract double calcularArea();
}
