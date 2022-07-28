package main;

public class main {

    public static void main(String[] args) {
        Circulo fig = new Circulo();
        FiguraGeometrica fig2 = new Triangulo(5,5,2,4);

        fig.setRadio(2);

        double result = fig2.calcularArea();
        System.out.println("result = "+ result);
        fig.graficarFigura();
        fig.rotar();

        result = fig.calcularArea();
        System.out.println("result = "+ result);
        ((Triangulo)fig2).graficarFigura();


    }
}
