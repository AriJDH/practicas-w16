package Impresora;

public class Informe implements Imprimible{

    String textoNlongitud;
    String cantidadDePaginas;
    String autor;
    String revisor;


    public Informe(String textoNlongitud, String cantidadDePaginas, String autor, String revisor) {
        this.textoNlongitud = textoNlongitud;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getTextoNlongitud() {
        return textoNlongitud;
    }

    public void setTextoNlongitud(String textoNlongitud) {
        this.textoNlongitud = textoNlongitud;
    }

    public String getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public void setCantidadDePaginas(String cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
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
    public void imprimir() {
        System.out.println("IMPRIMIENDO INFORME");
        System.out.println("Texto numero de Longitud: " + getTextoNlongitud());
        System.out.println("Cantidad de paginas: " + getCantidadDePaginas());
        System.out.println("Autor: " + getAutor());
        System.out.println("Revisor: " + getRevisor());
        System.out.println("/////////////////////////////////");
    }
}
