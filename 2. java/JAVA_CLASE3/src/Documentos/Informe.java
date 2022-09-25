package Documentos;

public class Informe implements IImprimibleService {

    private String texto;
    private Integer cantPaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, Integer cantPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }
    public Informe (){}

    public String getTexto() {return texto;}
    public Integer getCantPaginas() {return cantPaginas;}
    public String getAutor() {return autor;}
    public String getRevisor () {return revisor;}

    public void setTexto(String texto) {this.texto = texto;}
    public void setCantPaginas(Integer cantPaginas) {this.cantPaginas = cantPaginas;}
    public void setAutor(String autor) {this.autor = autor;}
    public void setRevisor(String revisor) {this.revisor = revisor;}

    @Override
    public void imprimible() {
        System.out.println("Imprimiendo Informe: " + "Texto: " + this.texto
                +","+ " Cantidad de paginas: "+ this.cantPaginas +","+ " Autor : "
                + this.autor +","+ " Revisor : " + this.revisor);
    }
}
