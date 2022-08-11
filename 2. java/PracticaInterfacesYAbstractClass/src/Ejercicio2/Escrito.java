package Ejercicio2;

public abstract class Escrito {
    protected String autor;
    protected int cantidadPaginas;

    public Escrito(String autor, int cantidadPaginas) {
        this.autor = autor;
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }
}
