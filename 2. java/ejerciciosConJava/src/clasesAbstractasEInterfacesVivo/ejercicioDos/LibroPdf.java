package clasesAbstractasEInterfacesVivo.ejercicioDos;

public class LibroPdf implements Imprimir{
    private int cantidadPaginas;
    private String autor;
    private String titulo;
    private String genero;

    public LibroPdf() {
    }

    public LibroPdf(int cantidadPaginas, String autor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
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
    public void Imprimir() {
        System.out.println("El titulo del libro es "+ this.titulo
                +" su autor es "+this.autor+ " es del genero "+this.genero+" y tiene "+ this.cantidadPaginas
                +" paginas");
    }
}
