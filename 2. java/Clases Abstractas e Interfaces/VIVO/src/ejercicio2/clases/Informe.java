package ejercicio2.clases;

import ejercicio2.interfaces.Imprimible;

public class Informe implements Imprimible {
    private String texto;
    private String autor;
    private String revisor;
    private int cantidadPaginas;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public Informe() {
    }

    public Informe(String texto, String autor, String revisor, int cantidadPaginas) {
        this.texto = texto;
        this.autor = autor;
        this.revisor = revisor;
        this.cantidadPaginas = cantidadPaginas;
    }

    @Override
    public void imprimir() {
        System.out.println("\n\nImprimiendo informe... \n");
        System.out.println("Texto: ");
        System.out.println(this.texto);
        System.out.println("Cant. paginas: " + cantidadPaginas);
        System.out.println("Autor: " + this.autor);
        System.out.println("Revisor: " + this.revisor);

    }
}
