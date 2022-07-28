package practivaEnVivo2;

public class Libro implements Imprimir{
    public Libro(){}

    @Override
    public void imprimirDocumento() {
        System.out.println("Se imprimio el Libro PDF");
    }
}
