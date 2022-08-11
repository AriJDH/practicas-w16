package absandint.ejercicio2;

public class Informe implements Documento{

   private String texto;
   private int cantPag ;
   private String autor;
   private String revisor;

    public Informe(String texto, int cantPag, String autor, String revisor) {
        this.texto = texto;
        this.cantPag = cantPag;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCantPag() {
        return cantPag;
    }

    public void setCantPag(int cantPag) {
        this.cantPag = cantPag;
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
    public void print() {
        System.out.println("Autor: " + this.autor + "\nRevisor: " + this.revisor + "\nTexto: "
                + this.texto + "\nCantidad de páginas: " + this.cantPag);
    }
}
