package ejemplo1;

public class Main {
    public static void main(String[] args) {
        Circulo fig = new Circulo();
        fig.setRadio(2);
        System.out.println("Valor del area fig: " + fig.calcularArea());
        Triangulo fig2 = new Triangulo(5,5,2,4);
        double result = fig2.calcularArea();
        System.out.println("Area fig2: " + result);
        fig.rotar();
        fig.graficarFigura();
        fig2.graficarFigura();

    }
}
