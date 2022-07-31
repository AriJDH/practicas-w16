package documentos.clases;

import documentos.interfaces.Imprimible;

public class LibrosPDF implements Imprimible {

    private int cantidadPag;
    private String autor;
    private String titulo;
    private String genero;

    public LibrosPDF(int cantidadPag, String autor, String titulo, String genero) {
        this.cantidadPag = cantidadPag;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public int getCantidadPag() {
        return cantidadPag;
    }

    public void setCantidadPag(int cantidadPag) {
        this.cantidadPag = cantidadPag;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public void imprimir (String documento){
        System.out.println("-----------------------");
        System.out.println(documento);
        System.out.println("Cantidad de páginas: "+this.cantidadPag);
        System.out.println("Autor: "+this.autor);
        System.out.println("Título: "+this.titulo);
        System.out.println("Género: "+this.genero);
    }
}
