package Imprimir;

public class Informe implements IImprimir{
    private int longitud;
    private int cantidadPagina;
    private String Autor;
    private String Revisor;

    public Informe(int longitud, int cantidadPagina, String autor, String revisor) {
        this.longitud = longitud;
        this.cantidadPagina = cantidadPagina;
        Autor = autor;
        Revisor = revisor;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getCantidadPagina() {
        return cantidadPagina;
    }

    public void setCantidadPagina(int cantidadPagina) {
        this.cantidadPagina = cantidadPagina;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getRevisor() {
        return Revisor;
    }

    public void setRevisor(String revisor) {
        Revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimir Informe");
    }
}
