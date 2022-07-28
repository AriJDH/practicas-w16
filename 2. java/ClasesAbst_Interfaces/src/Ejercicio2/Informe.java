package Ejercicio2;

public class Informe implements Imprimible{
    private String resumen;
    private int cantidadPaginas;
    private String autor;
    private String revisor;

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
