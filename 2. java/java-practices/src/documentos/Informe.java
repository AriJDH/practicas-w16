package documentos;

public class Informe extends Documento implements Imprimible {
    private String texto;
    private int cantidadDePaginas;
    private String autor;
    private String revisor;

    public Informe(){
        this.texto = "";
        this.cantidadDePaginas = 0;
        this.autor = "";
        this.revisor = "";
    }

    public Informe(String texto, int cantidadDePaginas, String autor, String revisor){
        this.texto = texto;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCantidadDePaginas() {
        return this.cantidadDePaginas;
    }

    public void setCantidadDePaginas(int cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRevisor() {
        return this.revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    @Override
    public void imprimirContenido() {
        System.out.println("Informe impreso.");
    }
}
