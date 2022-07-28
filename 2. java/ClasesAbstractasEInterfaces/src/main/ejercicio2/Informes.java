package main.ejercicio2;

public class Informes implements Imprimir{
    private String texto;
    private int cantidadDePaginas;
    private String nombreDelAutor;
    private String revisor;

    public Informes(String texto, int cantidadDePaginas, String nombreDelAutor, String revisor) {
        this.texto = texto;
        this.cantidadDePaginas = cantidadDePaginas;
        this.nombreDelAutor = nombreDelAutor;
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informes{" +
                "texto = " + texto +
                ", cantidad de paginas = " + cantidadDePaginas +
                ", nombre del autor = " + nombreDelAutor +
                ", revisor = " + revisor +
                "}";
    }
    @Override
    public void imprimirDocumento() {
        System.out.printf(this.toString());
    }
}
