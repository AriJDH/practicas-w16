package JavaAbstractInterfaceVIVO.figurasGeometricas;

public class Main {

    public static void main(String[] args) {
        Circulo circulo = new Circulo();
        circulo.setRadio(2);
        FiguraGeometrica triangulo = new Triangulo(5, 5, 2, 4);

        double resultado = circulo.calcularArea();
        System.out.println("Area: " + resultado);

        resultado = triangulo.calcularArea();
        System.out.println("Area: " + resultado);

        circulo.rotar();
    }
}
