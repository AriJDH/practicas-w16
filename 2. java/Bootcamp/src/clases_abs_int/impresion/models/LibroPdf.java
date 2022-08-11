package clases_abs_int.impresion.models;

import clases_abs_int.impresion.interfaces.IImprimir;

public class LibroPdf implements IImprimir {
    private int cantidadPaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
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

    public LibroPdf(int cantidadPaginas, String nombreAutor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("IMPRIMIENDO LIBRO EN PDF:");
        System.out.printf("La obra titulada %s escrita por %s, cuenta con %s páginas y es del género %s.\n",
                this.titulo, this.nombreAutor, this.cantidadPaginas, this.genero
        );
        System.out.println();
    }
}
