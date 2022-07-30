package EjercicioFigurasGeometricas;

public class Main {
    public  static void main(String[] args){
        Circulo fig = new Circulo();
        fig.setRadio(2);
        FiguraGeometrica fig2 = new Triangulo();

        double resul = fig.calcularArea();
        System.out.println("Resultado= "+ resul);

        resul = fig2.calcularArea();
        System.out.println("Resultado= "+ resul);


    }
}
