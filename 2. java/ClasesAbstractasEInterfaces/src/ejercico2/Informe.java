package ejercico2;

public class Informe {
    private String texto;
    private int longitud;
    private int cantidadPaginas;
    private String autor;
    private String revisor;


    public Informe(String texto, int longitud, int cantidadPaginas, String autor, String revisor) {
        this.texto = texto;
        this.longitud = longitud;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public Informe() {
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informe\n" +
                 texto +
                "\n" + longitud +
                "\n" + cantidadPaginas +
                "\n" + autor +
                "\n" + revisor;
    }
}
