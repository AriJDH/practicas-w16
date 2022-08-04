package main;

public class Main {

    public static void main(String[] args) {

        Circulo circulo = new Circulo();
        circulo.setRadio(2);

        FiguraGeometrica triangulo = new Triangulo(5, 5, 2, 4);

        System.out.println(circulo.calcularArea());
        System.out.println(triangulo.calcularArea());


        circulo.graficarFigura();
        triangulo.graficarFigura();
    }
}
