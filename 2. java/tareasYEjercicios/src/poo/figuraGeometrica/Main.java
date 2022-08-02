package poo.figuraGeometrica;

public class Main {

    public static void main(String[] args) {

        Circulo circulo = new Circulo();
        circulo.setRadio(2);

        FiguraGeometrica triangulo = new Triangulo(5, 5, 2, 4);

        double result = circulo.calcularArea();
        System.out.println("El radio del circulo es: " + result);

        result = triangulo.calcularArea();
        System.out.println("El area del triangulo es: " + result);

        circulo.graficarFigura();
        circulo.rotar();


    }
}
