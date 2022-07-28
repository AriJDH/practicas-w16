package ejercicioDos.documentos;

import ejercicioDos.interfaces.Imprimible;

public class Informes implements Imprimible {
    private int longitudTexto;
    private int cantidadPaginas;
    private String autor;
    private String revisor;

    public Informes() {
    }

    public Informes(int longitudTexto, int cantidadPaginas, String autor, String revisor) {
        this.longitudTexto = longitudTexto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public int getLongitudTexto() {
        return longitudTexto;
    }

    public void setLongitudTexto(int longitudTexto) {
        this.longitudTexto = longitudTexto;
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
        return "Informes{" +
                "longitudTexto=" + longitudTexto +
                ", cantidadPaginas=" + cantidadPaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }
}
