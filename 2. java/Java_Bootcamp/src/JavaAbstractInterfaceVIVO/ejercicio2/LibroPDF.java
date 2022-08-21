package JavaAbstractInterfaceVIVO.ejercicio2;

public class LibroPDF implements Imprimible {
    private int cantidadDePaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public LibroPDF(int cantidadDePaginas, String nombreAutor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String documento() {
        return "Libro PDF : " +
                "\n N° de Paginas   : " + cantidadDePaginas +
                "\n nombreAutor     : " + nombreAutor +
                "\n titulo          : " + titulo +
                "\n genero          : " + genero;
    }
}
