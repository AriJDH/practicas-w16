package clasesAbstractasEInterfacesVivo.ejercicioDos;

public class Informe implements Imprimir{
    private int cantidadPaginas;
    private int longitudTexto;
    private String autor;
    private String revisor;

    public Informe() {
    }

    public Informe(int cantidadPaginas, int longitudTexto, String autor, String revisor) {
        this.cantidadPaginas = cantidadPaginas;
        this.longitudTexto = longitudTexto;
        this.autor = autor;
        this.revisor = revisor;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public int getLongitudTexto() {
        return longitudTexto;
    }

    public void setLongitudTexto(int longitudTexto) {
        this.longitudTexto = longitudTexto;
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
    public void Imprimir() {
        System.out.println("El informe tiene un texto de longitud de "+ this.longitudTexto
                +" su autor es "+this.autor+ " fue revisado por "+this.revisor+" y tiene "+ this.cantidadPaginas
                +" paginas");
    }
}
