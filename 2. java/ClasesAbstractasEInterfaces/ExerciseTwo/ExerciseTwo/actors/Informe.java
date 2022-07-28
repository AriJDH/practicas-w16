package ExerciseTwo.actors;

public class Informe extends Documento{
    private StringBuffer texto;
    private int cantidadPaginas;
    private String autor;
    private String revisor;

    public Informe(StringBuffer texto, int cantidadPaginas, String autor, String revisor) {
        super("Informe");
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    /*
     * GETTERS 
     */

    public StringBuffer getTexto() {
        return texto;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public String getRevisor() {
        return revisor;
    }

    /*
     * SETTERS 
     */

    public void setTexto(StringBuffer texto) {
        this.texto = texto;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informe{" + "texto=" + texto + ", cantidadPaginas=" + cantidadPaginas + ", autor=" + autor + ", revisor=" + revisor + '}';
    }

}
