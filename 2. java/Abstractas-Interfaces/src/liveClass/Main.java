package liveClass;

public class Main {
    public static void main(String[] args) {
        Circulo circulo = new Circulo();
        circulo.setRadio(2);

        FiguraGeometrica triangulo = new Triangulo(5,5,2,4);

        double resul = circulo.calcularArea();

        System.out.println("El area del circulo es : "+ resul);

        circulo.graficarFigura();
        circulo.rotar();



    }
}
