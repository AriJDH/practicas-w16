package Ejercicio2;

public class Informes implements Imprimible{
    private String texto;
    private int cantidadDePaginas;
    private String autor;
    private String revisor;

    public Informes() {
    }

    public Informes(String texto, int cantidadDePaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public void setCantidadDePaginas(int cantidadDePaginas) {
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
    public void imprimible() {
        System.out.println("Hola imprimiendo Informe : " +
                "texto='" + texto + '\'' +
                        ", cantidadDePaginas=" + cantidadDePaginas +
                        ", autor='" + autor + '\'' +
                        ", revisor='" + revisor + '\'' +
                        '}');
    }
}
