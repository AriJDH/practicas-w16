package clasesAbstractas_Interfaces.ejercicio_2;


public class Informe implements Imprimible{

    private int longitud;
    private int cantidadPaginas;
    private String autor;
    private String revisro;

    public Informe() {
    }

    public Informe(int longitud, int cantidadPaginas, String autor, String revisro) {
        this.longitud = longitud;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisro = revisro;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
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

    public String getRevisro() {
        return revisro;
    }

    public void setRevisro(String revisro) {
        this.revisro = revisro;
    }

    @Override
    public String imprimir() {
        return "Informe: \n" +
                "   Longitud = " + longitud + "\n" +
                "   Cantidad de paginas = " + cantidadPaginas + "\n" +
                "   Autor = " + autor + "\n" +
                "   Revisor = " + revisro + "\n";
    }
}
