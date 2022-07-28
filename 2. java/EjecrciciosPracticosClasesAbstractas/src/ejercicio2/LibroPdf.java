package ejercicio2;

public class LibroPdf implements Imprimible{
    int cantPaginas;
    String nombreAutor;
    String Titulo;
    String Genero;

    public LibroPdf(int cantPaginas, String nombreAutor, String titulo, String genero) {
        this.cantPaginas = cantPaginas;
        this.nombreAutor = nombreAutor;
        Titulo = titulo;
        Genero = genero;
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    @Override
    public String toString() {
        return "LibroPdf{" +
                "cantPaginas=" + cantPaginas +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", Titulo='" + Titulo + '\'' +
                ", Genero='" + Genero + '\'' +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }
}
