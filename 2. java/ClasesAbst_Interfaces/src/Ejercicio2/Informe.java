package Ejercicio2;

public class Informe implements Imprimible{
    protected String resumen;
    protected int cantidadPaginas;
    protected String autor;
    protected String revisor;

    public Informe(String resumen, int cantidadPaginas, String autor, String revisor) {
        this.resumen = resumen;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Resumen del informe: \n" + resumen);
        System.out.println("Este informe contiene " + cantidadPaginas + " paginas, fue escrito por " + autor + " y revisado por " + revisor);
    }
}
