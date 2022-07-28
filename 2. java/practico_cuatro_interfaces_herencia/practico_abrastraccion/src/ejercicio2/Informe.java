package ejercicio2;

public class Informe implements  Print<Informe>{

    private String texto;
    private int canPaginas;
    private String autor;
    private String revisor;


    @Override
    public String printDocument(Informe obj) {
        return null;
    }
}
