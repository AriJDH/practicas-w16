package livecoding;

public class Main {
    public static void main(String[] args) {
        Circulo figura = new Circulo();
        figura.setRadio(2);

        Triangulo figura2 = new Triangulo(5,5,2,4);

        double resultado1 = figura.calcularArea();
        System.out.println("Resultado Circulo: " + resultado1);
        figura.graficarFigura();
        figura.rotarFigura();


        double resultado2 = figura2.calcularArea();
        System.out.println("Resultado Triangulo: " + resultado2);
        figura2.graficarFigura();
    }
}
