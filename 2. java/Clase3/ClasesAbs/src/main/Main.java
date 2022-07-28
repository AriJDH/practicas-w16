package main;

public class Main {
    public static void main(String[] args) {
        Circulo fig=new Circulo();
        fig.setRadio(2);
        System.out.println(fig.getRadio());
        Triangulo fig1=new Triangulo(5,5,2,4);
        double result=fig.calcularArea();
        System.out.println(result);
        fig.graficable();
        fig.rotable();

        fig1.graficable();

        result=fig1.calcularArea();
        System.out.println(result);
    }
}
