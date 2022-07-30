package main;

public class Main {
    public static void main(String[] args) {

        Circulo circulo = new Circulo();
        circulo.setRadio(2);

        Triangulo triangulo = new Triangulo(5,5,2,4);
        double result = triangulo.calcularArea();

        System.out.println("resp triangulo - "+result);
        triangulo.graficarFigura();

        System.out.println("resp circulo - "+ circulo.calcularArea());
        circulo.graficarFigura();
        circulo.rotarFigura(90);

    }
}
