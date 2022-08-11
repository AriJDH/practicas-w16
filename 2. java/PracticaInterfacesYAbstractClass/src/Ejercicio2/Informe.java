package Ejercicio2;

public class Informe extends Escrito implements Imprimible{
    private String texto;
    private String revisor;

    public Informe(String autor, int cantidadPaginas, String texto, String revisor) {
        super(autor, cantidadPaginas);
        this.texto = texto;
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "{" +
                "texto='" + texto + '\'' +
                ", revisor='" + revisor + '\'' +
                ", autor='" + autor + '\'' +
                ", cantidadPaginas='" + cantidadPaginas + '\'' +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo Informe:");
        System.out.println(this.toString());
    }
}
