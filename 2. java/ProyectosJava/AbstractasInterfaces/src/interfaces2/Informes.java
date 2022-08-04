package abstractasInterfases.interfaces2;

public class Informes implements Imprimible{

    private double longitud;
    private int cantDePaginas;
    private String autor;
    private String revisor;

    public Informes(double longitud, int cantDePaginas, String autor, String revisor) {
        this.longitud = longitud;
        this.cantDePaginas = cantDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informes{" +
                "longitud=" + longitud +
                ", cantDePaginas=" + cantDePaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }
}
