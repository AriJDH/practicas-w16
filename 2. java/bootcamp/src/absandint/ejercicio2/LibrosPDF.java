package absandint.ejercicio2;

public class LibrosPDF implements Documento{

    private int cantPag;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public LibrosPDF(int cantPag, String nombreAutor, String titulo, String genero) {
        this.cantPag = cantPag;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public int getCantPag() {
        return cantPag;
    }

    public void setCantPag(int cantPag) {
        this.cantPag = cantPag;
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


    @Override
    public void print() {
        System.out.println("Autor: " + this.nombreAutor + "\nTitulo: " + this.titulo + "\nGénero: "
                + this.genero + "\nCantidad de páginas: " + this.cantPag);
    }



}
