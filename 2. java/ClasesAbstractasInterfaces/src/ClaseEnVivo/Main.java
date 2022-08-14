package ClaseEnVivo;

public class Main {

    public static void main(String[] args) {

        Circulo figura1 = new Circulo();
        figura1.setRadio(2);

        Triangulo figura2 = new Triangulo(5,5,2,4);

        double resultado = figura1.calcularArea();
        System.out.println("Area del circulo: " + resultado);
        System.out.println("Area del Triangulo: " + figura2.calcularArea());

        figura1.graficarFigura();
        figura1.rotable();

        figura2.graficarFigura();
    }

}
