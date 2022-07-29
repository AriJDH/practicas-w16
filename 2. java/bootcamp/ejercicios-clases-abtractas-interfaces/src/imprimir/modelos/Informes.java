package imprimir.modelos;

import imprimir.interfaces.Documento;

public class Informes implements Documento {

    private String texto;
    private int paginas;
    private String autor;
    private String revisor;

    public Informes(){}

    public Informes(String texto, int paginas, String autor, String revisor) {
        this.texto = texto;
        this.paginas = paginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informe" + "\n-Texto: "+ texto + "\n-Cantidad paginas: " + paginas + "\n-Autor: " + autor + "\n-Revisor: "+ revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
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
}
