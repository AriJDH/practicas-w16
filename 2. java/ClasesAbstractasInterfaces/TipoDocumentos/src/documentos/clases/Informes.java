package documentos.clases;

import documentos.interfaces.Imprimible;

public class Informes implements Imprimible {

    private String texto;
    private int cantidadPag;
    private String autor;
    private String revisor;

    public Informes(String texto, int cantidadPag, String autor, String revisor) {
        this.texto = texto;
        this.cantidadPag = cantidadPag;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCantidadPag() {
        return cantidadPag;
    }

    public void setCantidadPag(int catidadPag) {
        this.cantidadPag = catidadPag;
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
    public void imprimir(String documento) {
        System.out.println("-----------------------");
        System.out.println(documento);
        System.out.println("Resumen: "+this.texto);
        System.out.println("Cantidad de Páginas: "+this.cantidadPag);
        System.out.println("Autor: "+this.autor);
        System.out.println("Revisor: "+this.revisor);
    }
}
